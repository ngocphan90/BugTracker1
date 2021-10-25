package com.example.bug.tracker.model;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table (name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)

    private Integer userId ;
    @NotBlank(message = "first name is required")
    private String first_name;
    @NotBlank(message = "last name is required")
    private String last_name;
    @NotBlank(message = "username is required")
    private String user_name;
    @NotBlank(message = "password is required")
    private String pass_word;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;


}