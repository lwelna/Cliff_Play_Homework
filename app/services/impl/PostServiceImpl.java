package services.impl;

import models.PostDb;
import models.UserDb;

import model.Post;

import services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import model.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @PersistenceContext
    EntityManager em;



    @Override
    public void addPost(String post, String id) {
        PostDb newPost = new PostDb();

        newPost.setUserName(id);
        newPost.setPost(post);
        List<UserDb> query = em.createQuery("SELECT a FROM UserDb a WHERE a.user_name = :username").setParameter("username", id).getResultList();
        newPost.setId(query.get(0));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        newPost.setDate(dateFormat.format(date));
        em.persist(newPost);
    }
    @Override
    public List<Post> getAllPost() {
        List<PostDb> post = em.createQuery("SELECT a FROM PostDb a ").getResultList();
        List<Post> newPost = new ArrayList<Post>();
        for(int i = 0; i < post.size(); i++){
            Post temp = new Post();
            temp.setDate(post.get(i).getDate());
            temp.setPostId(post.get(i).getIdPost());
            temp.setPost(post.get(i).getPost());
            temp.setUser(post.get(i).getUserName());
            System.out.println(temp.getPost());
        }
        return newPost;
    }

}
