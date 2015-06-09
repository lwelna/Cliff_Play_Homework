package services;

import model.User;

public interface UserService {

    void addUser(User task);
    boolean checkUser(String username);
    boolean checkUsername(String username);

}
