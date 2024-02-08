package com.yjxw.mapper;

import com.yjxw.model.PostImagesEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 存储文章相关图片的信息，每条记录代表一张图片 映射层。
 *
 * @author yjxw
 * @since 1.0
 */
@Mapper
public interface PostImagesMapper extends BaseMapper<PostImagesEntity> {


}
