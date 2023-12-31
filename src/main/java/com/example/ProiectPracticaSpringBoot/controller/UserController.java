package com.example.ProiectPracticaSpringBoot.controller;

import com.example.ProiectPracticaSpringBoot.dto.TeamFormDto;
import com.example.ProiectPracticaSpringBoot.dto.UserDto;
import com.example.ProiectPracticaSpringBoot.model.User;
import com.example.ProiectPracticaSpringBoot.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String loginForm(){
        if (userService.existUsers())
        {
            UserDto userDto = UserDto.builder()
                    .firstname("admin")
                    .lastname("admin")
                    .role("ROLE_ADMIN")
                    .email("admin@gmail.com")
                    .password("admin")
                    .build();
            userService.register(userDto);
        }
        return "login";
    }


    @GetMapping("/register")
    public String registerForm(Model model){
        UserDto userDto =  new UserDto();
        model.addAttribute("user",userDto);
        return "register";
    }

    @PostMapping("/register")
    public String register( @ModelAttribute("user")  @Valid UserDto userDto,
                            BindingResult bindingResult,
                            Model model){

        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null) bindingResult.rejectValue("email", null, "User already registered");

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }

        userDto.setRole("ROLE_USER");
        userService.register(userDto);
        return "redirect:/register?success";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    @GetMapping("/access-denied")
    @ResponseBody
    public String accessDenied(Model model) {
        return "Access denied";
    }
}
