package model;

import play.data.validation.Constraints;

public class UserPostInput {

    @Constraints.Required(message="Requires Input To Create Post")
    private String inputField;

    public String getInputField() {
        return inputField;
    }

    public void setInputField(String input) {
        this.inputField = input;
    }

}
