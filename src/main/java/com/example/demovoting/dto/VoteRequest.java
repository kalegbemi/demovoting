package com.example.demovoting.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VoteRequest {
    private Long voterId;
    private Long candidateId;
    private Long electionId;
}
