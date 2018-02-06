package com.igeek.jmxapp.tools;

import java.lang.management.ManagementFactory;
import java.lang.management.PlatformManagedObject;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author Gyges Zean
 * @date 2018/2/2
 */
public class MetricReport {


    private Properties getSystemMetrics(PlatformManagedObject bean, Class<?> clazz) {
        Properties props = new Properties();
        for (Method method : clazz.getMethods()) {
            if (method.getName().startsWith("get")) {
                try {
                    props.put(method.getName().replaceFirst("get", ""), method.invoke(bean));
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    System.err.println("Fail to " + clazz.getName() + "." + method.getName());
                }
            }
        }
        return props;
    }


    public static void main(String[] args) {
//        MetricReport metricReport = new MetricReport();
//       Properties properties = metricReport.getSystemMetrics(ManagementFactory.getRuntimeMXBean(), RuntimeMXBean.class);
//        System.out.println(properties);
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strings.parallelStream().filter(s -> !s.isEmpty()).count();
        System.out.println(count);
    }
}
