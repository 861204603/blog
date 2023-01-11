package com.feiyu.blog.controller;

import com.feiyu.blog.service.ArticleService;
import com.feiyu.blog.vo.Result;
import com.feiyu.blog.vo.params.PageParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//json数据交互
@RestController
@RequestMapping("articles")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 首页 文章列表
     */
    @PostMapping()
    public Result listArticle(@RequestBody PageParams pageParams) {
        log.info("收到请求：/articles");
        return articleService.listArticle(pageParams);
    }

    /**
     * 首页 最热文章
     * @return
     */
    @PostMapping("hot")
    public Result hotArticle() {
        log.info("收到请求：/articles/hot");
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    /**
     * 首页 最新文章
     * @return
     */
    @PostMapping("new")
    public Result newArticle() {
        log.info("收到请求：/articles/new");
        int limit = 5;
        return articleService.newArticle(limit);
    }

    /**
     * 首页 最新文章
     * @return
     */
    @PostMapping("listArchives")
    public Result listArchives() {
        log.info("收到请求：/articles/listArchives");
        return articleService.listArchives();
    }
}
