package com.hackthon.hackthon.controller;/*
package com.hackthon.hackthon.controller;

import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
*/
/*@RequestMapping("/user")*//*

public class UserController {

    @Autowired
    private userrepository userRepository;

    @GetMapping("/userdashboard")
    public String dashboard(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);

        model.addAttribute("courses", user.getCourses());
        return "userdashboard";
    }
}
*/




/*
package com.hackthon.hackthon.controller;

import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private userrepository userRepository;

    @GetMapping("/userdashboard")
    public String dashboard(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);

        if (user != null) {
            if (user.getCourses() != null) {
                model.addAttribute("courses", user.getCourses());
            } else {
                // Handle the case when user's courses are null
                model.addAttribute("courses", "No courses available");
            }
        } else {
            // Handle the case when user is null
            // You might want to redirect to an error page or handle this appropriately
            return "error"; // For example, if you have an "error.html" template
        }

        return "userdashboard";
    }
}
*/

/*

package com.hackthon.hackthon.controller;

import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
*/
/*@RequestMapping("/user")*//*

public class UserController {

    @Autowired
    private userrepository userRepository;

    @GetMapping("/userdashboard")
    public String dashboard(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);

        if (user != null) {
            // Check if the user's courses are not null before adding to the model
            if (user.getCourses() != null) {
                model.addAttribute("courses", user.getCourses());
            } else {
                model.addAttribute("courses", "No courses available"); // Placeholder message
            }
            return "userdashboard";
        } else {
            // User not found, redirect to an error page or another appropriate view
            return "userlogin"; // You may want to have a specific error view
        }
    }
}

*/
/*
package com.hackthon.hackthon.controller;

import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    private userrepository userRepository;

    @GetMapping("/userdashboard")
    public String dashboard(Model model, Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User principal) {
            String username = principal.getUsername();
            User user = userRepository.findByUsername(username);

            if (user != null) {
                model.addAttribute("courses", user.getCourses());
                return "userdashboard";
            }
        }

        return "userlogin"; // If user not found or not authenticated, redirect to login
    }
}
*/


/*

import com.hackthon.hackthon.entity.Course;
import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.CourseRepository;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private userrepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/userdashboard")
    public String userDashboard(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);

        if (user != null) {
            // Fetch the courses available in the system
            List<Course> allCourses = courseRepository.findAll();

            // Only provide the available courses to the user
            model.addAttribute("availableCourses", allCourses);
            model.addAttribute("userCourses", user.getCourses());

            return "userdashboard";
        } else {
            // Handle user not found scenario
            return "redirect:/userlogin";
        }
    }
}

*/


/*

import com.hackthon.hackthon.entity.Course;
import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.CourseRepository;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private userrepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/userdashboard")
    public String userDashboard(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);

        if (user != null) {
            List<Course> allCourses = courseRepository.findAll();

            // Log retrieved courses for debugging
            System.out.println("User Courses: " + user.getCourses());
            System.out.println("All Courses: " + allCourses);

            model.addAttribute("availableCourses", allCourses);
            model.addAttribute("userCourses", user.getCourses());

            return "userdashboard";
        } else {
            // Handle user not found scenario
            return "redirect:/userdashboard";
        }
    }
    // Other user-related methods...
}

*/







import com.hackthon.hackthon.entity.Course;
import com.hackthon.hackthon.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/userdashboard")
    public String userDashboard(Model model) {
        // Get all courses added by the admin
        List<Course> adminAddedCourses = courseRepository.findAll(); // Adjust this to match the way courses are associated with admins

        model.addAttribute("adminCourses", adminAddedCourses);

        return "userdashboard"; // This assumes the name of the view is "userdashboard"
    }

    // Other user-related methods...
}
