package com.ist412.efinance.service;

import com.ist412.efinance.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);



}
