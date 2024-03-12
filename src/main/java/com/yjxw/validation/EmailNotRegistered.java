package com.yjxw.validation;

import com.yjxw.validation.impl.EmailNotRegisteredValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented // 说明该注解将被包含在javadoc中
@Target({ElementType.FIELD, ElementType.PARAMETER}) // 说明该注解可以标注在字段（域）上
@Retention(RetentionPolicy.RUNTIME) // 说明该注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Constraint(validatedBy = EmailNotRegisteredValidator.class) // 说明该注解的验证逻辑由EmailNotRegisteredValidator类执行
public @interface EmailNotRegistered {
    String message() default "邮箱已被注册"; // 默认错误消息

    Class<?>[] groups() default {}; // 分组

    Class<? extends Payload>[] payload() default {}; // 负载
}
