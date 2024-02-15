package com.example.demovoting.model;

import com.example.demovoting.enom.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String  partyAffiliation;
    private String position;
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.VOTER;


}
