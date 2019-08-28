package com.jay.book.plugin;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MybatisGenerator {

    private static File configFile;

    static {
        String path = System.getProperty("user.dir").concat("\\mybatisgenerator\\src\\main\\resources\\generatorConfiguration.xml");
        System.out.println(path);
        configFile = new File(path);
    }

    public static void main(String[] args) throws IOException,XMLParserException,InvalidConfigurationException,
            SQLException,InterruptedException {

        if (!configFile.exists()) {
            System.out.println("配置文件不存在");
            return;
        }

        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
