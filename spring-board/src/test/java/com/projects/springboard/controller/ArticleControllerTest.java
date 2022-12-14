package com.projects.springboard.controller;

import com.projects.springboard.config.SecurityConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View Controller - Articles")
@Import(SecurityConfig.class)

@WebMvcTest(ArticleController.class)
class ArticleControllerTest {
        private MockMvc mvc;

        public ArticleControllerTest(@Autowired MockMvc mvc){
                this.mvc = mvc;
        }

        @Test
        @DisplayName("[view][GET] Article List - 정상 호출")
        public void givenNothing_whenRequestingArticlesView_thenReturnsArticlesView() throws Exception {
                mvc.perform(get("/articles"))
                        .andExpect(status().isOk())
                        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                        .andExpect(view().name("articles/index"))
                        .andExpect(model().attributeExists("articles"));

        }

        @DisplayName("[view][GET] 게시글 상세 페이지 - 정상 호출")
        @Test
        public void givenNothing_whenRequestingArticleView_thenReturnsArticleView() throws Exception {
                // Given

                // When & Then
                mvc.perform(get("/articles/1"))
                        .andExpect(status().isOk())
                        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                        .andExpect(view().name("articles/detail"))
                        .andExpect(model().attributeExists("article"))
                        .andExpect(model().attributeExists("articleComments"));
        }

        @Disabled("implementing")
        @Test
        @DisplayName("[view][GET] Article Looking up Page - 정상 호출")
        public void givenNothing_whenRequestingArticlesSearchView_thenReturnsArticlesSearchView() throws Exception {
                mvc.perform(get("/articles/search"))
                        .andExpect(status().isOk())
                        .andExpect(view().name("articles/search"))
                        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
        }

        @Disabled("implementing")
        @Test
        @DisplayName("[view][GET] Article Hashtag Search - 정상 호출")
        public void givenNothing_whenRequestingHashtagSearchView_thenReturnsHashtagSearchView() throws Exception {
                mvc.perform(get("/articles/search-hashtag"))
                        .andExpect(status().isOk())
                        .andExpect(view().name("articles/hashtag"))
                        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
        }

}