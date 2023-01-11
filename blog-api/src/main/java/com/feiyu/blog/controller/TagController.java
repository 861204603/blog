package com.feiyu.blog.controller;

import com.feiyu.blog.service.TagService;
import com.feiyu.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tags")
@Slf4j
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("hot")
    public Result hot() {
        log.info("收到请求：/tags/hot");
        int limit = 6;
        return tagService.hots(limit);
    }
}
