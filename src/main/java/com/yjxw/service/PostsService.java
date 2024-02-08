package com.yjxw.service;


import com.mybatisflex.core.service.IService;
import com.yjxw.model.PostsEntity;
import com.yjxw.model.vo.PostWithImageAuthor;

import java.util.List;

/**
 * 存储用户发布的文章信息，包括标题、内容、互动计数等 服务层。
 *
 * @author yjxw
 * @since 1.0
 */
public interface PostsService extends IService<PostsEntity> {

    List<PostWithImageAuthor> listWithImageAuthor();

}