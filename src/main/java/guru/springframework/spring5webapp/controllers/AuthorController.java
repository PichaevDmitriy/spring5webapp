package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.services.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getBooks(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }
}
