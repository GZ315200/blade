package com.igeek.sqlite;
import java.sql.*;
import java.util.Properties;

/**
 * @author Gyges Zean
 * @date 2018/4/19
 */
public class Sqlite3Test {

    public static void main(String[] args) {
        Connection c = null;
        Statement statement = null;
        Properties prop = new Properties();
        prop.setProperty("shared_cache", "true");
        try {
            Class.forName("org.sqlite.JDBC");

            c = DriverManager.getConnection("jdbc:sqlite:/Users/mazean/test.db",prop);
            c.setTransactionIsolation(c.TRANSACTION_READ_UNCOMMITTED);
            statement = c.createStatement();

            statement.executeUpdate("drop table if exists person");

            statement.executeUpdate("create table person (id integer, name string)");

            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(3, '999')");
            statement.executeUpdate("insert into person values(4, 'kdfd')");
            statement.executeUpdate("insert into person values(5, 'dfsdfs')");
            statement.executeUpdate("insert into person values(6, 'dsfadsfd')");
            statement.executeUpdate("insert into person values(2, 'yui')");

            ResultSet rs = statement.executeQuery("select * from person");

            while (rs.next()) {
                System.out.println("name = " + rs.getInt("id"));
                System.out.println("name = " + rs.getString("name"));
            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
