package com.example.bykov;

import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Integer> { }