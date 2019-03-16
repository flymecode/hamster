package com.xupt.hamster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xupt.hamster.mapper")
public class HamsterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HamsterApplication.class, args);
    }

}
