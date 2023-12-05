package com.hackthon.hackthon.controller;/*
package com.hackthon.hackthon.controller;

import com.hackthon.hackthon.entity.Course;
import com.hackthon.hackthon.repository.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses/{courseId}")
    public String getCoursePage(@PathVariable Long courseId, Model model) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null) {
            model.addAttribute("course", course);
            return "course"; // This should be the name of your course HTML template
        } else {
            return "error"; // Create an error page
        }
    }
}

*/












import com.hackthon.hackthon.entity.Course;
import com.hackthon.hackthon.repository.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses/{courseId}")
    public String getCoursePage(@PathVariable Long courseId, Model model) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null) {
            model.addAttribute("course", course);
            return "course"; // Create 'course.html' to display course details
        } else {
            return "error"; // Create an error page
        }
    }

   /* @PostMapping("/enroll/{courseId}")
    public String enrollCourse(@PathVariable Long courseId) {*/
   @PostMapping("/courses/{courseId}")
   public String enrollCourse(@PathVariable Long courseId) {
        // Logic to enroll the user in the course
        // This might involve adding the course to the user's enrolled courses
        // Redirect to the specific course page after enrolling
        return "redirect:/courses/" + courseId;
    }





}
