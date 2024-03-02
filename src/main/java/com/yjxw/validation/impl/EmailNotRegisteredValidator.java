package com.yjxw.validation.impl;

import com.yjxw.service.UsersService;
import com.yjxw.validation.EmailNotRegistered;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.yjxw.model.table.UsersEntityTableDef.USERS_ENTITY;

public class EmailNotRegisteredValidator implements ConstraintValidator<EmailNotRegistered, String> {

    @Autowired
    private UsersService usersService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (email == null) {
            return false;
        }
        boolean isExists = usersService.getOne(USERS_ENTITY.EMAIL.eq(email)) == null;
        if (!isExists) {
            //  设置错误消息提示
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("邮箱" + email + "已被注册").addConstraintViolation();
        }
        return isExists;
    }
}
