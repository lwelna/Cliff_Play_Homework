package services.impl;

import model.User;

import services.UserService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.ehcache.hibernate.*;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transaction;

import models.UserDb;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @PersistenceContext
    EntityManager em;

    @Override
    public boolean checkUser(String username) {
       @SuppressWarnings("unchecked")
    List<UserDb> query = em.createQuery("SELECT a FROM UserDb a WHERE a.user_name = :username").setParameter("username", username).getResultList();
       System.out.println((query.get(0)).getId());
       if(query.size() >= 1)
       {
//           System.out.println(query.get(0).getUserName());
//
//           System.out.println("Exists");
           return true;
       }
       return false;
    }

    @Override
    public  void addUser(User user) {
        UserDb newUser = new UserDb();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setUserName(user.getUser());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        newUser.setDate(dateFormat.format(date));
        em.persist(newUser);
//        org.hibernate.Transaction trns = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            trns = session.beginTransaction();
//            User user = (User) session.load(User.class, new Integer(userid));
//            session.delete(user);
//            session.getTransaction().commit();
//        } catch (RuntimeException e) {
//            if (trns != null) {
//                trns.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.flush();
//            session.close();
//        }

    }

}
