package unistack;

import org.apache.commons.lang3.StringUtils;
import unistack.bean.ColumnInfo;
import unistack.enums.FileEnums;
import unistack.utils.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Gyges Zean
 * @date 2018/3/12
 */
public abstract class AbstractConfig {


    protected static String datasourceName = "datasource";

    protected static Map<String,String> dataSource = new HashMap<>();

    protected static Map<Object,Object> config = new HashMap<>();

    @SuppressWarnings(value = "unchecked")
    protected static<K, V> void convertToMap(String fileName) {
        Map<K, V> map = new HashMap<K,V>();
        if (StringUtils.isBlank(fileName)) {
            fileName = FileEnums.MYSQL.toString().toLowerCase();
            dataSource.put(datasourceName,fileName);
        }
        fileName = fileName.toLowerCase();
        PropertiesUtil propertiesUtil = new PropertiesUtil(fileName);
        Properties properties = propertiesUtil.getProps();
        for (Object key : properties.keySet()) {
            if (map.containsKey(key))
                continue;
            map.put((K) key, (V) properties.get(key));
        }
        config.putAll(map);
    }



    protected String addBlank(String value) {
        return " " + value + " ";
    }

    protected String addQuotation(String value) {return  " \""+value+"\"";}

    protected String string(String key) {
        return (String) config.get(key);
    }

    protected Object integer(String key) {
        return config.get(key);
    }

    protected Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(string("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(
                    string("jdbc.url"), string("jdbc.username"), string("jdbc.password"));
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }



    private  Map<String,ColumnInfo> fetchColumns(String tableName, Connection connection) throws SQLException {
        Map<String,ColumnInfo> colMap = new HashMap<String,ColumnInfo>();
        ResultSet resultSet = null;
        Map<String,Object> primaryKeys = new HashMap<String,Object>();
        try {
            resultSet = connection.getMetaData().getPrimaryKeys(null, null, tableName);
            while (resultSet.next()){
                primaryKeys.put(resultSet.getString("COLUMN_NAME"),null);
            }
            resultSet.close();
            String dbType = connection.getMetaData().getDatabaseProductName();
            resultSet = connection.getMetaData().getColumns(null,null,tableName,null);
            while (resultSet.next()){
                String colName = resultSet.getString("COLUMN_NAME");
                ColumnInfo metadata = new ColumnInfo();
                metadata.setColumnName(colName);
                metadata.setPrimaryKey(primaryKeys.containsKey(colName));
                metadata.setDbType(dbType);

                metadata.setDataType(resultSet.getInt("DATA_TYPE"));
                metadata.setTypeName(resultSet.getString("TYPE_NAME"));

                metadata.setColumnSize(resultSet.getInt("COLUMN_SIZE"));
                metadata.setIsNullable(resultSet.getString("IS_NULLABLE"));
                metadata.setTableName(resultSet.getString("TABLE_NAME"));//importent
                colMap.put(colName.toUpperCase(),metadata);
            }

        }finally {
            if(resultSet != null)resultSet.close();
        }

        return colMap;
    }


    public String[] getTableColumns(String tableStr) throws SQLException {
        Map<String,ColumnInfo> getColumns = fetchColumns(tableStr,getDBConnection());
        List<String> str = new ArrayList<>();
        getColumns.keySet().forEach(s -> {
            str.add(s);
        });
        return str.toArray(new String[0]);
    }



}
