package MaratonaJava.zzijdbc.conn;

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

}
