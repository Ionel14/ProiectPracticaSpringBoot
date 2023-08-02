package com.example.ProiectPracticaSpringBoot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

public class BaseController {

    protected void addUserToModel(Model model, Authentication authentication) {
        var roles = authentication.getAuthorities().stream()
                .map(String::valueOf)
                .toList();

        model.addAttribute("userName", authentication.getName());
        model.addAttribute("isAdmin", roles.contains("ROLE_ADMIN"));
    }
}