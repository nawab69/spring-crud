package com.book.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.book.book.model.Book;
import com.book.book.service.BookService;

@Controller
public class BookGraphQLController {
    
    private final BookService bookService;
    
    public BookGraphQLController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @QueryMapping
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }
    
    @QueryMapping
    public Book bookById(@Argument String id) {
        Long bookId = Long.parseLong(id);
        return bookService.getBookById(bookId).orElse(null);
    }
    
    @MutationMapping
    public Book createBook(@Argument String title, @Argument String author, @Argument String isbn) {
        Book book = new Book(title, author, isbn);
        return bookService.saveBook(book);
    }
    
    @MutationMapping
    public Book updateBook(@Argument String id, @Argument String title, @Argument String author, @Argument String isbn) {
        Long bookId = Long.parseLong(id);
        Optional<Book> existingBook = bookService.getBookById(bookId);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            
            if (title != null) {
                book.setTitle(title);
            }
            
            if (author != null) {
                book.setAuthor(author);
            }
            
            if (isbn != null) {
                book.setIsbn(isbn);
            }
            
            return bookService.saveBook(book);
        }
        return null;
    }
    
    @MutationMapping
    public boolean deleteBook(@Argument String id) {
        Long bookId = Long.parseLong(id);
        Optional<Book> book = bookService.getBookById(bookId);
        if (book.isPresent()) {
            bookService.deleteBook(bookId);
            return true;
        }
        return false;
    }
}
