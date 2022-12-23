package com.projects.springboard.service;

import com.projects.springboard.domain.Article;
import com.projects.springboard.dto.ArticleDto;
import com.projects.springboard.domain.type.SearchType;
import com.projects.springboard.dto.ArticleUpdateDto;
import com.projects.springboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("business logic - article")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {
    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

    @DisplayName("Return Articles When Searching Articles")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticles(){
        //G
        //W
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword");
        //title, content, ID, nickname, hashtag for parameters
        //T
        assertThat(articles).isNotNull();
    }


    @DisplayName("Moving to other Article Pages")
    @Test
    void givenId_whenSearchingArticle_thenReturnsArticle(){
        //G
        //W
        // When
        ArticleDto articles = sut.searchArticle(1L);

        // Then
        assertThat(articles).isNotNull();
    }

    @DisplayName("Generate Article")
    @Test
    void givenArticleInfo_whenSavingArticle_thenGeneratesArticle(){

        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "ystc", "title", "content", "#java"));

        // Then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("Modify Article")
    @Test
    void givenArticleInfo_whenModifyingArticle_thenUpdatesArticle(){

        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.updateArticle(1L, ArticleUpdateDto.of("title", "content", "#java"));

        // Then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("Delete Article")
    @Test
    void givenArticleIe_whenDeletingArticle_thenDeletesArticle(){

        willDoNothing().given(articleRepository).delete(any(Article.class));

        // When
        sut.deleteArticle(1L);

        // Then
        then(articleRepository).should().delete(any(Article.class));
    }
}