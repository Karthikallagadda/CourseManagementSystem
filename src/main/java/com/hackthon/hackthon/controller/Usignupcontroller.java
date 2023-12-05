package com.hackthon.hackthon.controller;

import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.userrepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class Usignupcontroller {
    @Autowired
    private userrepository userRepository;

    @GetMapping("/usignup")
    public String showSignUpForm(User user) {
        return "usersignup";

    }
 /*   @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addText("user"); // Assuming you have a User class with 'username' field
        return "signup";
    }
    */

    @PostMapping("/usignup")
    public String signUp(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "usersignup";
        }
        userRepository.save(user);
        return "redirect:/ulogin";
    }
}

