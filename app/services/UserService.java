package services;

import model.User;

public interface UserService {
    public void addUser(User task);
    public boolean checkUser(String username);
}
