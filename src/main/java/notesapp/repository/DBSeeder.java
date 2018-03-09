package notesapp.repository;

import notesapp.model.Note;
import notesapp.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {

    private NoteRepository noteRepository;
    private UserRepository userRepository;

    public DBSeeder(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Note note1 = new Note("nota 1","2012/12/3","");
        Note note2 = new Note("nota 2","2012/12/1","");
        Note note3 = new Note("nota 3","2012/12/2","");
        Note note4 = new Note("nota 4","2012/12/4","");

        List<Note> notes = Arrays.asList(note1,note2,note3,note4);

        //this.noteRepository.deleteAll();
        //this.noteRepository.save(notes);

        User user1 = new User("edwin","1234");

        List<User> users = Arrays.asList(user1);

        //this.userRepository.deleteAll();
        //this.userRepository.save(users);

    }
}
