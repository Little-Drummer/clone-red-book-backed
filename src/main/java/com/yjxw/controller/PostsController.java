package com.yjxw.controller;

import com.mybatisflex.core.paginate.Page;
import com.yjxw.model.PostsEntity;
import com.yjxw.model.Result;
import com.yjxw.model.constant.ResponseConstant;
import com.yjxw.model.vo.PostWithImageAuthor;
import com.yjxw.service.PostsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 存储用户发布的文章信息，包括标题、内容、互动计数等 控制层。
 *
 * @author yjxw
 * @since 1.0
 */
@RestController
@RequestMapping("/posts")
@Tag(name = "存储用户发布的文章信息，包括标题、内容、互动计数等控制层")
public class PostsController {

    @Autowired
    private PostsService postsService;

    /**
     * 添加 存储用户发布的文章信息，包括标题、内容、互动计数等
     *
     * @param posts 存储用户发布的文章信息，包括标题、内容、互动计数等
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    @Operation(summary = "添加存储用户发布的文章信息，包括标题、内容、互动计数等")
    @Parameters(value = {
            @Parameter(name = "postId", description = "主键，文章的唯一标识符，自动增长"),

            @Parameter(name = "title", description = "文章的标题"),

            @Parameter(name = "authorId", description = "外键，关联到authors表的author_id，标识文章的作者"),

            @Parameter(name = "content", description = "文章的主体内容"),

            @Parameter(name = "likesCount", description = "文章获得的喜欢(点赞)数量"),

            @Parameter(name = "favoritesCount", description = "文章被收藏的次数"),

            @Parameter(name = "commentsCount", description = "文章的评论数量"),

            @Parameter(name = "createdAt", description = "记录文章创建的时间"),

            @Parameter(name = "updatedAt", description = "记录文章最后被修改的时间")
    })
    public boolean save(@RequestBody PostsEntity posts) {
        return postsService.save(posts);
    }


    /**
     * 根据主键删除存储用户发布的文章信息，包括标题、内容、互动计数等
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("/remove/{id}")
    @Operation(summary = "根据主键删除存储用户发布的文章信息，包括标题、内容、互动计数等")
    @Parameters(value = {
            @Parameter(name = "postId", description = "主键，文章的唯一标识符，自动增长", required = true)
    })
    public boolean remove(@PathVariable Serializable id) {
        return postsService.removeById(id);
    }


    /**
     * 根据主键更新存储用户发布的文章信息，包括标题、内容、互动计数等
     *
     * @param posts 存储用户发布的文章信息，包括标题、内容、互动计数等
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    @Operation(summary = "根据主键更新存储用户发布的文章信息，包括标题、内容、互动计数等")
    @Parameters(value = {
            @Parameter(name = "postId", description = "主键，文章的唯一标识符，自动增长", required = true),

            @Parameter(name = "title", description = "文章的标题"),

            @Parameter(name = "authorId", description = "外键，关联到authors表的author_id，标识文章的作者"),

            @Parameter(name = "content", description = "文章的主体内容"),

            @Parameter(name = "likesCount", description = "文章获得的喜欢(点赞)数量"),

            @Parameter(name = "favoritesCount", description = "文章被收藏的次数"),

            @Parameter(name = "commentsCount", description = "文章的评论数量"),

            @Parameter(name = "createdAt", description = "记录文章创建的时间"),

            @Parameter(name = "updatedAt", description = "记录文章最后被修改的时间")
    })
    public boolean update(@RequestBody PostsEntity posts) {
        return postsService.updateById(posts);
    }


    /**
     * 查询所有存储用户发布的文章信息，包括标题、内容、互动计数等
     *
     * @return 所有数据
     */
    @GetMapping("/list")
    @Operation(summary = "查询所有存储用户发布的文章信息，包括标题、内容、互动计数、图片、作者等")
    public Result<List<PostWithImageAuthor>> list() {

        List<PostWithImageAuthor> listWithImageAuthor = postsService.listWithImageAuthor();
        if (listWithImageAuthor != null) {
            return Result.success(listWithImageAuthor);
        } else {
            return Result.error(ResponseConstant.INTERNAL_SERVER_ERROR.getCode(), ResponseConstant.INTERNAL_SERVER_ERROR.getMessage());
        }
    }


    /**
     * 根据存储用户发布的文章信息，包括标题、内容、互动计数等主键获取详细信息。
     *
     * @param id posts主键
     * @return 存储用户发布的文章信息，包括标题、内容、互动计数等详情
     */
    @GetMapping("/getInfo/{id}")
    @Operation(summary = "根据存储用户发布的文章信息，包括标题、内容、互动计数等主键获取详细信息")
    @Parameters(value = {
            @Parameter(name = "postId", description = "主键，文章的唯一标识符，自动增长", required = true)
    })
    public PostsEntity getInfo(@PathVariable Serializable id) {
        return postsService.getById(id);
    }

    /**
     * 分页查询存储用户发布的文章信息，包括标题、内容、互动计数等
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询存储用户发布的文章信息，包括标题、内容、互动计数等")
    @Parameters(value = {
            @Parameter(name = "pageNumber", description = "页码", required = true),
            @Parameter(name = "pageSize", description = "每页大小", required = true)
    })
    public Result<Page<PostWithImageAuthor>> page(Page<PostsEntity> page) {
        Page<PostWithImageAuthor> postWithImageAuthorPage = postsService.pageWithImageAuthor(page);
        if (postWithImageAuthorPage != null) {
            return Result.success(postWithImageAuthorPage);
        } else {
            return Result.error(ResponseConstant.INTERNAL_SERVER_ERROR.getCode(), ResponseConstant.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
}