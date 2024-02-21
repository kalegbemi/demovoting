package com.example.demovoting.dto;

import com.example.demovoting.model.Election;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ElectionPageableResponse {
    private List<Election> content;
    private int pageNo;
    private int pageSize;
    private int totalSize;
    private int totalPages;
    private boolean last;

}
