package unistack.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author Gyges Zean
 * @date 2018/3/8
 */
public class PropertiesUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    public static Properties props;


    public PropertiesUtil(String fileName)  {
        props = new Properties();
        String newFileName = "/config/" + fileName + ".properties";
        String path = PropertiesUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        FileInputStream fileInputStream = null;
        try {
            if(path.contains(".jar")){
                path = path.substring(path.indexOf("/"), path.indexOf("/generator-tools.jar"));
            }
            fileInputStream = new FileInputStream(path+newFileName);
            props.load(new InputStreamReader(fileInputStream, "UTF-8"));
        } catch (Exception e) {
            logger.error("配置文件读取异常", e);
        }
    }

    public Properties getProps() {
        return props;
    }

    public static String getProperty(String key) {
        String value = props.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return value.trim();
    }

    public static Integer convertToInteger(String key) {
        return Integer.valueOf(getProperty(key));
    }


    public static String getProperty(String key, String defaultValue) {

        String value = props.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            value = defaultValue;
        }
        return value.trim();
    }
}
