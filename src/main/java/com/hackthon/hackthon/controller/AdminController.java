
package com.hackthon.hackthon.controller;


import com.hackthon.hackthon.services.Adminservices;
import com.hackthon.hackthon.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private Adminservices userService;



   /* @GetMapping("/admindashboard")
    public String dashboard() {
        return "admindashboard";
    }*/



    @GetMapping("/adminlogin")
    public String login() {
        return "adminlogin";
    }

    @PostMapping("/adminlogin")
    public String authenticate(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {

        Admin user = userService.findByUsername(username);

        if(user != null && user.getPassword().equals(password)) {
            return "redirect:/admindashboard"; // redirect to admin dashboard
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "adminlogin"; // back to login page
        }

    }

}

