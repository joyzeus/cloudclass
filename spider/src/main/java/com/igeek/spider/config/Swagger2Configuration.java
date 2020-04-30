package com.igeek.spider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhouxu
 * @date 2020/04/29
 * @email 1419982188@qq.com
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.igeek.spider";

    public static final String VERSION = "1.0.0";

    public static final Tag[] TAGS = {
            new Tag("book", "图书相关API"),
            new Tag("file", "分布式文件API")
    };

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("book", "图书相关API"), TAGS)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("网课 API ")
                .description("网课 API 接口文档")
                .version(VERSION)
                .termsOfServiceUrl("https://github.com/joyzeus")
                .build();
    }
}