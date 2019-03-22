package com.music.controller;

import com.music.entities.Note;
import com.music.file.FileUtil;
import com.music.service.NoteService;
import com.music.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public Msg pngUPload(@RequestParam("file") MultipartFile file) {
        String imgSrc = fileUtil.upFileMethod(file);
        if (imgSrc != null && !imgSrc.isEmpty()) {
            return Msg.success().add("imgSrc", imgSrc);
        } else {
            return Msg.fail();
        }


    }

    @GetMapping(value = "/getAllArticle")
    public Msg getAllArticle() {
        List<Note> notes=noteService.getAllArticle();
        return Msg.success().add("graphicsList",notes);
    }
}
