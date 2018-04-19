package unistack;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.Namespace;
import org.apache.commons.lang3.StringUtils;


import static net.sourceforge.argparse4j.impl.Arguments.store;

/**
 * @author Gyges Zean
 * @date 2018/3/12
 */
public class Main {

    public static void main(String[] args) {

        GeneratorData generatorData = new GeneratorData();
        try {
            System.out.println("start to batch....");
//            加载配置文件，输入名称（大小写都行）,在config文件下，如果不指定默认为mysql，
            ArgumentParser parser = argParser();
            Namespace res = parser.parseArgs(args);
            /* parse args */
            String filename = res.getString("filename");
            if (StringUtils.isBlank(filename)) {
                generatorData.config("");
            } else {
                generatorData.config(filename);
            }
//            批量插入表内
            generatorData.batchInsertRecordsIntoTable();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static ArgumentParser argParser() {
        ArgumentParser parser = ArgumentParsers
                .newArgumentParser("generator_data")
                .defaultHelp(true)
                .description("This tool is used to generate data to db.");

        parser.addArgument("--filename")
                .action(store())
                .required(false)
                .type(String.class)
                .metavar("FILENAME")
                .help("generate messages to this db");

        return parser;
    }
}
