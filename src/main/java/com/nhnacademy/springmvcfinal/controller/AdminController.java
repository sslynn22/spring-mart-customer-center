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
public class AdminController {
    private final PostService postService;

    public AdminController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/admin/inquiries")
    public String unansweredInquiries(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() != Role.ADMIN) {
            return "redirect:/login";
        }

        List<Post> unansweredPosts = postService.getUnansweredPostList();
        model.addAttribute("user", user);
        model.addAttribute("posts", unansweredPosts);
        return "adminMain";
    }
}