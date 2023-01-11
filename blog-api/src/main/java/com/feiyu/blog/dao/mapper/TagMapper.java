package com.feiyu.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feiyu.blog.dao.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 根据文章id查询标签列表
     *
     * @param articleId
     * @return
     */
    @Select("select id,avatar,tag_name as tagName from ms_tag " +
            "where id in (select tag_id from ms_article_tag where article_id=#{articleId})")
    List<Tag> findTagsByArticleId(Long articleId);

    @Select("select tag_id from ms_article_tag group by tag_id order by count(*) desc limit #{limit}")
    List<Long> findHotsTagsIds(int limit);

    //@Select("select id,tag_name as tagName from ms_tag where id in (<foreach collection=> )")
    List<Tag> findTagsByTagIds(List<Long> tagIds);
}
