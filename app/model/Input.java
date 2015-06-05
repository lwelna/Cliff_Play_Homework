package model;

import play.data.validation.Constraints;

public class Input {
    
    @Constraints.Required(message="First Name")
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

}
