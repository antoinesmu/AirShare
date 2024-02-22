package junia.airshare.core.entity;


import javax.inject.Inject;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Form extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstname;

    private String lastname;

    private String licence;

    private Date licence_date;

    private String nationality;

    private String comment;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Form() {
    }

    public Form(String firstname, String lastname, String licence, Date licence_date, String nationality, User user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.licence = licence;
        this.licence_date = licence_date;
        this.nationality = nationality;
        this.user = user;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public Date getLicence_date() {
        return licence_date;
    }

    public void setLicence_date(Date licence_date) {
        this.licence_date = licence_date;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}