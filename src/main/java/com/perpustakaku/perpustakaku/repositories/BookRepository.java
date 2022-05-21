/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpustakaku.perpustakaku.repositories;

import com.perpustakaku.perpustakaku.entities.Book;
import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RAR
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    @Query(value = "SELECT * FROM `book`", nativeQuery = true)
    public Iterable<Book> tampilaktif();
}
