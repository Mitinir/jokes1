package com.croz.jokes.controllers;


import com.croz.jokes.entities.Category;
import com.croz.jokes.entities.Joke;
import com.croz.jokes.model.JokeForm;
import com.croz.jokes.repositories.CategoryRepository;
import com.croz.jokes.repositories.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller

public class JokeController {

    @Autowired

    private JokeRepository jokeRespository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value="/add", method = RequestMethod.POST)
    String addJoke(Model model, @ModelAttribute("edited_joke") JokeForm joke) {
        Optional<Category> cat = categoryRepository.findById(joke.getCategory());
        System.out.println(joke);

        if (joke.getContent().length() < 5) {
            model.addAttribute("error", "Joke is too short!");
            return "/bad_joke";
        } else if (cat.isEmpty()) {
            model.addAttribute("error", "Category has not been set!");
            return "/bad_joke";
        } else {
            Joke c = new Joke();
            c.setCategory(cat.get());
            c.setContent(joke.getContent());
            jokeRespository.save(c);

            return "redirect:/";
        }
    }

    @RequestMapping(value = "")
    public String index(Model model) {
        Iterable<Category> list = categoryRepository.findAll();

        model.addAttribute("edited_joke", new JokeForm());
        model.addAttribute("categories", list);

        return "index";
    }

    @RequestMapping(value = "/list")
    public String list(Model model) {
        Iterable<Joke> jokes = jokeRespository.findAll();

        model.addAttribute("joke_list", jokes);

        return "list";
    }
}
