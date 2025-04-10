package com.nhnacademy.springmvcfinal.controller;

import com.nhnacademy.springmvcfinal.domain.Role;
import com.nhnacademy.springmvcfinal.domain.User;
import com.nhnacademy.springmvcfinal.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login(@CookieValue(value = "JSESSIONID", required = false) String session,
                        HttpServletResponse response,
                        Model model) {
        if (StringUtils.hasText(session)) {
            // 쿠키 무효화
            Cookie expiredCookie = new Cookie("JSESSIONID", "");
            expiredCookie.setMaxAge(0); // 즉시 만료
            expiredCookie.setPath("/");
            response.addCookie(expiredCookie);
        }
        return "loginForm";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          ModelMap modelMap) {
        if (userRepository.matches(id, pwd)) {
            HttpSession session = request.getSession(true);
            User user = userRepository.getUser(id);
            session.setAttribute("user", user);

            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            response.addCookie(cookie);

            modelMap.addAttribute("id", session.getId());

            if (user.getRole() == Role.ADMIN) {
                return "redirect:/admin";
            } else {
                return "redirect:/customer";
            }
        } else {
            return "redirect:LoginForm";
        }
    }
}
