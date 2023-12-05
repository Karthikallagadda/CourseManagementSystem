package com.hackthon.hackthon.services;

import com.hackthon.hackthon.entity.Course;
import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.CourseRepository;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    private final userrepository userRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(userrepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public void enrollUserInCourse(Long userId, Long courseId) {
        User user = userRepository.findById(userId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (user != null && course != null) {
            user.getEnrolledCourses().add(course);
            userRepository.save(user);
        }
    }
}
