package com.yjxw.service.impl;


import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.yjxw.mapper.PostsMapper;
import com.yjxw.model.AuthorsEntity;
import com.yjxw.model.PostsEntity;
import com.yjxw.model.vo.PostWithImageAuthor;
import com.yjxw.service.AuthorsService;
import com.yjxw.service.PostImagesService;
import com.yjxw.service.PostsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.yjxw.model.table.PostImagesEntityTableDef.POST_IMAGES_ENTITY;
import static com.yjxw.model.table.PostsEntityTableDef.POSTS_ENTITY;

/**
 * 存储用户发布的文章信息，包括标题、内容、互动计数等 服务层实现。
 *
 * @author yjxw
 * @since 1.0
 */
@Service
@Slf4j
public class PostsServiceImpl extends ServiceImpl<PostsMapper, PostsEntity> implements PostsService {
    @Autowired
    private AuthorsService authorsService;
    @Autowired
    private PostImagesService postImagesService;

    @Override
    public PostWithImageAuthor getDetailById(Serializable id) {
        PostWithImageAuthor postWithImageAuthor = new PostWithImageAuthor();
        PostsEntity postsEntity = getById(id);
        if (postsEntity != null) {
            BeanUtils.copyProperties(postsEntity, postWithImageAuthor);
            AuthorsEntity authorsEntity = authorsService.getById(postsEntity
                    .getAuthorId());
            if (authorsEntity != null) {
                postWithImageAuthor.setAuthor(authorsEntity);
            }
            postWithImageAuthor.setImages(new ArrayList<>());
            postImagesService.list(POST_IMAGES_ENTITY.POST_ID.eq(postsEntity.getPostId())).forEach(postImagesEntity -> {
                postWithImageAuthor.getImages().add(postImagesEntity);
            });
            return postWithImageAuthor;
        } else {
            return null;
        }
    }

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

    /**
     * 分页查询文章信息包括标题、内容、互动计数、图片、作者等
     *
     * @param page 分页条件
     * @return 分页结果
     */
    @Override
    public Page<PostWithImageAuthor> pageWithImageAuthor(Page<PostsEntity> page) {
//        log.info("{}",page);
        // 1.创建对象
        Page<PostWithImageAuthor> postWithImageAuthorPage = new Page<>();
        // 2.分页查询文章数据
        Page<PostsEntity> postsEntityPage = page(page, new QueryWrapper().orderBy(POSTS_ENTITY.LIKES_COUNT.desc()));
//        log.info("{}",postsEntityPage);
        // 3.对新对象进行赋值
        postWithImageAuthorPage.setPageNumber(postsEntityPage.getPageNumber());
        postWithImageAuthorPage.setPageSize(postsEntityPage.getPageSize());
        postWithImageAuthorPage.setTotalPage(postsEntityPage.getTotalPage());
        postWithImageAuthorPage.setTotalRow(postsEntityPage.getTotalRow());
        // 4.转换PostsEntity到PostWithImageAuthor类型
        List<PostWithImageAuthor> convertedList = page.getRecords().stream().map((postsEntity) -> {
//            System.out.println(postsEntity);
            PostWithImageAuthor postWithImageAuthor = new PostWithImageAuthor();
            BeanUtils.copyProperties(postsEntity, postWithImageAuthor);
            // 查询作者赋值
            postWithImageAuthor.setAuthor(authorsService.getById(postsEntity.getAuthorId()));
            // 查询图片并赋值
            postWithImageAuthor.setImages(new ArrayList<>());
            postWithImageAuthor.getImages().add(postImagesService.getOne(POST_IMAGES_ENTITY.POST_ID.eq(postsEntity.getPostId())));
//            System.out.println(postWithImageAuthor);
            return postWithImageAuthor;
        }).toList();
        postWithImageAuthorPage.setRecords(convertedList);
        return postWithImageAuthorPage;
    }
}