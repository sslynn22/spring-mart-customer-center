package com.nhnacademy.springmvcfinal.controller;

import com.nhnacademy.springmvcfinal.domain.Role;
import com.nhnacademy.springmvcfinal.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String admin(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() != Role.ADMIN) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "adminMain";
    }
}
