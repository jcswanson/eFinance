package com.ist412.efinance.service;

import com.ist412.efinance.model.User;
import com.ist412.efinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {

        return this.userRepository.findAll();

    }
}
