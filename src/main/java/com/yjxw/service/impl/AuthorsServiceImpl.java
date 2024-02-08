package com.yjxw.service.impl;


import org.springframework.stereotype.Service;
import com.yjxw.service.AuthorsService;
import com.yjxw.model.AuthorsEntity;
import com.yjxw.mapper.AuthorsMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

/**
 * 存储文章作者的基本信息 服务层实现。
 *
 * @author yjxw
 * @since 1.0
 */
@Service
public class AuthorsServiceImpl extends ServiceImpl<AuthorsMapper, AuthorsEntity> implements AuthorsService {

}