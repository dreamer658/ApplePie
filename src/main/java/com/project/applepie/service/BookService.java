package com.project.applepie.service;

import com.project.applepie.model.Book;
import com.project.applepie.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    public Book addBook(Book book){
        return bookRepo.save(book);
    }
    // Post method


    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public Book getBookById(int id){
        return bookRepo.findById(id).orElse(null);
    }


    public Book updateBook(Book book){
        Book oneBook=bookRepo.findById(book.getId()).orElse(null);
        oneBook.setName(book.getName());
        oneBook.setQuantity(book.getQuantity());
        oneBook.setPrice(book.getPrice());
        oneBook.setAuthor(book.getAuthor());
        oneBook.setEditor(book.getEditor());
        return bookRepo.save(oneBook);
    }

    public String deleteBook(int id){
        bookRepo.deleteById(id);
        return ("Book"+ id+ "removed.");
    }



}
