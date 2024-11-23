package MaratonaJava.zzcrud.repository;

import MaratonaJava.zzcrud.conn.ConnectionFactory;
import MaratonaJava.zzcrud.dominio.Anime;
import MaratonaJava.zzcrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class AnimeRepository {

    public static List<Anime> findByName(String stringName) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = createPrepareStamentFindByName(stringName, connection);
            ResultSet rs = ps.executeQuery();

            List<Anime> listOfanimes = new ArrayList<>();
            while (rs.next()) {
                Producer producer = Producer.builder().name(rs.getString("name")).idautor(rs.getInt("idautor")).build();
                Anime anime = getanime(rs);
                listOfanimes.add(anime);
            }

            return listOfanimes;
        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createPrepareStamentFindByName(String stringName, Connection connection) throws SQLException {
        String sql = "select * from anime_store.anime a inner join anime_store.producer p on a.idAutor = p.idautor where a.nome like ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.format("%%%s%%", stringName));
        return statement;
    }

    private static Anime getanime(ResultSet resultSet) throws SQLException {
        Anime anime = Anime
                .builder()
                .id(resultSet.getInt("idanime"))
                .name(resultSet.getString("nome"))
                .episodes(resultSet.getInt("eps"))
                .build();
        return anime;
    }

    public static void delete(int idanime) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementDelete(connection, idanime)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createPrepareStatementDelete(Connection connection, Integer idanime) throws SQLException {
        String sql = ("DELETE FROM `anime_store`.`Anime` WHERE (`idanime` = ?);");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idanime);
        return preparedStatement;
    }

    public static void save(Anime Anime) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementSave(connection, Anime)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createPrepareStatementSave(Connection connection, Anime Anime) throws SQLException {
        String sql = "insert into anime_store.anime(nome,eps,idAutor) values(?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Anime.getName());
        preparedStatement.setInt(2, Anime.getEpisodes());
        preparedStatement.setInt(3, Anime.getProducer().getIdautor());
        return preparedStatement;
    }

    public static Optional<Anime> findById(Integer idanime) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = createPrepareStamentFindById(idanime, connection);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) return Optional.empty();
            Producer producer = Producer.builder().name(rs.getString("name")).idautor(rs.getInt("idautor")).build();
            return Optional.of(Anime
                    .builder()
                    .name(rs.getString("name"))
                    .id(rs.getInt("idanime"))
                    .producer(producer)
                    .build());

        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createPrepareStamentFindById(Integer idanime, Connection connection) throws SQLException {
        String sql = "select a.nome,a.idanime,a.eps,p.name,p.idautor from anime_store.anime a inner join anime_store.producer p on a.idAutor = p.idautor where a.idanime = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idanime);
        return statement;
    }

    public static void update(Anime Anime) {

        log.info("updating the Anime '{}'", Anime);
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = createPrepareStamentUpdate(Anime, connection);
            ps.execute();
        } catch (SQLException e) {
            log.error("error trying to findAll {}");
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createPrepareStamentUpdate(Anime Anime, Connection connection) throws SQLException {
        String sql = "update anime_store.anime set nome = ?, eps = ? where(idanime = ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, Anime.getName());
        statement.setInt(2, Anime.getEpisodes());
        statement.setInt(3, Anime.getId());
        return statement;
    }

}
