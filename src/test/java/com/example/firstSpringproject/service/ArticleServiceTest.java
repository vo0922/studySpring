package com.example.firstSpringproject.service;

import com.example.firstSpringproject.dto.ArticleForm;
import com.example.firstSpringproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 해당 클래스는 스프링부트와 연동되어 테스팅 된다.
class ArticleServiceTest {

    @Autowired ArticleService articleService;

    @Test
    void index() {
        // 예상
        Article a = new Article(1L, "첫번째", "1111");
        Article b = new Article(2L, "두번째", "2222");
        Article c = new Article(3L, "세번째", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제
        List<Article> articles = articleService.index();

        // 비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_success() {
        // 예상
        Long id = 1L;
        Article expected = new Article(id, "첫번째", "1111");

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_fail() {
        // 존재하지 않는 id 입력
        // 예상
        Long id = -1L;
        Article expected = null;

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_success() {
        // 예상
        String title = "네번째";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_fail() {
        // id 값을 넣었을 경우
        // 예상
        Long id = 4L;
        String title = "네번째";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_success_1() {
        // 존재하는 id와 title, content가 있는 dto 입력
        // 예상
        Long id = 2L;
        String title = "두두번째";
        String content = "222222";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_success_2() {
        // 존재하는 id와 title만 있는 dto 입력
        // 예상
        Long id = 2L;
        String title = "두두번째";
        ArticleForm dto = new ArticleForm(id, title, null);
        Article expected = new Article(id, title, "2222");

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_fail() {
        // 존재하지 않는 id의 dto 입력
        // 예상
        Long id = -1L;
        String title = "두두번째";
        String content = "222222";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected, article);
    }


    @Test
    @Transactional
    void delete_sucess() {
        // 예상
        Long id = 3L;
        Article expected = new Article(id, "세번째", "3333");

        // 실제
        Article article = articleService.delete(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void delete_fail() {
        // 존재하지 않는 id입력
        // 예상
        Long id = -1L;
        Article expected = null;

        // 실제
        Article article = articleService.delete(id);

        // 비교
        assertEquals(expected, article);
    }
}