package com.yjxw.service.impl;


import cn.dev33.satoken.secure.BCrypt;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.yjxw.mapper.UsersMapper;
import com.yjxw.model.UsersEntity;
import com.yjxw.model.VerificationCodeEntity;
import com.yjxw.model.constant.ResultMessage;
import com.yjxw.model.constant.UserConstant;
import com.yjxw.model.dto.UserRegisterDTO;
import com.yjxw.model.service_response.ServiceResponse;
import com.yjxw.service.UsersService;
import com.yjxw.service.VerificationCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.yjxw.model.table.VerificationCodeEntityTableDef.VERIFICATION_CODE_ENTITY;

/**
 * 用户信息表 服务层实现。
 *
 * @author yjxw
 * @since 1.0
 */
@Service
@Slf4j
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersEntity> implements UsersService {

    @Autowired
    private VerificationCodeService verificationCodeService;

    /**
     * 用户注册逻辑
     * @param userRegisterDTO 用户注册对象
     * @return 是否注册成功
     */
    @Override
    public ServiceResponse register(UserRegisterDTO userRegisterDTO) {
        //1.判断邮箱是否已经注册  验证时已经判断
        log.info(userRegisterDTO.toString());
        //2.判断验证码是否正确
        List<VerificationCodeEntity> codeList = verificationCodeService.list(
                VERIFICATION_CODE_ENTITY.EMAIL.eq(userRegisterDTO.getEmail())
                        .and(VERIFICATION_CODE_ENTITY.CODE.eq(userRegisterDTO.getVerificationCode())
                                .and(VERIFICATION_CODE_ENTITY.CREATE_TIME.lt(LocalDateTime.now())
                                .and(VERIFICATION_CODE_ENTITY.EXPIRE_TIME.gt(LocalDateTime.now()))
                                )));
        if (codeList.isEmpty()) {
            return ServiceResponse.error("验证码错误");
        }
        //3.注册用户
        UsersEntity usersEntity = UsersEntity.builder()
                .email(userRegisterDTO.getEmail())
                .name("用户_" + userRegisterDTO.getEmail().substring(0, userRegisterDTO.getEmail().indexOf("@")))
                .bio("这个人很懒，什么都没有留下")
                .profilePictureUrl("https://storage.yjxw.win/d/default/circle.png")
                .userType(UserConstant.USER)
                .userPassword(BCrypt.hashpw(userRegisterDTO.getPassword(), BCrypt.gensalt()))
                .build();
        if (save(usersEntity)) {
            return ServiceResponse.success(ResultMessage.REGISTER_SUCCESS);
        } else {
            return ServiceResponse.error(ResultMessage.REGISTER_FAILED);
        }

    }
}