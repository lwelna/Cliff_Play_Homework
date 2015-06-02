package service;

import models.User;

import java.util.List;
public interface UserService {
    public void addUser(User user);
    public boolean checkUser(String username);

}