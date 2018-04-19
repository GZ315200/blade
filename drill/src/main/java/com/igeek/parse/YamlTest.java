package com.igeek.parse;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author Gyges Zean
 * @date 2018/4/19
 */
public class YamlTest {

    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        try (InputStream in = YamlTest.class.getResourceAsStream("/person.yml")){
            Map<String,String> person = yaml.loadAs(in,Map.class);
            System.out.println(person);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
