package com.jay.book.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootConfiguration
@EnableTransactionManagement
@MapperScan("com.jay.book.*.dao")
public class MyBatisConfig {


}