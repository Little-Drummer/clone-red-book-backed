package com.yjxw.service.impl;

import com.yjxw.config.MailProperties;
import com.yjxw.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private MailProperties mailProperties;
    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void send(String email, String code) {
        log.info("向邮箱{}发送验证码{}", email, code);
        // 发送验证码
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailProperties.getFrom());
        message.setTo(email);
        message.setSubject("小红书(面试版)注册验证码");
        message.setText("欢迎您注册小红书(面试版)\n您的注册验证码为: " + code + "\n请在5分钟内完成注册");
        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            log.error("邮件发送失败", e);
        }
    }
}
