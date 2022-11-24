package com.projects.springboard;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.projects.springboard.domain.Article} entity
 */
@Data
public class ArticleDto implements Serializable {
    private final String title;
    private final String content;
    private final String hashtag;
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;
}