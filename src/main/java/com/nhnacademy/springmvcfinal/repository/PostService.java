package com.nhnacademy.springmvcfinal.repository;

import com.nhnacademy.springmvcfinal.domain.Post;

import java.util.List;

public interface PostService {
    public void wirtePost(Post post);

    public List<Post> getPostList(String authorId);

    Post getPost(Long postId);

    List<Post> getUnansweredPostList();
}