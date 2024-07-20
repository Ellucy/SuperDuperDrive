package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public String getNotes(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "home";
    }

    @PostMapping
    public String createOrUpdateNote(@ModelAttribute Note note) {
        noteService.createOrUpdateNote(note);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") Integer noteId) {
        noteService.deleteNoteById(noteId);
        return "redirect:/home";
    }
}
