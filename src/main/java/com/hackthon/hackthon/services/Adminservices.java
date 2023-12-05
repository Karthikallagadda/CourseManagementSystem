package com.hackthon.hackthon.services;


import com.hackthon.hackthon.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public class Adminservices {


    private Admin admin = new Admin("admin", "karthik1234"); // hardcoded admin

    public Admin findByUsername(String username) {
        if(username.equals(admin.getUsername())) {
            return admin;
        }
        return null;
    }

}