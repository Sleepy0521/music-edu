package com.music.service;

import com.music.utils.Msg;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
@FeignClient(value = "music-provider")
public interface VideoClientUpload {


    @PostMapping(value = "/uploadVideo",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Msg uploadVideo(@RequestPart(value = "file") MultipartFile file);


}