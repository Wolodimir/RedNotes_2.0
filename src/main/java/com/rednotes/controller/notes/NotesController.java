package com.rednotes.controller.notes;

import com.rednotes.dao.NoteRepo;
import com.rednotes.dao.UserRepo;
import com.rednotes.model.Note;
import com.rednotes.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rednotes/notes")
public class NotesController {

    private final NoteRepo noteRepo;
    private final UserRepo userRepo;

    public NotesController(NoteRepo noteRepo, UserRepo userRepo) {
        this.noteRepo = noteRepo;
        this.userRepo = userRepo;
    }

    @GetMapping
    public String mainNotesPage(@AuthenticationPrincipal User user, Model model){

        Iterable<Note> persNotes = noteRepo.findByAuthor(user);
        model.addAttribute("persNotes", persNotes);



        return "notes/notes-main";
    }

    @PostMapping("/createNote")
    public String createNote(
            @AuthenticationPrincipal User user,
            Model model,
            @RequestParam String text,
            @RequestParam String heading,
            @RequestParam boolean available
            ){


        Note note = new Note(text, heading, user, available);
        noteRepo.save(note);
        return "redirect:/rednotes/notes";
    }
}
