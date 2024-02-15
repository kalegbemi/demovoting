package com.example.demovoting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEmailDetails {
    private String to;
    private String name;
    private String role;
    private String party;
    private String position;
}
