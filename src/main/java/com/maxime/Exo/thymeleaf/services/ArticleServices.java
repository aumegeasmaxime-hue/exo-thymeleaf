package com.maxime.Exo.thymeleaf.services;

import com.maxime.Exo.thymeleaf.model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServices {

    public List<Article> getListArticle(){
        List<Article> listArticle = new ArrayList<>();
        listArticle.add(new Article(1L,"allo win", "Mirette","SuperTomate"));
        listArticle.add(new Article(2L,"ici trouille", "Latrine","SuperBanane"));
        listArticle.add(new Article(3L,"la bonne chaussure", "Berte","avoir de grand pied"));
        listArticle.add(new Article(4L,"azerty", "Clavier","AZERTY"));
        return listArticle;
    }
}
