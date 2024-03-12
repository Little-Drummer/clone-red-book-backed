package com.yjxw.service;


import com.yjxw.model.VerificationCodeEntity;
import com.mybatisflex.core.service.IService;

/**
 * 存储用户邮箱验证码的表 服务层。
 *
 * @author yjxw
 * @since 1.0
 */
public interface VerificationCodeService extends IService<VerificationCodeEntity> {

    boolean sendVerificationCode(String email);
}