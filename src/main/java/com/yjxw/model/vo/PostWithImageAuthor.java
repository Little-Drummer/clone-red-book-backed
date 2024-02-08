package com.yjxw.model.vo;

import com.yjxw.model.AuthorsEntity;
import com.yjxw.model.PostImagesEntity;
import com.yjxw.model.PostsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于返回带图片的文章信息
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostWithImageAuthor extends PostsEntity {
    private List<PostImagesEntity> images = new ArrayList<>();
    private AuthorsEntity author = AuthorsEntity.builder().build();
}
