package com.feiyu.blog.service;

import com.feiyu.blog.vo.Result;
import com.feiyu.blog.vo.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);
}
