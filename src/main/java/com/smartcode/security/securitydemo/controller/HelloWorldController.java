package com.smartcode.security.securitydemo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/admin")
    public String sayAdminHello() {
        return "Hello  admin Spring Boot!!";
    }
    @RequestMapping("/user")
    public String sayUserHello() {
        return "Hello  user Spring Boot!!";
    }
    @RequestMapping("/demo")
    public String demo() {
        return "This demo function Spring Boot!!";
    }


    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}