package com.yjxw.mapper;

import com.yjxw.model.PostsEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 存储用户发布的文章信息，包括标题、内容、互动计数等 映射层。
 *
 * @author yjxw
 * @since 1.0
 */
@Mapper
public interface PostsMapper extends BaseMapper<PostsEntity> {


}
