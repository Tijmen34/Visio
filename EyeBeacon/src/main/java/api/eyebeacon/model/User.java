package api.eyebeacon.model;

/**
 *
 * @author Thijs Timmermans <thijs-97@hotmail.com>
 */
public class User {
   
    private String name;
    private String email;
    private String password;
    private String id;
    
    public User(){ }

    public User(String name, String email, String password, String id) {
        
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = id;
    }
    public String getId(){
      return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
