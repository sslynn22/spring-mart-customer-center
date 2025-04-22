package com.nhnacademy.springmvcfinal.repository;

import com.nhnacademy.springmvcfinal.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private final Map<Long, Post> postMap = new LinkedHashMap<>();
    private final AtomicLong postIdGenerator = new AtomicLong(0);

    @Override
    public void save(Post post) {
        if (post.getPostId() == null) {
            post.setPostId(postIdGenerator.incrementAndGet());
        }
        postMap.put(post.getPostId(), post);
    }

    @Override
    public List<Post> findByAuthorId(String authorId) {
        return postMap.values().stream()
                .filter(post -> post.getAuthorId().equals(authorId))
                .sorted(Comparator.comparing(Post::getCreatedAt).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Post findByPostId(Long postId) {
        return postMap.get(postId);
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(postMap.values());
    }
}
