package com.rednotes.dao;

import com.rednotes.model.Note;
import com.rednotes.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepo extends CrudRepository<Note, Integer> {
    List<Note> findByHeading(String tag);
    List<Note> findByAuthor(User author);
}
