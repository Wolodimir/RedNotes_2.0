package com.rednotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rednotes/notes")
public class NotesController {
    @GetMapping
    public String notesIndex(){
        return "notes/notes-index";
    }
}
