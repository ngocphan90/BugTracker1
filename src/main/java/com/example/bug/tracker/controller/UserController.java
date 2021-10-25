package com.example.bug.tracker.controller;

import com.example.bug.tracker.model.User;
import com.example.bug.tracker.repos.TicketRepository;
import com.example.bug.tracker.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/getUser")
    public User getUser (@RequestParam (value = "id", required = false ) Integer id) {
        return userRepository.getUserByUserId(id);
    }

    @PostMapping("/addNewUser")
    public String addNewUSer (@RequestBody User user){
        userRepository.save(user);
        return "add new user";
    }


}
