package com.maxime.Exo.thymeleaf.controller;

import com.maxime.Exo.thymeleaf.model.Article;
import com.maxime.Exo.thymeleaf.services.ArticleServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ArticleController {
    private ArticleServices articleServices;


    @GetMapping("/")
    public String getAllArticle (Model model){
        model.addAttribute("models",articleServices.getAllArticle());
        return "index";
    }
    @GetMapping("/{id}")
    public String findArticleById (Model model,@PathVariable Long id){
        model.addAttribute("models",articleServices.findArticleById(id));
        return "detail";
    }























}
