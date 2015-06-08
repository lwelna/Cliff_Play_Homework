package services.impl;


import models.UserInfo;
import models.UserPostTable;

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
        UserPostTable newPost = new UserPostTable();
        newPost.setUserName(username);
        newPost.setPost(post);
        List<UserInfo> query = em.createQuery("SELECT a FROM UserInfo a WHERE a.user_name = :username", UserInfo.class)
                        .setParameter("username", username)
                        .getResultList();
        newPost.setId(query.get(0));
        Date date = new Date();
        newPost.setDate(date);
        em.persist(newPost);
    }

    @Override
    public List<model.UserPost> getAllPost() {
        List<UserPostTable> userPostDb = em.createQuery("SELECT a FROM UserPostTable a", UserPostTable.class).getResultList();
        List<model.UserPost> tempUserPost = new ArrayList<model.UserPost>();
        for(int i = 0; i < userPostDb.size(); i++)
        {
            model.UserPost tempPost = new model.UserPost();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            tempPost.setDate(dateFormat.format(userPostDb.get(i).getDate()));
            tempPost.setId(userPostDb.get(i).getIdPost());
            tempPost.setPost(userPostDb.get(i).getPost());
            tempPost.setUser(userPostDb.get(i).getUserName());
            tempUserPost.add(tempPost);
        }
        return tempUserPost;
    }

}
