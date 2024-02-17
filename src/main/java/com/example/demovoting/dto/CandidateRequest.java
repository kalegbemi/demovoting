package com.example.demovoting.dto;

import com.example.demovoting.enom.Role;
import lombok.Data;

@Data
public class CandidateRequest {
    private String firstName;
    private String lastName;
    private String  partyAffiliation;
    private String position;
    private String email;
    private Role role = Role.VOTER;
}
