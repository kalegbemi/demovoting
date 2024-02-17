package com.example.demovoting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class AuthenticationResponse {
    private String token;
}
