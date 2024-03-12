package com.yjxw.controller;

import com.mybatisflex.core.paginate.Page;
import com.yjxw.model.Result;
import com.yjxw.model.VerificationCodeEntity;
import com.yjxw.model.constant.ResponseConstant;
import com.yjxw.model.dto.EmailDTO;
import com.yjxw.service.VerificationCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 存储用户邮箱验证码的表 控制层。
 *
 * @author yjxw
 * @since 1.0
 */
@RestController
@RequestMapping("/verificationCode")
@Tag(name = "存储用户邮箱验证码的表控制层")
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    /**
     * 添加 存储用户邮箱验证码的表
     *
     * @param verificationCode 存储用户邮箱验证码的表
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    @Operation(summary = "添加存储用户邮箱验证码的表")
    @Parameters(value = {
            @Parameter(name = "id", description = "主键，自增长唯一标识"),

            @Parameter(name = "email", description = "用户邮箱地址"),

            @Parameter(name = "code", description = "验证码"),

            @Parameter(name = "createTime", description = "验证码创建时间"),

            @Parameter(name = "expireTime", description = "验证码过期时间")
    })
    public boolean save(@RequestBody VerificationCodeEntity verificationCode) {
        return verificationCodeService.save(verificationCode);
    }


    /**
     * 根据主键删除存储用户邮箱验证码的表
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("/remove/{id}")
    @Operation(summary = "根据主键删除存储用户邮箱验证码的表")
    @Parameters(value = {
            @Parameter(name = "id", description = "主键，自增长唯一标识", required = true)
    })
    public boolean remove(@PathVariable Serializable id) {
        return verificationCodeService.removeById(id);
    }


    /**
     * 根据主键更新存储用户邮箱验证码的表
     *
     * @param verificationCode 存储用户邮箱验证码的表
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    @Operation(summary = "根据主键更新存储用户邮箱验证码的表")
    @Parameters(value = {
            @Parameter(name = "id", description = "主键，自增长唯一标识", required = true),

            @Parameter(name = "email", description = "用户邮箱地址"),

            @Parameter(name = "code", description = "验证码"),

            @Parameter(name = "createTime", description = "验证码创建时间"),

            @Parameter(name = "expireTime", description = "验证码过期时间")
    })
    public boolean update(@RequestBody VerificationCodeEntity verificationCode) {
        return verificationCodeService.updateById(verificationCode);
    }


    /**
     * 查询所有存储用户邮箱验证码的表
     *
     * @return 所有数据
     */
    @GetMapping("/list")
    @Operation(summary = "查询所有存储用户邮箱验证码的表")
    public List<VerificationCodeEntity> list() {
        return verificationCodeService.list();
    }


    /**
     * 根据存储用户邮箱验证码的表主键获取详细信息。
     *
     * @param id verificationCode主键
     * @return 存储用户邮箱验证码的表详情
     */
    @GetMapping("/getInfo/{id}")
    @Operation(summary = "根据存储用户邮箱验证码的表主键获取详细信息")
    @Parameters(value = {
            @Parameter(name = "id", description = "主键，自增长唯一标识", required = true)
    })
    public VerificationCodeEntity getInfo(@PathVariable Serializable id) {
        return verificationCodeService.getById(id);
    }


    /**
     * 分页查询存储用户邮箱验证码的表
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询存储用户邮箱验证码的表")
    @Parameters(value = {
            @Parameter(name = "pageNumber", description = "页码", required = true),
            @Parameter(name = "pageSize", description = "每页大小", required = true)
    })
    public Page<VerificationCodeEntity> page(Page<VerificationCodeEntity> page) {
        return verificationCodeService.page(page);
    }

    @PostMapping("/sendVerificationCode")
    @Operation(summary = "发送验证码")
    @Parameters(value = {
            @Parameter(name = "email", description = "邮箱地址", required = true)
    })
    public Result sendVerificationCode(@RequestBody EmailDTO emailDTO) {

        boolean isOk  = verificationCodeService.sendVerificationCode(emailDTO.getEmail());
        if (isOk) {
            return Result.success(ResponseConstant.SUCCESS.getMessage());
        } else {
            return Result.error(ResponseConstant.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseConstant.INTERNAL_SERVER_ERROR.getMessage());
        }

    }
}