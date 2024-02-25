package com.yjxw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yjxw.mapper")
public class CloneRedBookBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloneRedBookBackEndApplication.class, args);
    }

    
}
