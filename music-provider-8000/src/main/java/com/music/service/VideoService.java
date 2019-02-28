package com.music.service;


import com.music.dao.VideoMapper;
import com.music.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    @Autowired
    private VideoMapper videoMapper;

    public int insertVideo(Video video) {
        return videoMapper.insertSelective(video);
    }
}
