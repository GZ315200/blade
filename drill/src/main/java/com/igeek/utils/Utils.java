package com.igeek.utils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Gyges Zean
 * @date 2018/3/29
 */
public class Utils {


    /**
     * @param properties
     * @return
     */
    public static Map<String, String> propsToStringMap(Properties properties) {
        Map<String, String> result = new HashMap<String, String>();
        for (Map.Entry<Object, Object> entry : properties.entrySet())
            result.put(entry.getKey().toString(), entry.getValue().toString());
        return result;
    }

    /**
     * @param e
     * @return
     */
    public static String stackTrace(Throwable e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    public static Properties loadProps(String filename) throws IOException {
        Properties props = new Properties();
        try (InputStream inputStream = new FileInputStream(filename)) {
            props.load(inputStream);
        }
        return props;
    }

    /**
     * read a buffer into a Byte array for the given offset and length.
     * @param byteBuffer
     * @param offset
     * @param length
     * @return
     */
    public static byte[] readBytes(ByteBuffer byteBuffer, int offset, int length) {
         byte[] dest = new byte[length];
         if (byteBuffer.hasArray()) {
             System.arraycopy(byteBuffer.array(),byteBuffer.arrayOffset()+offset,dest,0,length);
         } else {
             byteBuffer.mark();
             byteBuffer.position(offset);
             byteBuffer.get(dest,0,length);
             byteBuffer.reset();
         }
         return dest;
    }


    public static void main(String[] args) {
        byte[] myvar = "Any String you want".getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(myvar.length);
        buffer.put(myvar);
        buffer.rewind();
        byte[] results = Utils.readBytes(buffer,4,7);
        String str = new String(results, StandardCharsets.UTF_8);
        System.out.println(str);
    }

}
