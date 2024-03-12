package com.yjxw.service.impl;


import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.yjxw.mapper.VerificationCodeMapper;
import com.yjxw.model.VerificationCodeEntity;
import com.yjxw.service.EmailService;
import com.yjxw.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 存储用户邮箱验证码的表 服务层实现。
 *
 * @author yjxw
 * @since 1.0
 */
@Service
public class VerificationCodeServiceImpl extends ServiceImpl<VerificationCodeMapper, VerificationCodeEntity> implements VerificationCodeService {

    @Autowired
    private EmailService emailService;

    /**
     * 发送验证码
     * @param email
     * @return
     */
    @Override
    public boolean sendVerificationCode(String email) {
        String code = generateVerificationCode();
        VerificationCodeEntity verificationCode = VerificationCodeEntity.builder()
                .email(email)
                .code(code)
                .createTime(new java.util.Date())
                .expireTime(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 5)) // 5分钟后过期
                .build();
        emailService.send(email, code);
        return save(verificationCode);
    }

    /**
     * 生成验证码
     * @return 验证码
     */
    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(999999 - 100000 + 1) + 100000; // 确保生成的数字在100000到999999之间
        return String.format("%06d", code); // 格式化为6位数
    }
}