package services;

import model.Post;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostService {
    public void addPost(String post, String id);
    public List<Post> getAllPost();
}
