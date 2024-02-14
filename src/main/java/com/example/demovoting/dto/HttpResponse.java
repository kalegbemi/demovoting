package com.example.demovoting.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Map;

@SuperBuilder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpResponse {
    @CreationTimestamp
    private String timeStamp;

    private String status;

    private int statusCode;

    private String message;

    private String path;

    private String requestMethod;

    private Map<?, ?> data;
}