package model;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;

public class UserPost {

    @Required(message="Input Is Required To Make A Post")
    @MaxLength(value = 255)
    private String post;

    private String user;
    private int id;
    private String date;
    private int postId;

    public String getDate() {
        return date;
    }
    public void setDate(String string) {
        this.date = string;
    }
    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public int getId() {
        return id;
    }
    public void setId(int user2) {
        this.id = user2;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
}
