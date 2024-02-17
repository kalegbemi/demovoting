package com.example.demovoting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class AdminRegisterRequest {

    private String password;
    private String fullName;
    private String email;
}
