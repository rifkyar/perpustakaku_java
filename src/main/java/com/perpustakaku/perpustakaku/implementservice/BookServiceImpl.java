/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpustakaku.perpustakaku.implementservice;

import com.perpustakaku.perpustakaku.entities.Book;
import com.perpustakaku.perpustakaku.interfaceservice.BookServiceInterface;
import com.perpustakaku.perpustakaku.repositories.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RAR
 */
@Service
public class BookServiceImpl implements BookServiceInterface {
    @Autowired
    private BookRepository bookRepo;
    
    @Override
    public Iterable<Book> getAll() {
        return bookRepo.findAll();
    }
    public Book save(Book book) {
        return bookRepo.save(book);
    }
    @Override
    public List<Book> findById(int id) {
        return bookRepo.findBookById(id);
    }
}
