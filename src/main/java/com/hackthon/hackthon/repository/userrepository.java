package com.hackthon.hackthon.repository;
import com.hackthon.hackthon.entity.Course;
import com.hackthon.hackthon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userrepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


    List<User> findByCoursesContains(Optional<Course> byId);
}

