package unistack;

import java.sql.Connection;
import java.util.Map;


/**
 * @author Gyges Zean
 * @date 2018/3/12
 */
public interface BaseGenerate {


    /**
     * 获取config
     * @param
     * @return
     */
    public void config(String fileName);

    /**
     * 构建sql
     * @param table
     * @param args
     * @return
     */
    public String buildSql(String table,String ...args);

    /**
     * 获取连接
     * @return
     */
    public Connection getConnection();

}
