package com.myblog.myblog12.payload;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;

    private String text;

    private String email;
}
