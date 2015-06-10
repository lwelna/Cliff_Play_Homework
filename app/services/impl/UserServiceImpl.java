package services.impl;

import models.UserInfo;
import model.User;

import services.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Date date = new Date();
        newUser.setDateOfCreationOfUser(date);
        em.persist(newUser);
    }

    public boolean checkUsername(String username)
    {
        List<UserInfo> query = em.createQuery("SELECT a FROM UserInfo a WHERE a.user_name = :username", UserInfo.class)
                        .setParameter("username", username)
                        .getResultList();
           if (query.size() == 0) {
               return true;
           }
           return false;
    }
}
