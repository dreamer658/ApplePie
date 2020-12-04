package com.project.applepie.controler;

import com.project.applepie.model.Book;
import com.project.applepie.repository.UserRepository;
import com.project.applepie.model.Users;
import com.project.applepie.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


public class AppController {

    @Autowired
    AppService appService;

    @Autowired
    private UserRepository repo;


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


/*
    @GetMapping("/book")
    public List<Book> findAllBooks(){
        return appService.getBooks();
    }
    @GetMapping("/book/{id}")
    public Book findBookById(@PathVariable int id){
        return appService.getBookbyId(id);
    }
    @GetMapping("/book/{name}")
    public Book findBookByName(@PathVariable String name){
        return appService.getBookbyName(name);
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
        return appService.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        return appService.deleteBook(id);
    }

 */
}
