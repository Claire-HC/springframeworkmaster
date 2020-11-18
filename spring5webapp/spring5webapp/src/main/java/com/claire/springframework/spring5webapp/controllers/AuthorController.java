package com.claire.springframework.spring5webapp.controllers;

import com.claire.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by claire on 18/11/20
 */

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthor(Model model) {
        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}
