package com.yjxw.mapper;

import com.yjxw.model.UsersEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表 映射层。
 *
 * @author yjxw
 * @since 1.0
 */
@Mapper
public interface UsersMapper extends BaseMapper<UsersEntity> {


}
