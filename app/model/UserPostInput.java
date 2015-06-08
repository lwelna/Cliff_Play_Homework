package model;

import play.data.validation.Constraints;

public class UserPostInput {

    @Constraints.Required(message="Requires Input To Create Post")
    private String postInput;

    public String getPostInput() {
        return postInput;
    }

    public void setPostInput(String input) {
        this.postInput = input;
    }

}
