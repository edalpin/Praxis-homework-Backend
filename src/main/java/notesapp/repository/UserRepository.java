package notesapp.repository;

import notesapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

    User getUserById(String id);

}
