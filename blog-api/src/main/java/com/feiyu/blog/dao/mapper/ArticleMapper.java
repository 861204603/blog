package com.feiyu.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feiyu.blog.dao.dos.Archives;
import com.feiyu.blog.dao.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    @Select("select year(from_unixtime(create_date/1000)) as year,month(from_unixtime(create_date/1000)) as month,count(*) as count from ms_article group by year,month")
    List<Archives> listArchives();
}
