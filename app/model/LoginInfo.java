package model;

import play.data.validation.Constraints;

public class LoginInfo {
    @Constraints.Required(message="Requires Input To Login. Try Again.")
    private String inputField;

    public String getInput() {
        return inputField;
    }

    public void setInput(String input) {
        this.inputField = input;
    }
}
