package com.rednotes.controller.notes;

import com.rednotes.dao.NoteRepo;
import com.rednotes.dao.UserRepo;
import com.rednotes.model.Note;
import com.rednotes.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

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

        Iterable<Note> allNotes = noteRepo.findAll();
        model.addAttribute("allNotes", allNotes);

        model.addAttribute("user", user);

        return "notes/notes-main";
    }

    @PostMapping("/createNote")
    public String createNote(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String heading,
            @RequestParam boolean available
            ){


        Note note = new Note(text, heading, user, available);
        noteRepo.save(note);
        return "redirect:/rednotes/notes";
    }

    @GetMapping("/{id}")
    public String editPage(@PathVariable(value = "id") Integer id, Model model){
        if(!noteRepo.existsById(id)){
            return "redirect:/rednotes/notes";
        }
        Optional<Note> note = noteRepo.findById(id);
        ArrayList<Note> n = new ArrayList<>();
        note.ifPresent(n::add);
        model.addAttribute("note", n);
        return "notes/edit";
    }

    @PostMapping("/{id}/add")
    public String updateNote(
            @PathVariable(value = "id")Integer id,
            @RequestParam String heading,
            @RequestParam String text
            ){
        Optional<Note> note = noteRepo.findById(id);
        ArrayList<Note> n = new ArrayList<>();
        note.ifPresent(n::add);
        Note ng = n.get(n.size()-1);
        ng.setHeading(heading);
        ng.setText(text);
        noteRepo.save(ng);
        return "redirect:/rednotes/notes";
    }

    @GetMapping ("/{id}/delete")
    public String deleteNote(@PathVariable(value = "id") Integer id){
        noteRepo.deleteById(id);
        return "redirect:/rednotes/notes";
    }

}
