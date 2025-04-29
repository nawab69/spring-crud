package com.book.book.repository;

import org.springframework.stereotype.Repository;

import com.book.book.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    
}
