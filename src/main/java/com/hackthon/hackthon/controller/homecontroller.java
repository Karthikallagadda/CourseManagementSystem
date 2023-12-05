package com.hackthon.hackthon.controller;


import com.hackthon.hackthon.entity.Course;
import com.hackthon.hackthon.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class homecontroller {


    @GetMapping("/")
    public String home(){

        return "Home";
    }


   /* @GetMapping("/userdashboard")
    public String userDashboard() {
        // Add code to load user-specific data
        return "userdashboard"; // Return the name of your Thymeleaf template for the user dashboard
    }
*/

    @GetMapping("/mycourses")
    public String mycourse() {
        // Add code to load user-specific data
        return "mycourses"; // Return the name of your Thymeleaf template for the user dashboard
    }

    @GetMapping("/ulogin")
    public String showLoginForm() {
        return "userlogin"; // Make sure you have a "login.html" template in your templates folder
    }


    @GetMapping("/courses")
    public String course() {
        // Add code to load user-specific data
        return "courses"; // Return the name of your Thymeleaf template for the user dashboard
    }


   /* @GetMapping("/admindashboard")
    public String admindashboard() {
        // Add code to load user-specific data
        return "admindashboard"; // Return the name of your Thymeleaf template for the user dashboard
    }*/

    @GetMapping("/computer science")
    public String computerscience() {
        // Add code to load user-specific data
        return "computer science"; // Return the name of your Thymeleaf template for the user dashboard
    }

   @GetMapping("/reset-password")
    public String forgetpassword() {
        // Add code to load user-specific data
        return "resetpassword"; // Return the name of your Thymeleaf template for the user dashboard
    }

    @GetMapping("/reset-password-form")
    public String showResetPasswordForm() {
        return "reset-password-success";
    }
  /*  @Autowired
    private CourseRepository courseRepo;

    *//*@GetMapping("/courses")
    public String showCourses(Model model) {
        List<Course> courses = courseRepo.findAll();
        model.addAttribute("courses", courses);
        return "courses";
    }
*/


}
