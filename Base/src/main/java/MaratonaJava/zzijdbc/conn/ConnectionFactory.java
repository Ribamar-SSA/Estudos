package MaratonaJava.zzijdbc.conn;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public static Connection getConnection(){
        //possibilita o DriveManager pega a conexão usando o padrão
        //jdbc:mysql:// nomeDoHost:númeroDePorta/nomeDoBancoDeDados
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";

        try {
           return DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static JdbcRowSet getJdbcRowSet() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUsername(username);
        jdbcRowSet.setUrl(url);
        jdbcRowSet.setPassword(password);
        return jdbcRowSet;
    }

    public static CachedRowSet getCachedRowSet() throws SQLException {
        return RowSetProvider.newFactory().createCachedRowSet();
    }

}
