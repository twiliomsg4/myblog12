package com.myblog.myblog12.repository;

import com.myblog.myblog12.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
