package MaratonaJava.zzijdbc.repository;

import MaratonaJava.zzijdbc.conn.ConnectionFactory;
import MaratonaJava.zzijdbc.dominio.Producer;
import MaratonaJava.zzijdbc.listener.CustomRowSetListener;
import com.mysql.cj.jdbc.JdbcConnection;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProduceRepositoryRowSet {

    public static List<Producer>  findByNameRowSet(String stringName){
        String sql = "select * from anime_store.producer where name like ?;";
        List<Producer> producerList = new ArrayList<>();
        try(JdbcRowSet jrcs = ConnectionFactory.getJdbcRowSet()) {
            jrcs.addRowSetListener(new CustomRowSetListener());
            jrcs.setCommand(sql);
            jrcs.setString(1,String.format("%%%s%%",stringName));
            jrcs.execute();
            while(jrcs.next()){
                Producer producer = Producer.builder()
                        .name(jrcs.getString("name"))
                        .id(jrcs.getInt("idautor"))
                        .build();
                producerList.add(producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return producerList;
    }

    //erro no update
//    public static void updateJdbcRowSet(Producer producer){
//        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
//        try(JdbcRowSet jrcs = ConnectionFactory.getJdbcRowSet()) {
//            jrcs.setCommand(sql);
//            jrcs.setString(1, producer.getName());
//            jrcs.setInt(2,producer.getId());
//            jrcs.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    public static void updateJdbcRowSet(Producer producer){
    String sql = "SELECT * FROM anime_store.producer where (idautor = ?) ;";
        try(JdbcRowSet jrcs = ConnectionFactory.getJdbcRowSet()) {
            jrcs.addRowSetListener(new CustomRowSetListener());
            jrcs.setCommand(sql);
            jrcs.setInt(1, producer.getId());
            //You can execute the query that the RowSet object holds using the execute() method.
            jrcs.execute();

            if(!jrcs.next()) return;
            jrcs.updateString("name", producer.getName());
            jrcs.updateRow();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //cached tem um performance maior do que se tivesse que ir até o dba buscar
    public static void updateCachedRowSet(Producer producer){
    String sql = "SELECT * FROM producer where (idautor = ?) ;";
        try(CachedRowSet cachedRowSet = ConnectionFactory.getCachedRowSet();
            Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);
            cachedRowSet.setCommand(sql);
            cachedRowSet.setInt(1, producer.getId());
            cachedRowSet.execute(connection);
            if(!cachedRowSet.next()) return;
            cachedRowSet.updateString("name", producer.getName());
            cachedRowSet.updateRow();
            //se tentarmos modificar algum dado no dba pode dar um conflito enquanto sincronizava
            TimeUnit.SECONDS.sleep(10);
            cachedRowSet.acceptChanges();

        } catch (SQLException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

