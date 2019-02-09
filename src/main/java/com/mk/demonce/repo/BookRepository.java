package com.mk.demonce.repo;

import com.mk.demonce.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
