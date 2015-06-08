package model;

import play.data.validation.Constraints.Required;

import java.util.Date;

public class UserPost {
    private String user;

    @Required(message="Input Is Required To Make A Post")
    private String post;

    private int id;
    private Date date;
    private int postId;

    public Date getDate() {
        return date;
    }
    public void setDate(Date string) {
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
