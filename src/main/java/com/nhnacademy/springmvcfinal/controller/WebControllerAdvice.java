package com.nhnacademy.springmvcfinal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class WebControllerAdvice {
    @ExceptionHandler(Exception.class)
    public String exception(Exception ex, Model model) {
        log.error(ex.getMessage(), ex);
        model.addAttribute("error", ex.getMessage());
        return "error";
    }
}
