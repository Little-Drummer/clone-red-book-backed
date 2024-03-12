package com.yjxw.model;

import lombok.Data;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

/**
 * 用户信息表 实体类。
 *
 * @author yjxw
 * @since 1.0
 */
@Data
@Builder
@Schema(name = "用户信息表")
@Table(value = "users")
public class UsersEntity {

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    @Id(keyType = KeyType.Auto)
    private Integer userId;


    /**
     * 电子邮件地址
     */
    @Schema(description = "电子邮件地址")
    @Column(value = "email")
    private String email;

    /**
     * 姓名
     */
    @Schema(description = "姓名")
    @Column(value = "name")
    private String name;


    /**
     * 性别
     */
    @Schema(description = "性别")
    @Column(value="gender")
    private Integer gender;

    /**
     * 个人简介
     */
    @Schema(description = "个人简介")
    @Column(value = "bio")
    private String bio;

    /**
     * 个人头像URL
     */
    @Schema(description = "个人头像URL")
    @Column(value = "profile_picture_url")
    private String profilePictureUrl;

    /**
     * 用户类型：0表示普通用户，1表示管理员等
     */
    @Schema(description = "用户类型：0表示普通用户，1表示管理员等")
    @Column(value = "user_type")
    private Integer userType;


    /**
     * 用户密码
     */
    @Schema(description = "用户密码")
    @Column(value = "user_password")
    private String userPassword;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @Column(value = "created_at")
    private java.util.Date createdAt;

    /**
     * 最后更新时间
     */
    @Schema(description = "最后更新时间")
    @Column(value = "updated_at")
    private java.util.Date updatedAt;


}
