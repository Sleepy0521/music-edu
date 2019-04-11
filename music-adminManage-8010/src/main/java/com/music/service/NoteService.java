package com.music.service;

import com.music.dao.NoteMapper;
import com.music.entities.Note;
import com.music.entities.NoteExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteMapper noteMapper;

    public int insertArticle(Note note) {
        note.setCreateTime(new Date());
        note.setUpdateTime(new Date());
        note.setStatus(0);

        return noteMapper.insertSelective(note);
    }

    public List<Note> getAllArticle() {
        return noteMapper.selectByExample(new NoteExample());
    }

    public Note getArticle(Integer id) {
        NoteExample noteExample=new NoteExample();
        noteExample.or().andIdEqualTo(id);
        return noteMapper.selectByExample(noteExample).get(0);
    }
}
