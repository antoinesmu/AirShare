package junia.airshare.web.dto;

import java.util.Date;

public class UserDTO {

    private long id;
    private String login;

    private String email;

    private int status;

    private Date creation_date;

    public UserDTO(long id, String login, String email, int status, Date creation_date) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.status = status;
        this.creation_date = creation_date;
    }

    public UserDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
