package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_posts")
public class UserPost {

    @Id
    @GeneratedValue()
    @Column(name="id_post")
    private int idPost;

    @Column(name="user_name")
    private String userName;

    @Column(name="date")
    private String date;

    @Column(name="post")
    private String post;

    @ManyToOne
    @JoinColumn(name="id",referencedColumnName="id")
    private UserInfo user;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String string) {
        this.date = string;
    }
    public int getIdPost() {
        return idPost;
    }
    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public UserInfo getId() {
        return user;
    }
    public void setId(UserInfo object) {
        this.user = object;
    }
}