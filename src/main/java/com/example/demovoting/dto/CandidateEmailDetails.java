package com.example.demovoting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data @Builder @ToString
public class CandidateEmailDetails {

    private String to;
    private String party;
    private String name;
    private String position;
    private String role;

}
