package services.impl;


import models.UserInfo;
import models.UserPost;

import services.PostService;

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
    private EntityManager em;

    @Override
    public void addUserPost(String post, String username) {
        UserPost newPost = new UserPost();
        newPost.setUserName(username);
        newPost.setPost(post);
        List<UserInfo> query = em.createQuery("SELECT a FROM UserInfo a WHERE a.user_name = :username", UserInfo.class)
                        .setParameter("username", username)
                        .getResultList();
        newPost.setId(query.get(0));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        newPost.setDate(dateFormat.format(date));
        em.persist(newPost);
    }

    @Override
    public List<UserPost> getAllPost() {
        return em.createQuery("SELECT a FROM UserPost a", UserPost.class).getResultList();
    }

}
