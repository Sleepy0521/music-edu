package com.music.controller;

import com.alibaba.fastjson.JSON;
import com.music.entities.Note;
import com.music.file.FileUtil;
import com.music.service.NoteService;
import com.music.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.lang.model.SourceVersion;
import javax.servlet.ServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/article")
public class NoteController {
    @Autowired
    NoteService noteService;

    @Autowired
    FileUtil fileUtil;

    @PostMapping(value = "/insertArticle", produces = "application/json;charset=UTF-8")
    public Msg insertArticle(@RequestBody Note note) {
        if (noteService.insertArticle(note) != 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }

    }

    @PostMapping(value = "/pngUpload")
    public Msg pngUPload(@RequestParam("file") MultipartFile file, String fileName) {
        String imgSrc = fileUtil.upFileMethod(file,fileName);
        if (imgSrc != null && !imgSrc.isEmpty()) {
            return Msg.success().add("imgSrc", imgSrc);
        } else {
            return Msg.fail();
        }
    }
    @PostMapping(value = "/fileUpload2")
    public String fileUpload2(@RequestParam("upfile") MultipartFile file) {
        String fileName = fileUtil.upFileMethod(file);
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("url", "/"+fileName);// 展示图片的请求url
        result.put("state", "SUCCESS");
        String jStr = JSON.toJSONString(result);
        return jStr;
    }

    @GetMapping(value = "/getAllArticle")
    public Msg getAllArticle() {
        List<Note> notes=noteService.getAllArticle();
        return Msg.success().add("graphicsList",notes);
    }
    @GetMapping(value = "/getArticle/{id}")
    public Msg getArticle(@PathVariable("id") Integer id){
        Note note=noteService.getArticle(id);
        return Msg.success().add("article",note);
    }
    //ueditor视频上传
    @PostMapping("/uploadVideo")
    public String uploadVideo(@RequestParam("upvideo") MultipartFile upvideo)  {
        String fileName=fileUtil.upFileMethod(upvideo);
        //return "../../upload/"+fileName;
        return "/"+fileName;
    }
}
