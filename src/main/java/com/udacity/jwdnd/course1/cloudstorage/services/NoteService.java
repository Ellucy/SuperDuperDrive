package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private NoteMapper noteMapper;

    public List<Note> getAllNotes() {
        return noteMapper.getAllNotes();
    }

    public int createOrUpdateNote(Note note) {
        if (note.getNoteId() == null) {
            return noteMapper.insertNotes(note);
        } else {
            return noteMapper.updateNote(note);
        }
    }

    public int deleteNoteById(Integer noteId) {
        return noteMapper.deleteNoteById(noteId);
    }
}
