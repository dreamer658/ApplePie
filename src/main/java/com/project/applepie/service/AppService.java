package com.project.applepie.service;

import com.project.applepie.dto.Register;
import com.project.applepie.model.Book;
import com.project.applepie.model.BookRepository;
import com.project.applepie.model.Users;
import com.project.applepie.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookrepo;

    public void signup(Register register) {
        Users user = new Users();
        user.setFirstname(register.getFirstname());
        user.setFirstname(register.getLastname());
        user.setPassword(register.getPassword());
        user.setEmail(register.getEmail());
        userRepository.save(user); // we would like to save the User object in the the database

    }

    // Post method
    public Book saveBook(Book book){
        return bookrepo.save(book);
    }
    // Post method
    public List<Book> saveBooks( List<Book> books){
        return bookrepo.saveAll(books);
    }

    //get method

    public List<Book> getBooks(){
        return bookrepo.findAll();
    }

    public Book getBookbyId(int id){
        return bookrepo.findById(id).orElse(null);
    }

    public Book getBookbyName(String name){
        return bookrepo.findByName(name);
    }

    public String deleteBook(int id){
        bookrepo.deleteById(id);
        return ("Book"+ id+ "removed.");
    }

    public Book updateBook(Book book){
        Book oneBook=bookrepo.findById(book.getId()).orElse(null);
        oneBook.setName(book.getName());
        oneBook.setQuantity(book.getQuantity());
        oneBook.setPrice(book.getPrice());
        oneBook.setAuthor(book.getAuthor());
        oneBook.setEditor(book.getEditor());
        return bookrepo.save(oneBook);
    }




}