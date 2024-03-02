package com.yjxw.mapper;

import com.yjxw.model.VerificationCodeEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 存储用户邮箱验证码的表 映射层。
 *
 * @author yjxw
 * @since 1.0
 */
@Mapper
public interface VerificationCodeMapper extends BaseMapper<VerificationCodeEntity> {


}
