package com.croz.jokes.repositories;

import com.croz.jokes.entities.Category;
import com.croz.jokes.entities.Joke;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Joke> findById(int id);

    List<Joke> findByName(Category c);
}
