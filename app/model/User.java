package model;

import play.data.validation.Constraints;
import play.data.validation.Constraints.Required;

import java.util.Date;

public class User {
    @play.data.validation.Constraints.Required(message="Username")
    private String user;
    private int id;
    private String date;
    @Constraints.Required(message="First Name")
    private String firstName;
    @play.data.validation.Constraints.Required
    private String lastName;


    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String string) {
        this.date = string;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
