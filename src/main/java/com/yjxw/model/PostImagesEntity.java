package com.yjxw.model;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 存储文章相关图片的信息，每条记录代表一张图片 实体类。
 *
 * @author yjxw
 * @since 1.0
 */
@Data
@Schema(name = "存储文章相关图片的信息，每条记录代表一张图片")
@Table(value = "post_images")
public class PostImagesEntity {

    /**
     * 主键，图片的唯一标识符，自动增长
     */
    @Schema(description = "主键，图片的唯一标识符，自动增长")
    @Id(keyType = KeyType.Auto)
    private Long imageId;

    /**
     * 外键，关联到posts表的post_id，标识图片所属的文章
     */
    @Schema(description = "外键，关联到posts表的post_id，标识图片所属的文章")
    @Column(value = "post_id")
    private Long postId;

    /**
     * 图片的URL链接，存储图片的实际位置
     */
    @Schema(description = "图片的URL链接，存储图片的实际位置")
    @Column(value = "image_url")
    private String imageUrl;

    /**
     * 图片高度
     */
    @Schema(description = "图片的高度")
    @Column(value = "image_height")
    private String imageHeight;

    /**
     * 图片的宽度
     */
    @Schema(description = "图片的宽度")
    @Column(value = "image_width")
    private String imageWidth;

    /**
     * 记录图片添加到数据库的时间
     */
    @Schema(description = "记录图片添加到数据库的时间")
    @Column(value = "created_at")
    private java.util.Date createdAt;


}
