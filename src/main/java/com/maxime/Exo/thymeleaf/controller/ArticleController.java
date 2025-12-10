package com.maxime.Exo.thymeleaf.controller;

import com.maxime.Exo.thymeleaf.model.Article;
import com.maxime.Exo.thymeleaf.services.ArticleServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public String getFormModifyArticle(Model model) {
        model.addAttribute("article", new Article());
        return "form";
    }

    @PatchMapping("/{id}/modifier")
    public String modifyArticle (@PathVariable Long id, @ModelAttribute Map<String,Object> modifyArticle){
        articleServices.modifyArticle(id,modifyArticle);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteArticle (@PathVariable Long id){
        articleServices.deleteArticle(id);
        return "redirect:/";
    }






















}
