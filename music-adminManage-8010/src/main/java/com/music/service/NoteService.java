package com.music.service;

import com.music.dao.NoteMapper;
import com.music.entities.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    NoteMapper noteMapper;

    public int insertArticle(Note note) {
        return noteMapper.insertSelective(note);
    }
}
