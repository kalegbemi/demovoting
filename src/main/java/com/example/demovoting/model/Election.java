package com.example.demovoting.model;

import com.example.demovoting.enom.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class Election {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        @Enumerated(value = EnumType.STRING)
        private Status status = Status.UPCOMING;

    }
