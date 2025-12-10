package com.maxime.Exo.thymeleaf.controller;

import com.maxime.Exo.thymeleaf.model.Article;
import com.maxime.Exo.thymeleaf.services.ArticleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {

    //@Autowired    equivalent du constructeur
    private ArticleServices articleServices;

    public ArticleController(ArticleServices articleServices){
        this.articleServices = articleServices;
    }


    @GetMapping("/")
    public String getAllArticle (Model model){
        model.addAttribute("models",articleServices.getAllArticle());
        return "index";
    }
    @GetMapping("/{id}")
    public String findArticleById (Model model,@PathVariable Long id){
        model.addAttribute("model",articleServices.findArticleById(id));
        return "detail";
    }
    @GetMapping("/new")
    public String getFormNewArticle(Model model) {
        model.addAttribute("article", new Article());
        return "form";
    }
    @PostMapping("/new")
    public String newArticle (@ModelAttribute Article newArticle,Model model){
        articleServices.createNewArticle(newArticle);
        return "redirect:/";
    }
    @GetMapping("/{id}/modifier")
    public String getFormModifyArticle(@PathVariable Long id,Model model) {
        Article article = articleServices.findArticleById(id);
        if (article != null){
            model.addAttribute("article", article);
            return "form";
        }
        return "redirect:/";
    }

    @PostMapping("/{id}/modifier")
    public String modifierArticle(@PathVariable Long id, @ModelAttribute Article article) {
        article.setId(id);
        articleServices.modifyArticle(article);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteArticle (@PathVariable Long id){
        articleServices.deleteArticle(id);
        return "redirect:/";
    }
    @GetMapping("/author")
    public String findByAutor (String author,Model model){
        System.out.println(author);
        //articleServices.findArticleByAuthor(author);
        return "detail";
    }






















}
