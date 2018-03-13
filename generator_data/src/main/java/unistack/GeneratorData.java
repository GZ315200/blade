package unistack;

import unistack.enums.FileEnums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
        PreparedStatement ps = null;
        Connection dbConnection = null;
        try {
            dbConnection = getConnection();
            int loop_count = Integer.parseInt(string("loop.count"));
            String tableName = string("table");
            ps = dbConnection.prepareStatement(
                    buildSql(tableName, getTableColumns(tableName)));
            dbConnection.setAutoCommit(false);
            for (int i = 0; i < loop_count; i++) {
                ps.setInt(1, Math.abs(new Random().nextInt()));
                ps.setInt(2, Math.abs(new Random().nextInt()));
                ps.setInt(3, Math.abs(new Random().nextInt()));
                ps.addBatch();
            }
            ps.executeBatch();
            dbConnection.commit();
            System.out.println("Record is inserted into table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }

    }

}
