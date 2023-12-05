package com.hackthon.hackthon.controller;


import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyCoursesController {
    private final userrepository userRepository;

    public MyCoursesController(userrepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/mycourses/{userId}")
    public String showEnrolledCourses(@PathVariable Long userId, Model model) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            model.addAttribute("enrolledCourses", user.getEnrolledCourses());
        }
        return "mycourses"; // Renders the mycourses.html Thymeleaf template
    }
}

