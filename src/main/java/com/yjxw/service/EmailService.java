package com.yjxw.service;

/**
 * 邮件服务。
 *
 * @author yjxw
 * @since 1.0
 */
public interface EmailService {
    void send(String email, String code);
}
