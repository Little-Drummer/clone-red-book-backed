package com.yjxw.model.vo;

import lombok.Data;

@Data
public class UserInfoVO {
    private Integer id;
    private String email;
    private String name;
    private Integer gender;
    private String bio;
    private String avatar;
    private Integer userType;
    private String token;
}
