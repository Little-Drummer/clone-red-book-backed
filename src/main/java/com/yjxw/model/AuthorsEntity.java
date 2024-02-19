package com.yjxw.model;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 存储文章作者的基本信息 实体类。
 *
 * @author yjxw
 * @since 1.0
 */
@Data
@Schema(name = "存储文章作者的基本信息")
@Table(value = "authors")
public class AuthorsEntity {

    /**
     * 作者的唯一标识符，主键，自动增长
     */
    @Schema(description = "作者的唯一标识符，主键，自动增长")
    @Id(keyType = KeyType.Auto)
    private Long authorId;

    /**
     * 作者的姓名
     */
    @Schema(description = "作者的姓名")
    @Column(value = "name")
    private String name;

    /**
     * 作者的电子邮件地址，唯一
     */
    @Schema(description = "作者的电子邮件地址，唯一")
    @Column(value = "email")
    private String email;

    /**
     * 作者的简介，可存储较长文本
     */
    @Schema(description = "作者的简介，可存储较长文本")
    @Column(value = "bio")
    private String bio;

    /**
     * 作者的头像图片链接
     */
    @Schema(description = "作者的头像图片链接")
    @Column(value = "profile_picture_url")
    private String profilePictureUrl;

    /**
     * 记录作者创建的时间
     */
    @Schema(description = "记录作者创建的时间")
    @Column(value = "created_at")
    private java.util.Date createdAt;

    /**
     * 记录作者信息最后更新的时间
     */
    @Schema(description = "记录作者信息最后更新的时间")
    @Column(value = "updated_at")
    private java.util.Date updatedAt;


}
