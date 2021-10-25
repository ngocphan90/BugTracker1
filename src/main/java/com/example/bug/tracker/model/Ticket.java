package com.example.bug.tracker.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer ticketId;

    @ManyToOne (fetch = FetchType.LAZY)
    //@JoinColumn(name ="userId", nullable = false)
    private User user;

    @NotBlank(message = "description is required")
    private String description;



}
