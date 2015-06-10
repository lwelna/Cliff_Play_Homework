package model;

import play.data.validation.Constraints;
import play.data.validation.Constraints.MaxLength;

public class User {

    @play.data.validation.Constraints.Required(message="Username is need to create a new account")
    @MaxLength(value = 255)
    private String user;

    @Constraints.Required(message="First Name Is Required")
    @MaxLength(value = 255)
    private String firstName;

    @Constraints.Required(message="Last Name Is RequiredØØ")
    @MaxLength(value = 255)
    private String lastName;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
