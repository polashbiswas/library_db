package com.example.librarydb;


import com.example.librarydb.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add_book")
    public void addBook(@RequestBody() Book book)  {
        //in the controller layer we are handling this with try catch
        try {
            bookService.createBook(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/get_book")
    public Book getBook(@RequestParam("id") Integer id){
        try {
            Book book = bookService.getBookById(id);
            return book;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @PutMapping("/update_page")
    public void updatePage(@RequestBody() UpdateBookPage updateBookPage){
        bookService.updateBookPage(updateBookPage);
    }

    @GetMapping("/get_book_names_and_authors")
    public List<ResponseObj> getBookNamesAndAuthor(){
        List<ResponseObj> responseObjs = bookService.getBookNamesAndAuthor();
        return responseObjs;
    }

}
