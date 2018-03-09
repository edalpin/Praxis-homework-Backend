package notesapp.repository;

import notesapp.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {

    List<Note> findAll();
    Note getNotesById(String id);
}
