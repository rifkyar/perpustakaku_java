/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpustakaku.perpustakaku.controllers;

import com.perpustakaku.perpustakaku.entities.Book;
import com.perpustakaku.perpustakaku.implementservice.BookServiceImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
     @RequestMapping(value = "/getBook/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody String getBookById(@PathVariable(value = "id") int id){
//       System.out.println("ID = " + id);
        List<Book> buku = book.findById(id);
        JSONArray ja = new JSONArray();
        JSONObject jo = new JSONObject();
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        for (Book buk : buku) {
            JSONObject job = new JSONObject();
            job.put("id", buk.getId());
            job.put("nama", buk.getNama());
            job.put("jenis", buk.getJenis());
            ja.put(job);
        }
        jo.put("data", ja);
        return jo.toString();
    }
}
