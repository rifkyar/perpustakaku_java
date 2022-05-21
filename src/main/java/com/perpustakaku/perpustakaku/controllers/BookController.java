/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpustakaku.perpustakaku.controllers;

import com.perpustakaku.perpustakaku.entities.Book;
import com.perpustakaku.perpustakaku.implementservice.BookServiceImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author RAR
 */
@Controller
public class BookController {
    @Autowired
    private BookServiceImpl book;
    
   @GetMapping("/book")
   public String questionList(Model model){
        System.out.println("tes");
       
        model.addAttribute("book", book.getAll());
        return "Book";

    }
   @PostMapping("/add")
    public String addAnswer(Book booki){
        book.save(booki);
        return "redirect:/book";
    }
}
