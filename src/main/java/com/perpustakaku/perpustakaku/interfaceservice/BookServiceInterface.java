/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpustakaku.perpustakaku.interfaceservice;

import com.perpustakaku.perpustakaku.entities.Book;

/**
 *
 * @author RAR
 */
public interface BookServiceInterface {
    Iterable<Book> getAll();
}
