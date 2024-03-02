package com.yjxw.service;


import com.mybatisflex.core.service.IService;
import com.yjxw.model.UsersEntity;
import com.yjxw.model.dto.UserRegisterDTO;
import com.yjxw.model.service_response.ServiceResponse;

/**
 * 用户信息表 服务层。
 *
 * @author yjxw
 * @since 1.0
 */
public interface UsersService extends IService<UsersEntity> {

    /**
     * 用户注册
     * @param userRegisterDTO 用户注册对象
     * @return 是否注册成功
     */
    ServiceResponse register(UserRegisterDTO userRegisterDTO);
}