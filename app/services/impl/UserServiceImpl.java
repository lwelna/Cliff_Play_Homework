package services.impl;

import models.UserInfo;

import services.UserService;

import model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean checkUser(String username) {
    List<UserInfo> query = em.createQuery("SELECT a FROM UserInfo a WHERE a.user_name = :username", UserInfo.class)
                    .setParameter("username", username)
                    .getResultList();
       if (query.size() >= 1) {
           return true;
       }
       return false;
    }

    @Override
    public  void addUser(User user) {
        UserInfo newUser = new UserInfo();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setUserName(user.getUser());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(date);
        newUser.setDate(date);
        em.persist(newUser);
    }
}
