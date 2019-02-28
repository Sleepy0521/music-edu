package com.music.dao;


import com.music.entities.Video;
import com.music.entities.VideoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    long countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);
}