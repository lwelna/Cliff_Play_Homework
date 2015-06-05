package model;

import play.data.validation.Constraints;

public class UserPostInput {

    @Constraints.Required(message="Requires Input To Create Post")
    private String inputField;

    public String getInput() {
        return inputField;
    }

    public void setInput(String input) {
        this.inputField = input;
    }

}
