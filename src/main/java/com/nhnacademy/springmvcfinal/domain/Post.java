package com.nhnacademy.springmvcfinal.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Post {
    // 내 문의 목록: 제목, 분류, 작성일시, 답변여부
    private Long postId;
    private String title;
    private PostCategory category;
    private String content;
    private boolean answered = false;

    // 문의 하기: 문의하기 작성일시, 작성자, 첨부파일
    private LocalDateTime createdAt;
    private String authorId;

    // 담당자가 답변한 정보: 답변자ID, 답변 내용, 답변 작성일시
    private String answerContent;
    private String adminId;
    private LocalDateTime answeredAt;

    public Post(String title, PostCategory category, String content, String authorId) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.authorId = authorId;
        this.createdAt = LocalDateTime.now();
    }
}
