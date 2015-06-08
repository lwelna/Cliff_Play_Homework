package services;

import java.util.List;

public interface PostService {
    void addUserPost(String post, String username);
    List<model.UserPost> getAllPost();
}
