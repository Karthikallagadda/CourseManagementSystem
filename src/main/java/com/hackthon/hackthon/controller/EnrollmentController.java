package com.hackthon.hackthon.controller;

import com.hackthon.hackthon.services.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/enroll/{userId}/{courseId}")
    public ResponseEntity<String> enrollUserInCourse(
            @PathVariable Long userId,
            @PathVariable Long courseId
    ) {
        // Perform course enrollment for the given user and course
        enrollmentService.enrollUserInCourse(userId, courseId);
        return ResponseEntity.ok("Enrolled in the course successfully");
    }
}

