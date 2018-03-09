package notesapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "User")
public class User{

    @Id
    private String id;
    private String username;
    private String password;
    private List<Note> notes;

    public User() {
    }

    public User( String username, String password) {
        this.username = username;
        this.password = password;
        this.notes=null;
    }



    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public void setUsername(String name){
        this.username=name;
    }
    public String getUsername(){
        return this.username;
    }




}
