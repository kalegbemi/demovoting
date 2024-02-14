package com.example.demovoting.model;

import com.example.demovoting.enom.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private LocalDate DOB;

    @Email
    private String email;

    private String password;

    private  boolean eligible;

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.VOTER;


}
