package services;

import model.Post;

import java.util.List;

public interface PostService {
    void addPost(String post, String id);
    List<Post> getAllPost();
}
