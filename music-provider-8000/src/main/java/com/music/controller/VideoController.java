package com.music.controller;


import com.music.entities.Video;
import com.music.service.VideoService;
import com.music.file.FileUtil;
import com.music.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
public class VideoController {
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private VideoService videoService;


    @GetMapping("/get")
    public Msg get(){
        return Msg.success().add("info","成功调取到了provider的get接口内容");
    }


    //视频文件上传
    @PostMapping("/uploadVideo")
    public Msg uploadVideo(@RequestParam("file") MultipartFile file)  {
        String fileName = fileUtil.upFileMethod(file);
        return Msg.success().add("videoName",fileName);
    }
    //视频信息存储
    @PostMapping("/insertVideo")
    public Msg insertVideo(Video video){
        video.setUpdateTime(new Date());
        System.out.println(video);
        if(videoService.insertVideo(video)!=0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
        /*return Msg.fail();*/
    }








}
