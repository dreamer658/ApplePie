package com.project.applepie.service;

import com.project.applepie.dto.Register;
import com.project.applepie.model.Users;
import com.project.applepie.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private UserRepository userRepository;

    public void signup(Register register) {
        Users user = new Users();
        user.setFirstname(register.getFirstname());
        user.setFirstname(register.getLastname());
        user.setPassword(register.getPassword());
        user.setEmail(register.getEmail());
        userRepository.save(user); // we would like to save the User object in the the database

    }
}