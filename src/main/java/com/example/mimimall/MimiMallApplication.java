package com.example.mimimall;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Slf4j
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = "com.example.mimimall.mapper")
public class MimiMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MimiMallApplication.class, args);
        log.info("访问swagger http://localhost:8080/swagger-ui.html");
    }

}
