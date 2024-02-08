package com.yjxw.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.yjxw.service.PostImagesService;
import com.yjxw.model.PostImagesEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 存储文章相关图片的信息，每条记录代表一张图片 控制层。
 *
 * @author yjxw
 * @since 1.0
 */
@RestController
@RequestMapping("/postImages")
@Tag(name = "存储文章相关图片的信息，每条记录代表一张图片控制层")
public class PostImagesController {

    @Autowired
    private PostImagesService postImagesService;

    /**
     * 添加 存储文章相关图片的信息，每条记录代表一张图片
     *
     * @param postImages 存储文章相关图片的信息，每条记录代表一张图片
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    @Operation(summary = "添加存储文章相关图片的信息，每条记录代表一张图片")
    @Parameters(value = {
            @Parameter(name = "imageId", description = "主键，图片的唯一标识符，自动增长"),

            @Parameter(name = "postId", description = "外键，关联到posts表的post_id，标识图片所属的文章"),

            @Parameter(name = "imageUrl", description = "图片的URL链接，存储图片的实际位置"),

            @Parameter(name = "createdAt", description = "记录图片添加到数据库的时间")
    })
    public boolean save(@RequestBody PostImagesEntity postImages) {
        return postImagesService.save(postImages);
    }


    /**
     * 根据主键删除存储文章相关图片的信息，每条记录代表一张图片
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("/remove/{id}")
    @Operation(summary = "根据主键删除存储文章相关图片的信息，每条记录代表一张图片")
    @Parameters(value = {
            @Parameter(name = "imageId", description = "主键，图片的唯一标识符，自动增长", required = true)
    })
    public boolean remove(@PathVariable Serializable id) {
        return postImagesService.removeById(id);
    }


    /**
     * 根据主键更新存储文章相关图片的信息，每条记录代表一张图片
     *
     * @param postImages 存储文章相关图片的信息，每条记录代表一张图片
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    @Operation(summary = "根据主键更新存储文章相关图片的信息，每条记录代表一张图片")
    @Parameters(value = {
            @Parameter(name = "imageId", description = "主键，图片的唯一标识符，自动增长", required = true),

            @Parameter(name = "postId", description = "外键，关联到posts表的post_id，标识图片所属的文章"),

            @Parameter(name = "imageUrl", description = "图片的URL链接，存储图片的实际位置"),

            @Parameter(name = "createdAt", description = "记录图片添加到数据库的时间")
    })
    public boolean update(@RequestBody PostImagesEntity postImages) {
        return postImagesService.updateById(postImages);
    }


    /**
     * 查询所有存储文章相关图片的信息，每条记录代表一张图片
     *
     * @return 所有数据
     */
    @GetMapping("/list")
    @Operation(summary = "查询所有存储文章相关图片的信息，每条记录代表一张图片")
    public List<PostImagesEntity> list() {
        return postImagesService.list();
    }


    /**
     * 根据存储文章相关图片的信息，每条记录代表一张图片主键获取详细信息。
     *
     * @param id postImages主键
     * @return 存储文章相关图片的信息，每条记录代表一张图片详情
     */
    @GetMapping("/getInfo/{id}")
    @Operation(summary = "根据存储文章相关图片的信息，每条记录代表一张图片主键获取详细信息")
    @Parameters(value = {
            @Parameter(name = "imageId", description = "主键，图片的唯一标识符，自动增长", required = true)
    })
    public PostImagesEntity getInfo(@PathVariable Serializable id) {
        return postImagesService.getById(id);
    }


    /**
     * 分页查询存储文章相关图片的信息，每条记录代表一张图片
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询存储文章相关图片的信息，每条记录代表一张图片")
    @Parameters(value = {
            @Parameter(name = "pageNumber", description = "页码", required = true),
            @Parameter(name = "pageSize", description = "每页大小", required = true)
    })
    public Page<PostImagesEntity> page(Page<PostImagesEntity> page) {
        return postImagesService.page(page);
    }
}