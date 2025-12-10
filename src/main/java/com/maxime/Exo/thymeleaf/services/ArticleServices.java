package com.maxime.Exo.thymeleaf.services;

import com.maxime.Exo.thymeleaf.model.Article;
import com.maxime.Exo.thymeleaf.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServices {
    @Autowired
    private ArticleRepository repository;
    public List<Article> getListArticle(){
        List<Article> listArticle = new ArrayList<>();
        listArticle.add(new Article("allo win", "Mirette","SuperTomate"));
        listArticle.add(new Article("ici trouille", "Latrine","SuperBanane"));
        listArticle.add(new Article("la bonne chaussure", "Berte","avoir de grand pied"));
        listArticle.add(new Article("azerty", "Clavier","AZERTY"));
        return listArticle;
    }
    public List<Article> getAllArticle() {
        return repository.findAll();
    }
    public Article findArticleById (Long id){
        return repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("article with id " + id + " not found"));
    }
    public void createNewArticle(Article article) {
        repository.save(article);
    }
    public Article modifyArticle(Article article) {
        return repository.save(article);
    }
    public void deleteArticle(Long id){
        Article deleteArticle = findArticleById(id);
        repository.delete(deleteArticle);
    }
    public void findArticleByAuthor(String author){
        repository.findByAuthor(author);
    }



}
