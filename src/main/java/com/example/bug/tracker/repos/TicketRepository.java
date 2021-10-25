package com.example.bug.tracker.repos;

import com.example.bug.tracker.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
        Ticket getTicketByTicketId(Integer id);
}
