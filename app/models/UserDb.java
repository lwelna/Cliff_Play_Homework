package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDb {
    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @GeneratedValue()
    @Column(name="date")
    private String date;

    @Id
    @GeneratedValue()
    @Column(name="id")
    private int id;

    @Column(name="user_name")
    private String user_name;

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String string) {
        this.date = string;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}