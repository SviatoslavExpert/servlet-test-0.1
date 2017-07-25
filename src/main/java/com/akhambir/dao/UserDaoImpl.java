package com.akhambir.dao;

import com.akhambir.model.User;

import java.util.HashSet;

import java.util.Set;

public class UserDaoImpl implements UserDao {

    private static final Set<User> userList = new HashSet<>();

    static {
        userList.add(new User("Vova", "123123"));
        userList.add(new User("Vova2", "123123"));
        userList.add(new User("Anton", "123123"));
    }

    @Override
    public User getUser(User user) {
        if (userList.contains(user)) {
            return user;
        } else {
            return null;
        }
    }
}
