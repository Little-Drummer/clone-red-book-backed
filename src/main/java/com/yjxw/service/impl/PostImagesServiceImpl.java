package com.yjxw.service.impl;


import org.springframework.stereotype.Service;
import com.yjxw.service.PostImagesService;
import com.yjxw.model.PostImagesEntity;
import com.yjxw.mapper.PostImagesMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

/**
 * 存储文章相关图片的信息，每条记录代表一张图片 服务层实现。
 *
 * @author yjxw
 * @since 1.0
 */
@Service
public class PostImagesServiceImpl extends ServiceImpl<PostImagesMapper, PostImagesEntity> implements PostImagesService {

}