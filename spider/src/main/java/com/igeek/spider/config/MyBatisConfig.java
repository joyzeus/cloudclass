package com.igeek.spider.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhouxu
 * @date 2019/12/24
 * @email 1419982188@qq.com
 */
@SpringBootConfiguration
@EnableTransactionManagement
@MapperScan("com.igeek.*.dao")
public class MyBatisConfig {
}