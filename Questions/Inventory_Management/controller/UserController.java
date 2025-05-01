package controller;

import java.util.List;

import models.User;

public class UserController {

    List<User> userList;

    public UserController(List<User> userList){
        this.userList = userList;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void removeUser(User user){
        userList.remove(user);
    }

    public User getUser(int userId){
        
        for(User user : userList){
            if(user.userId == userId){
                return user;
            }
        }
        return null;
    }

}
