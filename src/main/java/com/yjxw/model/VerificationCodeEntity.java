package com.yjxw.model;

import lombok.Data;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

/**
 * 存储用户邮箱验证码的表 实体类。
 *
 * @author yjxw
 * @since 1.0
 */
@Data
@Builder
@Schema(name = "存储用户邮箱验证码的表")
@Table(value = "verification_code")
public class VerificationCodeEntity {

    /**
     * 主键，自增长唯一标识
     */
    @Schema(description = "主键，自增长唯一标识")
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 用户邮箱地址
     */
    @Schema(description = "用户邮箱地址")
    @Column(value = "email")
    private String email;

    /**
     * 验证码
     */
    @Schema(description = "验证码")
    @Column(value = "code")
    private String code;

    /**
     * 验证码创建时间
     */
    @Schema(description = "验证码创建时间")
    @Column(value = "create_time")
    private java.util.Date createTime;

    /**
     * 验证码过期时间
     */
    @Schema(description = "验证码过期时间")
    @Column(value = "expire_time")
    private java.util.Date expireTime;


}
