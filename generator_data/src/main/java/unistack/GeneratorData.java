package unistack;

import unistack.enums.FileEnums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * @author Gyges Zean
 * @date 2018/3/12
 */
public class GeneratorData extends AbstractConfig implements BaseGenerate {

    private String fileName = null;




    @Override
    public void config(String fileName) {
        this.fileName = fileName;
        convertToMap(fileName);
    }


    @Override
    public String buildSql(String table, String[] args) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("INSERT INTO");
        if (fileName
                .equals(FileEnums.ORACLE.toString().toLowerCase())) {
            sb1.append(addQuotation(string(datasourceName)));
            sb1.append(".");
            sb1.append(addQuotation(table));
            sb1.append("(");
            for (int i = 0; i < args.length; i++) {
                sb1.append(addQuotation(args[i].toLowerCase())).append(",");
            }
        } else {
            sb1.append(addBlank(table));
            sb1.append("(");
            for (int i = 0; i < args.length; i++) {
                sb1.append(args[i]).append(",");
            }
        }
        StringBuilder sb2 = new StringBuilder(sb1.substring(0, sb1.length() - 1));
        sb2.append(")").append(addBlank("VALUES")).append("(");
        for (int i = 0; i < args.length; i++) {
            sb2.append("?").append(",");
        }
        return sb2.substring(0, sb2.length() - 1) + ")";
    }


    public Connection getConnection() {
        return getDBConnection();
    }

    public void batchInsertRecordsIntoTable() throws SQLException {
        int WAIT_TIME = integer("wait.time");
        PreparedStatement ps = null;
        Connection dbConnection = null;
        try {
            int loop_count = Integer.parseInt(string("loop.count"));
            String tableName = string("table");
            String[] index = new String[]{"sink", "source", "createtime"};

            dbConnection = getConnection();
//            dbConnection.setAutoCommit(false);
            ps = dbConnection.prepareStatement(
                    buildSql(tableName, index));
            for (int i = 1; i <= loop_count; i++) {
                ps.setInt(1, Math.abs(new Random().nextInt(5)));
                ps.setInt(2, Math.abs(new Random().nextInt(5)));
//                java.util.Date date = new Date();
//                Object param = new java.sql.Date(date.getTime());
// The JDBC driver knows what to do with a java.sql type:
                Calendar cal = Calendar.getInstance();
                ps.setTimestamp(3, new java.sql.Timestamp(cal.getTime().getTime()));
                ps.executeUpdate();
                Thread.sleep(WAIT_TIME);
                System.out.println("执行了" + i + "语句");
            }
//            dbConnection.commit();
            System.out.println("Record is inserted into table!");
        } catch (SQLException | InterruptedException e) {
            System.err.println(e);
        } finally {
            if (dbConnection != null) {
                dbConnection.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

    }

}
