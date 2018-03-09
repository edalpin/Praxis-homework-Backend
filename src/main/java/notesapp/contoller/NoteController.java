package notesapp.contoller;

import notesapp.model.Note;
import notesapp.model.User;
import notesapp.service.NoteService;
import notesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/notes")
public class NoteController {

    private NoteService noteService;
    private UserService userService;

    @Autowired
    public NoteController(NoteService noteService, UserService userService){
        this.userService = userService;
        this.noteService = noteService;
    }

    //Get all notes
    @GetMapping()
    public List<Note> getUsers() {
        return noteService.findAllNotes();
    }

    //Get a note by id
    @GetMapping("/{id}")
    public Note getNotesById(@PathVariable(value = "id") String id) {
        return noteService.getNoteById(id);
    }

    //Create a new note
    @PostMapping()
    public Note createNote(@RequestBody @Valid Note note) {
        return noteService.saveNote(note);
    }

    //Update note
    @PutMapping()
    public Note updateNote(@RequestBody @Valid Note note){
        String userid = note.getUser();
        User user = userService.getUserById(userid);
        List<Note> notes = user.getNotes();
        if(notes.size()!= 0 ){
            for (Note noteaux: notes) {
                if (noteaux.getId().equals(note.getId())){
                    int index = notes.indexOf(noteaux);
                    notes.remove(index);
                    notes.add(note);
                }
            }
        }
        userService.saveUser(user);
        return noteService.saveNote(note);
    }

    //Delete note
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") String id){
        Note note = noteService.getNoteById(id);
        noteService.deleteNote(note);
        return ResponseEntity.ok().build();
    }

}
