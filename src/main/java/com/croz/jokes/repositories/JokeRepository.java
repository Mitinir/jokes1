package com.croz.jokes.repositories;

import com.croz.jokes.entities.Joke;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JokeRepository extends CrudRepository<Joke, Long> {
    List<Joke> findByCategory(long id);
}
