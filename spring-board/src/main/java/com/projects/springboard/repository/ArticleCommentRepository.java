package com.projects.springboard.repository;
import com.projects.springboard.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ArticleCommentRepository extends JpaRepository<ArticleComment,Long>{

}
