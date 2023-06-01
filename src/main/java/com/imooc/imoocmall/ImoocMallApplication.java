package com.imooc.imoocmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.imoocmall.model.dao")
@EnableSwagger2
public class ImoocMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImoocMallApplication.class, args);
    }

}
