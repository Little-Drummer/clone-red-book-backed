package com.yjxw.config;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix = "mail")
@Data
@Validated
public class MailProperties {
    @NotEmpty(message = "发件人不能为空")
    private String from;
    @NotEmpty(message = "发件人昵称不能为空")
    private String domain;


}
