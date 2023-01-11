package com.feiyu.blog.service.impl;

import com.feiyu.blog.dao.mapper.TagMapper;
import com.feiyu.blog.dao.pojo.Tag;
import com.feiyu.blog.service.TagService;
import com.feiyu.blog.vo.Result;
import com.feiyu.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    public TagVo copy(Tag tag) {
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag, tagVo);
        return tagVo;
    }

    public List<TagVo> copyList(List<Tag> tagList) {
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tags = tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        /**
         * 1.标签所拥有的文章数量最多
         * 2.根据tag_id 分组计数，从大到小排列，去前limit个
         */
        List<Long> tagIds = tagMapper.findHotsTagsIds(limit);
        if(CollectionUtils.isEmpty(tagIds)){
            return Result.success(Collections.emptyList());
        }
        //还需要tagName
        List<Tag> tagList = tagMapper.findTagsByTagIds(tagIds);

        return Result.success(tagList);
    }


}
