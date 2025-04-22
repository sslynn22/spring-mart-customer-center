package com.nhnacademy.springmvcfinal.repository;

import com.nhnacademy.springmvcfinal.domain.Post;

import java.util.List;

public interface PostRepository {
    void save(Post post);
    List<Post> findByAuthorId(String authorId);
    Post findByPostId(Long postId);
    List<Post> findAll();
}
