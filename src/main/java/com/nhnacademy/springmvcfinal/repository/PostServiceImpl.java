package com.nhnacademy.springmvcfinal.repository;

import com.nhnacademy.springmvcfinal.domain.Post;
import com.nhnacademy.springmvcfinal.domain.PostCategory;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
        Post post = new Post("배송이 안 와요", PostCategory.COMPLAINT, "주문한 상품이 아직 도착하지 않았습니다.", "joo");
        wirtePost(post);
    }

    @Override
    public void wirtePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> getPostList(String authorId) {
        return postRepository.findByAuthorId(authorId);
    }

    @Override
    public Post getPost(Long postId) {
        return postRepository.findByPostId(postId);
    }

    @Override
    public List<Post> getUnansweredPostList() {
        return postRepository.findAll().stream()
                .filter(post -> !post.isAnswered())
                .sorted(Comparator.comparing(Post::getCreatedAt).reversed())
                .collect(Collectors.toList());
    }
}
