package com.example.librarydb;

import com.example.librarydb.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void createBook(Book book)throws Exception{
        //logic is written here
        //validation part duplicate part
        if(bookRepository.findById(book.getId()).get() != null){
            throw new Exception("Book is already present");
        }
        bookRepository.save(book);
    }

    public Book getBookById(Integer id)throws Exception{
        Book book = bookRepository.findById(id).get();
        return book;
    }

    public void updateBookPage(UpdateBookPage updateBookPage){
        //we need to convert our object (Entry dto) into Entity object
        int id = updateBookPage.getId();
        Book bookToBeUpdated = bookRepository.findById(id).get();
        bookToBeUpdated.setPage(updateBookPage.getPage());
        bookRepository.save(bookToBeUpdated);
    }

    public List<ResponseObj> getBookNamesAndAuthor(){
        // from the repository class --> what will i get
        List<Book> bookList = bookRepository.findAll();//Select * from book_table
        //convert this Entity into response obj
        List<ResponseObj> ansList = new ArrayList<>();
        for (Book book : bookList){
            ResponseObj obj = new ResponseObj();
            obj.author = book.getAuthor();
            obj.name = book.getName();
            ansList.add(obj);
        }
        return ansList;
    }
}
