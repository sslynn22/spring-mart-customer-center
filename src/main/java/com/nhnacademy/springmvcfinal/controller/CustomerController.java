package com.nhnacademy.springmvcfinal.controller;

import com.nhnacademy.springmvcfinal.domain.Role;
import com.nhnacademy.springmvcfinal.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping("/customer")
    public String customer(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null || user.getRole() != Role.CUSTOMER) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "customerMain";
    }
}
