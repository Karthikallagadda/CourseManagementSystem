package com.hackthon.hackthon.controller;/*package com.hackthon.hackthon.controller;



import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller

@RequestMapping
public class Ulogincontroller {
    @Autowired
    private userrepository userrepository;

    @GetMapping("/ulogin")
    public String showLoginForm() {
        return "userlogin"; // Make sure you have a "login.html" template in your templates folder
    }

    @PostMapping("/ulogin")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userrepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // User authenticated successfully, perform login actions
            return "redirect:/userdashboard"; // Change the URL path to "/home" if you have a controller or endpoint for the home page
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "userlogin";
        }
    }
}*/


/*

import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.userrepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

*//*import javax.validation.Valid;*//*


@Controller
@RequestMapping
public class Ulogincontroller {
    @Autowired
    private userrepository userrepository;

    // Inject your reCAPTCHA secret key here
    private static final String RECAPTCHA_SECRET_KEY = "6Lf0J8AoAAAAABVgMx2D8rTjMouHFv2V9GKsULQv";


    @GetMapping("/ulogin")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "userlogin"; // Make sure you have a "userlogin.html" template in your templates folder
    }


    *//* @GetMapping("/ulogin")
     public String showLoginForm() {
         return "userlogin"; // Make sure you have a "login.html" template in your templates folder
     }*//*
    @PostMapping("/ulogin")
    public String login(@Valid User user, BindingResult bindingResult, @RequestParam(name = "g-recaptcha-response") String reCaptchaResponse, Model model) {
        System.out.println("reCaptchaResponse: " + reCaptchaResponse);

        if (!verifyReCaptcha(reCaptchaResponse)) {
            System.out.println("reCAPTCHA verification failed.");
            model.addAttribute("error", "reCAPTCHA verification failed. Please try again.");
            return "userlogin";
        }

        User userFromDb = userrepository.findByUsername(user.getUsername());

        if (userFromDb != null && userFromDb.getPassword().equals(user.getPassword())) {
            // User authenticated successfully, perform login actions
            return "redirect:/userdashboard"; // Change the URL path to "/home" if you have a controller or endpoint for the home page
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "userlogin";
        }
    }





*//*    @PostMapping("/ulogin")
    public String login(@Valid User user, BindingResult bindingResult, @RequestParam(name = "g-recaptcha-response") String reCaptchaResponse, Model model) {
        if (!verifyReCaptcha(reCaptchaResponse)) {
            model.addAttribute("error", "reCAPTCHA verification failed. Please try again.");
            return "userlogin";
        }

        User userFromDb = userrepository.findByUsername(user.getUsername());

        if (userFromDb != null && userFromDb.getPassword().equals(user.getPassword())) {
            // User authenticated successfully, perform login actions
            return "redirect:/userdashboard"; // Change the URL path to "/home" if you have a controller or endpoint for the home page
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "userlogin";
        }
    }

    private boolean verifyReCaptcha(String reCaptchaResponse) {
        // Implement reCAPTCHA verification logic using your secret key
        // You can use a reCAPTCHA client library or make an HTTP request to the reCAPTCHA verification endpoint
        // Example: https://www.google.com/recaptcha/api/siteverify

        // Send an HTTP request to the verification endpoint and parse the response
        // Replace 'YOUR_RECAPTCHA_SECRET_KEY' with your actual secret key

        // If verification is successful, return true; otherwise, return false

        return true; // Replace this with your actual reCAPTCHA verification logic
    }
}*//*

}*/


/*

import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

@Controller
@RequestMapping
public class Ulogincontroller {
    @Autowired
    private userrepository userrepository;

    // Inject your reCAPTCHA secret key here
    private static final String RECAPTCHA_SECRET_KEY = "6Lf0J8AoAAAAABVgMx2D8rTjMouHFv2V9GKsULQv";

    @GetMapping("/ulogin")
    public String showLoginForm() {
        return "userlogin"; // Make sure you have a "login.html" template in your templates folder
    }

    @PostMapping("/ulogin")
    public String login(@Valid User user, BindingResult bindingResult, @RequestParam(name = "g-recaptcha-response") String reCaptchaResponse, Model model) {
        if (!verifyReCaptcha(reCaptchaResponse)) {
            model.addAttribute("error", "reCAPTCHA verification failed. Please try again.");
            return "userlogin";
        }

        User userFromDb = userrepository.findByUsername(user.getUsername());

        if (userFromDb != null && userFromDb.getPassword().equals(user.getPassword())) {
            // User authenticated successfully, perform login actions
            return "redirect:/userdashboard"; // Change the URL path to "/home" if you have a controller or endpoint for the home page
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "userlogin";
        }
    }

    private boolean verifyReCaptcha(String reCaptchaResponse) {
        // Implement reCAPTCHA verification logic using your secret key
        // You can use a reCAPTCHA client library or make an HTTP request to the reCAPTCHA verification endpoint
        // Example: https://www.google.com/recaptcha/api/siteverify

        // Send an HTTP request to the verification endpoint and parse the response
        // Replace 'YOUR_RECAPTCHA_SECRET_KEY' with your actual secret key

        // If verification is successful, return true; otherwise, return false

        return true; // Replace this with your actual reCAPTCHA verification logic
    }
}





*/



import com.hackthon.hackthon.SessionManager;
import com.hackthon.hackthon.entity.User;

import com.hackthon.hackthon.repository.userrepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class UloginController {

    @Autowired
    private userrepository userRepository;
    private final SessionManager sessionManager;

    public UloginController(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    // Other mappings and methods...

    @PostMapping("/ulogin")
    public String login(@Valid User user, BindingResult bindingResult, @RequestParam(name = "g-recaptcha-response") String reCaptchaResponse, Model model, HttpServletRequest request) {
        if (!verifyReCaptcha(reCaptchaResponse)) {
            model.addAttribute("error", "reCAPTCHA verification failed. Please try again.");
            return "userlogin";
        }

        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null && userFromDb.getPassword().equals(user.getPassword())) {
            // User authenticated successfully, perform login actions
            sessionManager.addSession(request.getSession().getId(), user.getUsername()); // Add session to the SessionManager
            return "redirect:/userdashboard"; // Change the URL path to "/home" if you have a controller or endpoint for the home page
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "userlogin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        sessionManager.removeSession(request.getSession().getId()); // Remove the session from the SessionManager
        return "redirect:/login";
    }

    private boolean verifyReCaptcha(String reCaptchaResponse) {
        // Implement reCAPTCHA verification logic using your secret key
        // You can use a reCAPTCHA client library or make an HTTP request to the reCAPTCHA verification endpoint
        // Example: https://www.google.com/recaptcha/api/siteverify

        // Send an HTTP request to the verification endpoint and parse the response
        // Replace 'YOUR_RECAPTCHA_SECRET_KEY' with your actual secret key

        // If verification is successful, return true; otherwise, return false

        return true; // Replace this with your actual reCAPTCHA verification logic
    }
}

