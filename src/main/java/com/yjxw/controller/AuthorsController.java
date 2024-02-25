package com.yjxw.controller;

import com.mybatisflex.core.paginate.Page;
import com.yjxw.model.AuthorsEntity;
import com.yjxw.service.AuthorsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 存储文章作者的基本信息 控制层。
 *
 * @author yjxw
 * @since 1.0
 */
@RestController
@RequestMapping("/authors")
@Tag(name = "存储文章作者的基本信息控制层")
public class AuthorsController {

    @Autowired
    private AuthorsService authorsService;

    /**
     * 添加 存储文章作者的基本信息
     *
     * @param authors 存储文章作者的基本信息
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    @Operation(summary = "添加存储文章作者的基本信息")
    @Parameters(value = {
            @Parameter(name = "authorId", description = "作者的唯一标识符，主键，自动增长"),

            @Parameter(name = "name", description = "作者的姓名"),

            @Parameter(name = "email", description = "作者的电子邮件地址，唯一"),

            @Parameter(name = "bio", description = "作者的简介，可存储较长文本"),

            @Parameter(name = "profilePictureUrl", description = "作者的头像图片链接"),

            @Parameter(name = "createdAt", description = "记录作者创建的时间"),

            @Parameter(name = "updatedAt", description = "记录作者信息最后更新的时间")
    })
    public boolean save(@RequestBody AuthorsEntity authors) {
        return authorsService.save(authors);
    }


    /**
     * 根据主键删除存储文章作者的基本信息
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
        @DeleteMapping("/remove/{id}")
    @Operation(summary = "根据主键删除存储文章作者的基本信息")
    @Parameters(value = {
            @Parameter(name = "authorId", description = "作者的唯一标识符，主键，自动增长", required = true)
    })
    public boolean remove(@PathVariable Serializable id) {
        return authorsService.removeById(id);
    }


    /**
     * 根据主键更新存储文章作者的基本信息
     *
     * @param authors 存储文章作者的基本信息
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    @Operation(summary = "根据主键更新存储文章作者的基本信息")
    @Parameters(value = {
            @Parameter(name = "authorId", description = "作者的唯一标识符，主键，自动增长", required = true),

            @Parameter(name = "name", description = "作者的姓名"),

            @Parameter(name = "email", description = "作者的电子邮件地址，唯一"),

            @Parameter(name = "bio", description = "作者的简介，可存储较长文本"),

            @Parameter(name = "profilePictureUrl", description = "作者的头像图片链接"),

            @Parameter(name = "createdAt", description = "记录作者创建的时间"),

            @Parameter(name = "updatedAt", description = "记录作者信息最后更新的时间")
    })
    public boolean update(@RequestBody AuthorsEntity authors) {
        return authorsService.updateById(authors);
    }


    /**
     * 查询所有存储文章作者的基本信息
     *
     * @return 所有数据
     */
    @GetMapping("/list")
    @Operation(summary = "查询所有存储文章作者的基本信息")
    public List<AuthorsEntity> list() {
        return authorsService.list();
    }


    /**
     * 根据存储文章作者的基本信息主键获取详细信息。
     *
     * @param id authors主键
     * @return 存储文章作者的基本信息详情
     */
    @GetMapping("/getInfo/{id}")
    @Operation(summary = "根据存储文章作者的基本信息主键获取详细信息")
    @Parameters(value = {
            @Parameter(name = "authorId", description = "作者的唯一标识符，主键，自动增长", required = true)
    })
    public AuthorsEntity getInfo(@PathVariable Serializable id) {
        return authorsService.getById(id);
    }


    /**
     * 分页查询存储文章作者的基本信息
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询存储文章作者的基本信息")
    @Parameters(value = {
            @Parameter(name = "pageNumber", description = "页码", required = true),
            @Parameter(name = "pageSize", description = "每页大小", required = true)
    })
    public Page<AuthorsEntity> page(Page<AuthorsEntity> page) {
        return authorsService.page(page);
    }
}