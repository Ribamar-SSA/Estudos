package MaratonaJava.zzijdbc.repository;

import MaratonaJava.zzijdbc.conn.ConnectionFactory;
import MaratonaJava.zzijdbc.dominio.Producer;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    private static final Logger log = LogManager.getLogger(ProducerRepository.class);

    //salvar algo no banco de dados
    public static void save(Producer producer) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());

        //Statement objeto responsável por alterar os dados do bmentanco de dados
        //o try fecha sozinho a connection e o statement
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            int rowAffected = statement.executeUpdate(sql);
            log.info("rows affected '{}'", rowAffected);

        } catch (SQLException e) {
            log.error("error trying to insert '{}'", producer.getName());
            throw new RuntimeException(e);
        }
    }

    //queremos que todos os dados sejam inseridos no dba, ou nenhum seja, caso dê problema em algum deles
    public static void saveTransaction(List<Producer> producerList) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);//If a connection is in auto-commit mode, then all its SQL statements will be executed and committed as individual transactions.
            preparedStatementSaveTransaction(connection, producerList);
            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            log.error("error trying to insert '{}'", producerList,e);
            throw new RuntimeException(e);
        }
    }

    private static void preparedStatementSaveTransaction(Connection connection, List<Producer> producerList) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ( ? );";
        boolean shouldRollback = false;
        for (Producer p : producerList) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                log.info("X");
                preparedStatement.setString(1, p.getName());
                if(p.getName().equals("marcosxt")) throw new SQLException("can´t save marcosxt");
                preparedStatement.execute();
            }catch (SQLException e){
                e.printStackTrace();
                shouldRollback = true;
            }
        }
        //sem o rollback, passaria as duas inserções antes de lançar a exceção(atomicidade)
        if(shouldRollback)
            log.warn("trabnsaction is going be rollback");
            connection.rollback();

    }


    public static void delete(Producer producer) {

        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`idautor` = '%s');".formatted(producer.getId());

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            int rowAffected = statement.executeUpdate(sql);
            log.info("rows affected {}", rowAffected);

        } catch (SQLException e) {
            log.error("error trying to insert {}", producer.getName());
            throw new RuntimeException(e);
        }
    }

    public static void update(Producer producer) {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE (`id` = '%s');".formatted(producer.getName(), producer.getId());

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            int rowAffected = statement.executeUpdate(sql);
            log.info("rows affected {}", rowAffected);

        } catch (SQLException e) {
            log.error("error trying to update {}", producer.getName());
            throw new RuntimeException(e);
        }

    }

    public static void updatePrepared(Producer producer) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedUpdate = createPreparedUpdate(connection, producer);
            int rowsAffected = preparedUpdate.executeUpdate();
            log.info("rows afected {}", rowsAffected);

        } catch (SQLException e) {
            log.error("error trying to update {}", producer.getName());
            throw new RuntimeException(e);
        }

    }

    private static PreparedStatement createPreparedUpdate(Connection connection, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`idautor` = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
    }


    public static List<Producer> findAll() {
        //String sql = "SELECT name,id FROM anime_store.producer;";
        return findByName(" ");
    }

    public static List<Producer> findByName(String stringName) {
        String sql = "select * from anime_store.producer where name like '%s';".formatted("%" + stringName + "%");

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            //o metodo do statement realiza um consulta e retorna um valor ResultSet
            ResultSet resultSet = statement.executeQuery(sql);
            // Os métodos ResultSet permitem que o programa manipule o resultado da consulta.

            List<Producer> listOfProducers = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                Producer producer = Producer.builder().id(id).name(name).build();
                listOfProducers.add(producer);

            }

            return listOfProducers;

        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    public static void showProducerResultMetaData() {
        String sql = "select * from anime_store.producer";

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            //Os metadados descrevem o conteúdo do ResultSet. Os programas podem utilizar os metadados programaticamente para obter
            //informações sobre nomes de coluna e tipos do ResultSet.

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            log.info("column count '{}'", columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.info("Column name :{}", resultSetMetaData.getColumnName(i));
                log.info("Table  name: {}", resultSetMetaData.getTableName(i));
                log.info("column size :{}", resultSetMetaData.getColumnDisplaySize(i));
                log.info("column type :{}", resultSetMetaData.getColumnTypeName(i));

            }
        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    public static void showDriverMetaData() {
        log.info("showing driver metadata");
        try (Connection connection = ConnectionFactory.getConnection()) {
            //precisamos saber os metadados dessa conexão

            //Recupera um objeto DatabaseMetaData que contém metadados sobre o banco de dados
            // ao qual este objeto Connection representa uma conexão. Os metadados incluem informações
            // sobre as tabelas do banco de dados, a gramática SQL suportada, os procedimentos armazenados,
            // as capacidades dessa conexão, entre outros.

            DatabaseMetaData metaData = connection.getMetaData();
            //tipo ResultSet: TYPE_FORWARD_ONLY/TYPE_SCROLL_INSENSITIVE/TYPE_SCROLL_SENSITIVE

            if (metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("supports type forward only");

                // A concorrência do conjunto de resultados (Figura 24.27) especifica se o ResultSet
                //pode ser atualizado com os métodos de atualização do ResultSet.
                //CONCUR_READ_ONLY/CONCUR_UPDATABLE
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("and supports type CONCUR_UPDATABLE");

                }
                ;
            }

            //as alterações  feitas no ResultSet durante o
            // processamento do ResultSet não são refletidas no ResultSet

            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("supports type scroll insensitive");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

                    log.info("and supports updatabbble");
                }
            }

            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("supports type scroll SENSITIVE");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

                    log.info("and supports updatabbble");
                }
            }

        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    public static void showTypeScrollWorking() {

        log.info("show type scroll working");
        String sql = "select * from anime_store.producer";
        try (Connection connection = ConnectionFactory.getConnection()) {

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(sql);
            //A default ResultSet object is not updatable and has a cursor that moves forward only
            log.info("last row affected ? {}", resultSet.last());
            log.info(Producer.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());

            log.info("is first ? {}", resultSet.isFirst());
            log.info(Producer.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());


            log.info("next ? {}", resultSet.next());
            //log.info(Producer.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());
            //não vai conseguir imprimir porque está depois do último
            log.info("is after last ? {}", resultSet.isAfterLast());

            log.info("voltou ? {}", resultSet.relative(-1));
            log.info(Producer.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());
            log.info(resultSet.getRow());

            log.info("is last ? {}", resultSet.isLast());
            log.info(Producer.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Producer> findByNameAndUpdate(String stringName) {
        String sql = "select * from anime_store.producer where name like \"%%%s%%\";"
                .formatted(stringName);

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //o metodo do statement realiza um consulta e retorna um valor ResultSet
            ResultSet resultSet = statement.executeQuery(sql);
            // Os métodos ResultSet permitem que o programa manipule o resultado da consulta.

            List<Producer> listOfProducers = new ArrayList<>();
            while (resultSet.next()) {
                resultSet.updateString("name", resultSet.getString("name").toUpperCase());
                resultSet.updateRow();
                Producer producer = Producer
                        .builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
                listOfProducers.add(producer);
            }
            log.info(listOfProducers);
            return listOfProducers;

        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }


    public static List<Producer> findByNameAndInsertIfNotFOund(String stringName) {
        String sql = "select * from anime_store.producer where name like \"%%%s%%\";"
                .formatted(stringName);

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //o metodo do statement realiza um consulta e retorna um valor ResultSet
            ResultSet resultSet = statement.executeQuery(sql);
            // Os métodos ResultSet permitem que o programa manipule o resultado da consulta.
            List<Producer> listOfProducers = new ArrayList<>();
            //o resultSet já é um resultado do select
            if (!resultSet.next()) {
                resultSet.moveToInsertRow();
                resultSet.updateString("name", stringName);
                resultSet.insertRow();
                resultSet.beforeFirst();
                resultSet.next();
                Producer producer = Producer
                        .builder()
                        .id(resultSet.getInt("idautor"))
                        .name(resultSet.getString("name"))
                        .build();
                listOfProducers.add(producer);

            }
            return listOfProducers;
        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }


    public static List<Producer> findByNameAndDelete(String stringName) {
        String sql = "select * from anime_store.producer where name like \"%%%s%%\";"
                .formatted(stringName);

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(sql);
            List<Producer> listOfProducers = new ArrayList<>();

            while (resultSet.next()) {
                Producer producer = getProducer(resultSet);
                listOfProducers.add(producer);
                resultSet.deleteRow();
            }
            return listOfProducers;
        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    public static List<Producer> findByNameAndPreparedStatement(String stringName) {
        String sql = "SELECT * FROM anime_store.producer where name like ?;";

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = getPreparedStatement(stringName, connection, sql);
            ResultSet rs = ps.executeQuery();

            List<Producer> listOfProducers = new ArrayList<>();
            while (rs.next()) {
                Producer producer = getProducer(rs);
                listOfProducers.add(producer);
            }
            return listOfProducers;

        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    public static List<Producer> findByNameCallablePreparedStatement(String stringName) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = CallablePreparedStatement(stringName, connection);
            ResultSet rs = ps.executeQuery();

            List<Producer> listOfProducers = new ArrayList<>();
            while (rs.next()) {
                Producer producer = getProducer(rs);
                listOfProducers.add(producer);
            }
            return listOfProducers;

        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }


    private static PreparedStatement CallablePreparedStatement(String stringName, Connection conn) throws SQLException {
        String sql = "CALL `anime_store`.`sp_get_producer_by_name`(?);";
        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, String.format("%%%s%%", stringName));
        return cs;
    }

    private static PreparedStatement getPreparedStatement(String stringName, Connection connection, String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.format("%%%s%%", stringName));
        return statement;
    }


    private static Producer getProducer(ResultSet resultSet) throws SQLException {
        Producer producer = Producer
                .builder()
                .id(resultSet.getInt("idautor"))
                .name(resultSet.getString("name"))
                .build();
        return producer;
    }

    /*
    RowSet é uma versão melhorada do result set
    Result set não pode ser serializado
    o rowSet é scholable e updatable

    */
}
