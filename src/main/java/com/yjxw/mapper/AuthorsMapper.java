package com.yjxw.mapper;

import com.yjxw.model.AuthorsEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 存储文章作者的基本信息 映射层。
 *
 * @author yjxw
 * @since 1.0
 */
@Mapper
public interface AuthorsMapper extends BaseMapper<AuthorsEntity> {


}
