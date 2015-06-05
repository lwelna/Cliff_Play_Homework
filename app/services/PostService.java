package services;

import models.UserPost;

import java.util.List;

public interface PostService {
    void addUserPost(String post, String username);
    List<UserPost> getAllPost();
}
