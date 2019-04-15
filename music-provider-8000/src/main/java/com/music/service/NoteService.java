package com.music.service;

import com.music.dao.NoteMapper;
import com.music.entities.Note;
import com.music.entities.NoteExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteMapper noteMapper;

    public List<Note> getNote() {
        return noteMapper.selectByExample(new NoteExample());
    }
}
