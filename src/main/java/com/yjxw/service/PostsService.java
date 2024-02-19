package com.yjxw.service;


import com.mybatisflex.core.paginate.Page;
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


    /**
     * 查询所有存储用户发布的文章信息，包括标题、内容、互动计数、图片、作者等
     * @return 文章列表
     */
    List<PostWithImageAuthor> listWithImageAuthor();

    /**
     * 分页查询文章信息包括标题、内容、互动计数、图片、作者等
     * @param page 分页条件
     * @return 分页文章信息
     */
    Page<PostWithImageAuthor> pageWithImageAuthor(Page<PostsEntity> page);


}