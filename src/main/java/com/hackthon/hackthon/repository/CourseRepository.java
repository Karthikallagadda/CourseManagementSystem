/*
package com.hackthon.hackthon.repository;

import com.hackthon.hackthon.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByCoursename(String name);
}

*/



package com.hackthon.hackthon.repository;

import com.hackthon.hackthon.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
   // Custom query method to find a course by name
}
