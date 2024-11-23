package MaratonaJava.zzcrud.repository;

import MaratonaJava.zzcrud.conn.ConnectionFactory;
import MaratonaJava.zzcrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class ProduceRepository {

    public static List<Producer> findByName(String stringName) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = createPrepareStamentFindByName(stringName, connection);
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

    private static PreparedStatement createPrepareStamentFindByName(String stringName, Connection connection) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.format("%%%s%%", stringName));
        return statement;
    }

    private static Producer getProducer(ResultSet resultSet) throws SQLException {
        Producer producer = Producer
                .builder()
                .idautor(resultSet.getInt("idautor"))
                .name(resultSet.getString("name"))
                .build();
        return producer;
    }

    public static void delete(int idautor) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementDelete(connection, idautor)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createPrepareStatementDelete(Connection connection, Integer idautor) throws SQLException {
        String sql = ("DELETE FROM `anime_store`.`producer` WHERE (`idautor` = ?);");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idautor);
        return preparedStatement;
    }

    public static void save(Producer producer) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementSave(connection, producer)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createPrepareStatementSave(Connection connection, Producer producer) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ( ? );";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, producer.getName());
        return preparedStatement;
    }

    public static Optional<Producer> findById(Integer idautor) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = createPrepareStamentFindById(idautor, connection);
            ResultSet rs = ps.executeQuery();
            List<Producer> listOfProducers = new ArrayList<>();
            if (!rs.next()) return Optional.empty();
            return Optional.of(Producer
                    .builder()
                    .name(rs.getString("name"))
                    .idautor(rs.getInt("idautor"))
                    .build());


        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createPrepareStamentFindById(Integer idautor, Connection connection) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer where (idautor = ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idautor);
        return statement;
    }

    public static void update(Producer producer) {
        log.info("updating the producer '{}'",producer);
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = createPrepareStamentUpdate(producer, connection);
            ps.execute();
        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createPrepareStamentUpdate(Producer producer, Connection connection) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`idautor` = ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, producer.getName());
        statement.setInt(2, producer.getIdautor());
        return statement;
    }

}
