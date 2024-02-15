package com.example.demovoting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Builder
@Data
public class ElectionRequest {

    private String Title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
