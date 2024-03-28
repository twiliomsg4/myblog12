package com.myblog.myblog12.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @Entity(name = "comments")
    @AllArgsConstructor
    @NoArgsConstructor
    public class Comment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String text;

        private String email;

        @ManyToOne
        @JoinColumn(name = "post_id")
        private Post post;
    }

