package com.igeek.cloudclass.ums.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/5/19
 */
@SpringBootConfiguration
@EnableTransactionManagement
@MapperScan("com.igeek.cloudclass.ums.mapper")
public class MyBatisConfig {
}
