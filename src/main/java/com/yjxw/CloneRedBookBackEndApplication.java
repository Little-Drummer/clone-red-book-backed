package com.yjxw;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yjxw.mapper")
@Slf4j
public class CloneRedBookBackEndApplication {

    public static void main(String[] args) {
        log.info("项目开始启动...2");
        SpringApplication.run(CloneRedBookBackEndApplication.class, args);
    }

    
}
