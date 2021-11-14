package com.example.bug.tracker.controller;

import com.example.bug.tracker.model.Ticket;
import com.example.bug.tracker.model.User;
import com.example.bug.tracker.repos.TicketRepository;
import com.example.bug.tracker.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public UserController(UserRepository userRepository, TicketRepository ticketRepository, TicketRepository ticketRepository1){
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository1;
    }

    @GetMapping("/getUser")
    public User getUser (@RequestParam (value = "id", required = false ) Integer id) {
        return userRepository.getUserByUserId(id);
    }

    @PostMapping("/addNewUser")
    public String addNewUSer (@RequestBody User user){
        Set<Ticket> ticketSet = user.getTickets();
        user.setTickets(null);
        userRepository.save(user);
        for (Ticket ticket: ticketSet){
            ticket.setUser(user);
            ticketRepository.save(ticket);
        }
        return "add new user";
    }


}
