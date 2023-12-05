/*
package com.hackthon.hackthon.services;

import com.hackthon.hackthon.entity.User;
import com.hackthon.hackthon.repository.userrepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    private final userrepository userRepository;

    public UserService(userrepository userRepository) {
        this.userRepository = userRepository;
    }

    // Constructor Injection

    public void updateUserCourses(Long userId, Collection<Object> courses) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setCourses(courses);
            userRepository.save(user);
        }
    }

    // Other methods related to users
}

*/
