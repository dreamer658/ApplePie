package com.project.applepie.controler;

import com.project.applepie.dto.Register;
import com.project.applepie.model.UserRepository;
import com.project.applepie.model.Users;
import com.project.applepie.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    AppService appService;

    @Autowired
    private UserRepository repo;

    @GetMapping("/") //this is the url path to the home page
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/signup") //this is the url path to the home page
    public String signupForm(Model model){
        model.addAttribute("user", new Users());
        return "signup";
    }

    @PostMapping("/process_signup")
    public String signupProcess(Users user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repo.save(user);

        return "signup_success";
    }

    @GetMapping("/list_users")
    public String viewUsersList(Model model){
        List<Users> listUsers = repo.findAll();
        model.addAttribute("listUsers", listUsers);
        System.out.println("HAHAHA USERS: "+ listUsers.get(0).getEmail());
        return "usersList";
    }


}
