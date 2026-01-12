package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String openRegisterPage(Model model) {
        model.addAttribute("userRegistration", new User());
        return "register";
    }

    @PostMapping("/register")
    public String submitRegisterForm(
            @ModelAttribute("userRegistration") User user) {

        userRepository.save(user);   // ⭐ THIS IS THE KEY
        return "redirect:/login";
    }
}
