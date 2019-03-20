package com.music.controller;

import com.music.entities.Note;
import com.music.service.NoteService;
import com.music.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
public class NoteController {
    @Autowired
    NoteService noteService;

    @PostMapping("/insertArticle")
    public Msg insertArticle(@RequestBody Note note){
        if(noteService.insertArticle(note)!=0){
            return Msg.success();
        }else{
            return Msg.fail();
        }

    }
}
