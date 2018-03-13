package com.igeek.handler;

import java.sql.*;

/**
 * @author Gyges Zean
 * @date 2018/2/6
 */
public class HandlerOracleDataService {


        public static void main(String[] args) {
            ResultSet rs = null;
            Statement stmt = null;
            Connection conn = null;
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                //new oracle.jdbc.driver.OracleDriver();
                conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.1:1521:yuewei", "scott", "tiger");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from dept");
                while(rs.next()) {
                    System.out.println(rs.getString("deptno"));
                    //System.out.println(rs.getInt("deptno"));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(rs != null) {
                        rs.close();
                    }
                    if(stmt != null) {
                        stmt.close();
                    }
                    if(conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


}
