package com.example.bug.tracker.controller;

import com.example.bug.tracker.model.Ticket;
import com.example.bug.tracker.repos.TicketRepository;
import com.example.bug.tracker.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketController(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;

    }

    @GetMapping("/getTicket")
    public Ticket ticket (@RequestParam(value = "id", required = false ) Integer id) {
        return ticketRepository.getTicketByTicketId(id);
    }

    @PostMapping("/addNewTicket")
    public String addNewTicket (@RequestBody Ticket ticket){

        ticketRepository.save(ticket);
        return "add new ticket";
    }
}

