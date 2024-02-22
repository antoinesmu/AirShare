package junia.airshare.core.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;


@Entity
public class User extends GenericEntity{

    private String login;

    private String email;

    //0 -> admin ; 1 -> user ; 2 -> pilot ; 10 -> upgrade request
    private int status;

    @Column(length = 65535, columnDefinition = "text")
    private String password;

    @OneToMany(mappedBy = "userSubmitting")
    private List<Flight> flights;

    public User(String login, String email, String password, int status) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public User() {
    }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public int getStatus() { return status; }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() { return creationDate; }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", password='" + password + '\'' +
                '}';
    }
}