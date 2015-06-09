package model;

import play.data.validation.Constraints;
import play.data.validation.Constraints.MaxLength;

public class UserPostInput {

    @Constraints.Required(message="Requires Input To Create Post")
    @MaxLength(value = 255)
    private String postInput;

    public String getPostInput() {
        return postInput;
    }

    public void setPostInput(String input) {
        this.postInput = input;
    }

}
