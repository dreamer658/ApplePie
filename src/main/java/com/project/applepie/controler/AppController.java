package com.project.applepie.controler;

import com.project.applepie.dto.Register;
import com.project.applepie.model.Users;
import com.project.applepie.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    @Autowired
    AppService appService;

    @GetMapping("/") //this is the url path to the home page
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/signup") //this is the url path to the home page
    public String signupForm(Model model){
        model.addAttribute("user", new Users());
        return "signup";
    }


}
