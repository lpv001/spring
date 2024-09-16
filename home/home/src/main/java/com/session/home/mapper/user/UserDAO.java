package com.session.home.mapper.user;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.session.home.model.User;

@Repository
public interface UserDAO {
    public User selectUserFirst(Map<String,Object> params);
    public void insertUser(User user);
    // public User findUserByUserId(String userId);
    public User findUserByUsername(String username);
}
