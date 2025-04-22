package com.nhnacademy.springmvcfinal.controller;

import com.nhnacademy.springmvcfinal.domain.Post;
import com.nhnacademy.springmvcfinal.domain.Role;
import com.nhnacademy.springmvcfinal.domain.User;
import com.nhnacademy.springmvcfinal.repository.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    private final PostService postService;

    public CustomerController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/customer")
    public String customer(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null || user.getRole() != Role.CUSTOMER) {
            return "redirect:/login";
        }

        List<Post> myPost = postService.getPostList(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("posts", myPost);
        return "customerMain";
    }
}
