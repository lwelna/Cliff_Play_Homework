package model;

import play.data.validation.Constraints;

public class LoginInfo {
    @Constraints.Required(message="Requires Input To Login. Try Again.")
    private String inputField;

    public String getInputField() {
        return inputField;
    }

    public void setInputField(String input) {
        this.inputField = input;
    }
}
