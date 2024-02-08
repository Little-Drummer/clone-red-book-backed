package com.yjxw.service.impl;


import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.yjxw.mapper.PostsMapper;
import com.yjxw.model.AuthorsEntity;
import com.yjxw.model.PostsEntity;
import com.yjxw.model.vo.PostWithImageAuthor;
import com.yjxw.service.AuthorsService;
import com.yjxw.service.PostImagesService;
import com.yjxw.service.PostsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import static com.yjxw.model.table.PostImagesEntityTableDef.POST_IMAGES_ENTITY;

/**
 * 存储用户发布的文章信息，包括标题、内容、互动计数等 服务层实现。
 *
 * @author yjxw
 * @since 1.0
 */
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, PostsEntity> implements PostsService {
    @Autowired
    private AuthorsService authorsService;
    @Autowired
    private PostImagesService postImagesService;

    @Override
    public List<PostWithImageAuthor> listWithImageAuthor() {
        ArrayList<PostWithImageAuthor> list = new ArrayList<>();
        // 1.查询出文章列表
        List<PostsEntity> postsEntityList = list();
        postsEntityList.forEach(postsEntity -> {
            PostWithImageAuthor postWithImageAuthor = new PostWithImageAuthor();
            postWithImageAuthor.setImages(new ArrayList<>());
            BeanUtils.copyProperties(postsEntity, postWithImageAuthor);
            list.add(postWithImageAuthor);
            // 2.查询出文章作者
            AuthorsEntity authorsEntity = authorsService.getById(postsEntity.getAuthorId());
            if (authorsEntity != null) {
                postWithImageAuthor.setAuthor(authorsEntity);
            }
            // 3.查询出文章图片
            postImagesService.list(POST_IMAGES_ENTITY.POST_ID.eq(postsEntity.getPostId())).forEach(postImagesEntity -> {
                postWithImageAuthor.getImages().add(postImagesEntity);
            });
        });
        // 4.返回带图片和作者的文章信息
        return list;
    }
}