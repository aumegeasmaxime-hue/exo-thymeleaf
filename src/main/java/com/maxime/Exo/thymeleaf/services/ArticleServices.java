package com.maxime.Exo.thymeleaf.services;

import com.maxime.Exo.thymeleaf.model.Article;
import com.maxime.Exo.thymeleaf.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServices {
    private ArticleRepository repository;
    public List<Article> getListArticle(){
        List<Article> listArticle = new ArrayList<>();
        listArticle.add(new Article(1L,"allo win", "Mirette","SuperTomate"));
        listArticle.add(new Article(2L,"ici trouille", "Latrine","SuperBanane"));
        listArticle.add(new Article(3L,"la bonne chaussure", "Berte","avoir de grand pied"));
        listArticle.add(new Article(4L,"azerty", "Clavier","AZERTY"));
        return listArticle;
    }
    public List<Article> getAllArticle() {
        return repository.findAll();
    }
    public Article findArticleById (Long id){
        return repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Software Engineerwith id " + id + " not found"));
    }
    public void createNewArticle(Article article) {
        repository.save(article);
    }
    public void modifyArticle(Long id, Map<String, Object> update) {
        Article articleUpdate = findArticleById(id);
        update.forEach((key , value)->{
            Field filed = ReflectionUtils.findField(Article.class , key);
            if (filed != null){
                filed.setAccessible(true);
                ReflectionUtils.setField(filed,articleUpdate,value);
            }
        });
        repository.save(articleUpdate);
    }
    public void deleteArticle(Long id){
        Article deleteArticle = findArticleById(id);
        repository.delete(deleteArticle);
    }
    public void findArticleByAuthor(String author){
        repository.findbyauthor(author);
    }



}
