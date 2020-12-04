package com.project.applepie.controler;

import com.project.applepie.model.Book;
import com.project.applepie.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/") //this is the url path to the home page
    public String homePage(Model model){
        List<Book> listBooks = bookService.getBooks();
        model.addAttribute("listBooks", bookService.getBooks());
        return "index";
    }

    @RequestMapping("/addBook")
    public String goToAddBook(Model model){
        Book onebook = new Book();
        model.addAttribute("onebook",onebook);
        return "crudaddBook";

    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("onebook") Book onebook){
        bookService.addBook(onebook);
        return "redirect:/";

    }

    @PostMapping("/book")
    public Book addBooks(@RequestBody Book book){
        return bookService.addBook(book);
    }



    @RequestMapping("/edit/{id}")
    public String goToEditBook(Model model, @PathVariable int id){
        Book onebook = bookService.getBookById(id);
        model.addAttribute("onebook", onebook);
        return "editBook";

    }


    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        //call delete Book from the service
        bookService.deleteBook(id);
        return "redirect:/";

    }



}
