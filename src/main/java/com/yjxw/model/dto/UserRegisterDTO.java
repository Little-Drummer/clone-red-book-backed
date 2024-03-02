package com.yjxw.model.dto;

import com.yjxw.validation.EmailNotRegistered;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserRegisterDTO {

    @NotBlank(message = "邮箱不能为空")
    @Size(min = 6, message = "邮箱长度不能小于6位")
    @Email(message = "邮箱格式不正确")
    @EmailNotRegistered(message = "邮箱已经注册")
    private String email;
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, message = "密码长度不能小于6位")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$", message = "密码必须包含大小写字母和数字")
    private String password;
    @NotBlank(message = "验证码不能为空")
    @Length(min = 6, max = 6, message = "验证码长度为6位")
    private String verificationCode;
}
