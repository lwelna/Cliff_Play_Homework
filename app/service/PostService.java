package service;

import models.Post;

import java.util.List;

public interface PostService {
    public void addPost(Post post);
    public List<Post> getAllPost();
}
