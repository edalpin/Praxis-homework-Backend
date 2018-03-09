package notesapp.service;

import notesapp.model.User;
import notesapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAllUsers();

    User getUserById(String id);

    User saveUser(User user);

    void deleteUser(User user);


}
