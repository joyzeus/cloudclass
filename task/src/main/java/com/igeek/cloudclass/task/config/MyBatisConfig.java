package com.igeek.cloudclass.task.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/05/02
 */
@SpringBootConfiguration
@EnableTransactionManagement
@MapperScan("com.igeek.cloudclass.task.dao")
public class MyBatisConfig {
}