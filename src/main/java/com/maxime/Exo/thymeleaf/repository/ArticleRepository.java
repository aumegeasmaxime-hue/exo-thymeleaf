package com.maxime.Exo.thymeleaf.repository;

import com.maxime.Exo.thymeleaf.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findbyauthor(String author);
}
