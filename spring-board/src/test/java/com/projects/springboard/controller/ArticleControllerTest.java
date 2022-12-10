package com.projects.springboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View Controller - Articles")
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
                    .andExpect(content().contentType(MediaType.TEXT_HTML))
                    .andExpect(model().attributeExists("articles"));
        }

    @Test
    @DisplayName("[view][GET] Article Specific List - 정상 호출")
    public void givenNothing_whenRequestingArticlesSpecificView_thenReturnsArticlesSpecificView() throws Exception {
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));
    }
    @Test
    @DisplayName("[view][GET] Article Looking up Page - 정상 호출")
    public void givenNothing_whenRequestingArticlesSearchView_thenReturnsArticlesSearchView() throws Exception {
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }
    @Test
    @DisplayName("[view][GET] Article Hashtag Search - 정상 호출")
    public void givenNothing_whenRequestingHashtagSearchView_thenReturnsHashtagSearchView() throws Exception {
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }
}