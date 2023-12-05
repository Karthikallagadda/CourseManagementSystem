package com.hackthon.hackthon.controller;/*
package com.hackthon.hackthon.controller;


import com.hackthon.hackthon.entity.Course;
import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.CourseRepository;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminCourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private userrepository userRepository;

    @GetMapping("/admin/courses")
    public String courses(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "admin_courses";
    }

    @PostMapping("/admin/courses/add")
    public String addCourse(String courseName) {
        Course course = new Course();
        course.setCourseName(courseName);
        courseRepository.save(course);

        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.getCourses().add(course);
            userRepository.save(user);
        }
        return "redirect:/admin/courses";
    }

    @PostMapping("/admin/courses/delete")
    public String deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);

        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.getCourses().removeIf(course -> course.getId().equals(courseId));
            userRepository.save(user);
        }
        return "redirect:/admin/courses";
    }
}

*//*


package com.hackthon.hackthon.controller;

import com.hackthon.hackthon.entity.Course;
import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.CourseRepository;

import com.hackthon.hackthon.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class AdminCourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private userrepository userRepository;

    @GetMapping("/admindashboard")
    public String courses(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "admindashboard";
    }

    @PostMapping("/admin/courses/add")
    public String addCourse(@RequestParam String courseName, @RequestParam String courseImage, @RequestParam String description) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseImage(courseImage);

        // Truncate the 'description' to fit the maximum length allowed in the database
        int maxDescriptionLength = 225; // Assuming 255 as the maximum length in this example
        if (description.length() > maxDescriptionLength) {
            description = description.substring(0, maxDescriptionLength);
        }
        course.setDescription(description);

        courseRepository.save(course);
        return "redirect:/admindashboard";
    }

   */
/* @PostMapping("/admin/courses/add")
    public String addCourse(@RequestParam String courseName) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseImage(courseImage);
        course.setDescription(description);
        courseRepository.save(course);

        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.getCourses().add(course);
            userRepository.save(user);
        }
        return "redirect:/admindashboard";
    }*//*


   */
/* @PostMapping("/admindashboard/add")
    public String addCourse(String courseName) {
        Course course = new Course();
        course.setCourseName(courseName);
        courseRepository.save(course);

        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.getCourses().add(course);
            userRepository.save(user);
        }
        return "redirect:/admindashboard";
    }*//*


*/
/*    @PostMapping("/admindashboard/delete")
    public String deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);

        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.getCourses().removeIf(course -> course.getId().equals(courseId));
            userRepository.save(user);
        }
        return "redirect:/admindashboard";
    }*//*



  */
/*  @PostMapping("/admin/courses/delete")
    public String deleteCourse(@RequestParam Long courseId) {
        courseRepository.deleteById(courseId);

        List<User> users = userRepository.findByCoursesContains(courseRepository.findById(courseId)); // Replace 'findByCoursesContains' with an appropriate method from your repository
        for (User user : users) {
            user.getCourses().removeIf(course -> course.getId().equals(courseId));
            userRepository.save(user);
        }
        return "redirect:/admindashboard";
    }*//*



    @PostMapping("/admin/courses/delete")
    public String deleteCourse(@RequestParam Long courseId) {
        // Find the course by ID
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course != null) {
            // Retrieve users associated with the course
            Set<User> users = course.getUsers(); // Use Set instead of List

            if (users != null) {
                // Remove the course from each user's course list
                for (User user : users) {
                    user.getCourses().remove(course);
                    userRepository.save(user);
                }
            }

            // Remove the course from the database
            courseRepository.delete(course);
        }

        return "redirect:/admindashboard";
    }


}
*/


import com.hackthon.hackthon.SessionManager;
import com.hackthon.hackthon.entity.Course;
import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.CourseRepository;

import com.hackthon.hackthon.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminCourseController {

    private final SessionManager sessionManager;
    private final userrepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public AdminCourseController(SessionManager sessionManager, userrepository userRepository) {
        this.sessionManager = sessionManager;
        this.userRepository = userRepository;
    }

    @GetMapping("/admindashboard")
    public String showAdminDashboard(Model model) {
        int activeUserCount = sessionManager.getActiveUserCount();
        model.addAttribute("activeUserCount", activeUserCount);

        List<User> allUsers = userRepository.findAll();
        model.addAttribute("totalUserCount", allUsers.size()); // Total registered users

        model.addAttribute("courses", courseRepository.findAll());
        return "admindashboard"; // Return the admindashboard.html Thymeleaf template
    }

    @PostMapping("/admin/courses/add")
    public String addCourse(@RequestParam String courseName, @RequestParam String courseImage, @RequestParam String description) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseImage(courseImage);
        course.setDescription(description);

        courseRepository.save(course);
        return "redirect:/admindashboard";
    }

    @PostMapping("/admin/courses/delete")
    public String deleteCourse(@RequestParam Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course != null) {
            List<User> users = userRepository.findByCoursesContains(Optional.of(course));
            for (User user : users) {
                user.getCourses().remove(course);
                userRepository.save(user);
            }

            courseRepository.delete(course);
        }

        return "redirect:/admindashboard";
    }
}
