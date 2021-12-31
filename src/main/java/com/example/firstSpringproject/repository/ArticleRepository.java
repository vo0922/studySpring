package com.example.firstSpringproject.repository;

import com.example.firstSpringproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
