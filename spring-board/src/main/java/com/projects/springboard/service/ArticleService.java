package com.projects.springboard.service;

import com.projects.springboard.domain.type.SearchType;
import com.projects.springboard.dto.ArticleDto;
import com.projects.springboard.dto.ArticleUpdateDto;
import com.projects.springboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType title, String search_keyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {
    }

    public void deleteArticle(long articleId) {
    }

    public void updateArticle(long articleId, ArticleUpdateDto Article) {
    }
}
