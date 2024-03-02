package com.yjxw.controller;

import com.mybatisflex.core.paginate.Page;
import com.yjxw.model.Result;
import com.yjxw.model.UsersEntity;
import com.yjxw.model.constant.ResponseConstant;
import com.yjxw.model.dto.UserRegisterDTO;
import com.yjxw.model.service_response.ServiceResponse;
import com.yjxw.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息表 控制层。
 *
 * @author yjxw
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户信息表控制层")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 用户注册
     */
    @PostMapping("/register")
    @Operation(summary = "用户注册")
    @Parameters(value = {
            @Parameter(name = "email", description = "电子邮件地址", required = true),
            @Parameter(name = "password", description = "密码", required = true),
            @Parameter(name = "verificationCode", description = "验证码", required = true)
    })
    public Result<String> register(@RequestBody @Validated UserRegisterDTO userRegisterDTO) {
        ServiceResponse response = usersService.register(userRegisterDTO);
        if (response.isSuccess()) {
            return Result.success(response.getMessage());
        } else {
            return Result.error(ResponseConstant.INTERNAL_SERVER_ERROR.getCode(), response.getMessage());
        }
    }

    /**
     * 添加 用户信息表
     *
     * @param users 用户信息表
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    @Operation(summary = "添加用户信息表")
    @Parameters(value = {
            @Parameter(name = "userId", description = "用户ID"),

            @Parameter(name = "email", description = "电子邮件地址"),

            @Parameter(name = "name", description = "姓名"),

            @Parameter(name = "bio", description = "个人简介"),

            @Parameter(name = "profilePictureUrl", description = "个人头像URL"),

            @Parameter(name = "userType", description = "用户类型：0表示普通用户，1表示管理员等"),

            @Parameter(name = "userPassword", description = "用户密码"),

            @Parameter(name = "createdAt", description = "创建时间"),

            @Parameter(name = "updatedAt", description = "最后更新时间")
    })
    public boolean save(@RequestBody UsersEntity users) {
        return usersService.save(users);
    }


    /**
     * 根据主键删除用户信息表
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("/remove/{id}")
    @Operation(summary = "根据主键删除用户信息表")
    @Parameters(value = {
            @Parameter(name = "userId", description = "用户ID", required = true)
    })
    public boolean remove(@PathVariable Serializable id) {
        return usersService.removeById(id);
    }


    /**
     * 根据主键更新用户信息表
     *
     * @param users 用户信息表
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    @Operation(summary = "根据主键更新用户信息表")
    @Parameters(value = {
            @Parameter(name = "userId", description = "用户ID", required = true),

            @Parameter(name = "email", description = "电子邮件地址"),

            @Parameter(name = "name", description = "姓名"),

            @Parameter(name = "bio", description = "个人简介"),

            @Parameter(name = "profilePictureUrl", description = "个人头像URL"),

            @Parameter(name = "userType", description = "用户类型：0表示普通用户，1表示管理员等"),

            @Parameter(name = "userPassword", description = "用户密码"),

            @Parameter(name = "createdAt", description = "创建时间"),

            @Parameter(name = "updatedAt", description = "最后更新时间")
    })
    public boolean update(@RequestBody UsersEntity users) {
        return usersService.updateById(users);
    }


    /**
     * 查询所有用户信息表
     *
     * @return 所有数据
     */
    @GetMapping("/list")
    @Operation(summary = "查询所有用户信息表")
    public List<UsersEntity> list() {
        return usersService.list();
    }


    /**
     * 根据用户信息表主键获取详细信息。
     *
     * @param id users主键
     * @return 用户信息表详情
     */
    @GetMapping("/getInfo/{id}")
    @Operation(summary = "根据用户信息表主键获取详细信息")
    @Parameters(value = {
            @Parameter(name = "userId", description = "用户ID", required = true)
    })
    public UsersEntity getInfo(@PathVariable Serializable id) {
        return usersService.getById(id);
    }


    /**
     * 分页查询用户信息表
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询用户信息表")
    @Parameters(value = {
            @Parameter(name = "pageNumber", description = "页码", required = true),
            @Parameter(name = "pageSize", description = "每页大小", required = true)
    })
    public Page<UsersEntity> page(Page<UsersEntity> page) {
        return usersService.page(page);
    }
}