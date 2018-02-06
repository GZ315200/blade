package com.igeek.service;

import com.igeek.bean.Message;
import com.igeek.cache.Queue;
import com.igeek.util.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.concurrent.Executors;

/**
 * @author Gyges Zean
 * @date 2018/1/31
 */
public class SentMsgToKafkaWithJDBC implements Runnable {

    protected int messageStartPosition;

    protected int messageEndPosition;

    private static Logger logger = LoggerFactory.getLogger(SentMsgToKafkaWithJDBC.class);

    private static class SentMsgHolder {
        private static final SentMsgToKafkaWithJDBC sentMsgToKafkaWithJDBC = new SentMsgToKafkaWithJDBC();

        private SentMsgHolder() {
        }
    }

    public SentMsgToKafkaWithJDBC(int messageStartPosition, int messageEndPosition) {
        this.messageStartPosition = messageStartPosition;
        this.messageEndPosition = messageEndPosition;
    }

    public SentMsgToKafkaWithJDBC() {
    }

    public static synchronized SentMsgToKafkaWithJDBC getInstance() {
        return SentMsgHolder.sentMsgToKafkaWithJDBC;
    }


    public static final String DRIVER = PropertiesUtils.getProperty("jdbc.driver");

    public static final String DB_URL = PropertiesUtils.getProperty("jdbc.url");

    public static final String USER = PropertiesUtils.getProperty("jdbc.username");

    public static final String PASS = PropertiesUtils.getProperty("jdbc.password");


    private void getSqlConnection() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT sink, source FROM test limit " + messageStartPosition + "," + messageEndPosition;
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                Message message = new Message();
                // 通过字段检索
                String sink = rs.getString("sink");
                String source = rs.getString("source");
                message.setSink(sink);
                message.setSource(source);
                com.igeek.cache.Queue.queue.offer(message);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        logger.info("get the DB size");
        getSqlConnection();
    }

    public void start() {
        Executors.newFixedThreadPool(1).execute(new SentMsgToKafkaWithJDBC(Queue.queue.size(), Queue.queue.size() + 100));
    }
}
