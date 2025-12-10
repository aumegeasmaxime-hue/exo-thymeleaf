package com.maxime.Exo.thymeleaf.repository;

import com.maxime.Exo.thymeleaf.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findByAuthor(String author);
}
