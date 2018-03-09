package notesapp.service;

import notesapp.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    Note saveNote(Note note);

    List<Note> findAllNotes();

    Note getNoteById(String id);

    void deleteNote(Note note);
}
