package com.yjxw.model;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 存储用户发布的文章信息，包括标题、内容、互动计数等 实体类。
 *
 * @author yjxw
 * @since 1.0
 */
@Data
//@Builder
@Schema(name = "存储用户发布的文章信息，包括标题、内容、互动计数等")
@Table(value = "posts")
public class PostsEntity {

    /**
     * 主键，文章的唯一标识符，自动增长
     */
    @Schema(description = "主键，文章的唯一标识符，自动增长")
    @Id(keyType = KeyType.Auto)
    private Long postId;

    /**
     * 文章的标题
     */
    @Schema(description = "文章的标题")
    @Column(value = "title")
    private String title;

    /**
     * 外键，关联到authors表的author_id，标识文章的作者
     */
    @Schema(description = "外键，关联到authors表的author_id，标识文章的作者")
    @Column(value = "author_id")
    private Long authorId;

    /**
     * 文章的主体内容
     */
    @Schema(description = "文章的主体内容")
    @Column(value = "content")
    private String content;

    /**
     * 文章获得的喜欢(点赞)数量
     */
    @Schema(description = "文章获得的喜欢(点赞)数量")
    @Column(value = "likes_count")
    private Integer likesCount;

    /**
     * 文章被收藏的次数
     */
    @Schema(description = "文章被收藏的次数")
    @Column(value = "favorites_count")
    private Integer favoritesCount;

    /**
     * 文章的评论数量
     */
    @Schema(description = "文章的评论数量")
    @Column(value = "comments_count")
    private Integer commentsCount;

    /**
     * 记录文章创建的时间
     */
    @Schema(description = "记录文章创建的时间")
    @Column(value = "created_at")
    private java.util.Date createdAt;

    /**
     * 记录文章最后被修改的时间
     */
    @Schema(description = "记录文章最后被修改的时间")
    @Column(value = "updated_at")
    private java.util.Date updatedAt;


}
