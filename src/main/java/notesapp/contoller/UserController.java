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
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final NoteService noteService;

    @Autowired
    public UserController(UserService userService, NoteService noteService){
        this.userService = userService;
        this.noteService = noteService;
    }

    //Create a new user
    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    //Get all users
    @GetMapping()
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    //Get a user by id
    @GetMapping("/{id}")
    public User getUsersById(@PathVariable(value = "id") String id) {
        return userService.getUserById(id);
    }


    //Update user
    @PutMapping()
    public User updateUser(@RequestBody @Valid User user){
        List<Note> notes = user.getNotes();
        if (notes.size()!=0){
            for (Note note:notes) {
                note.setUser(user.getId());
                noteService.saveNote(note);
            }
        }
        return userService.saveUser(user);
    }

    //Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") String id){
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return ResponseEntity.ok().build();
    }

}
