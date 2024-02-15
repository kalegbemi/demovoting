package com.example.demovoting.controller;

import com.example.demovoting.dto.UserRegistrationRequest;
import com.example.demovoting.model.Candidate;
import com.example.demovoting.model.Voter;
import com.example.demovoting.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;
    @PostMapping("/saveCandidate")
    public Candidate registerCandidate(@RequestBody Candidate candidate) {
    return candidateService.registerCandidate(candidate);
    }
    @GetMapping("/candidate/{id}")
    public Candidate getCandidateById(@PathVariable long id){

        return candidateService.getCandidateById(id).getBody().orElseThrow();
    }

    @GetMapping("/allcandidate")
    public List<Candidate> getAllCandidate() {

        return candidateService.getAllCandidate();
    }

    @PutMapping("/candidate/{id}")
    public String updateCandidate(@PathVariable long id, @RequestBody Candidate candidate) {
        return candidateService.updateCandidate(id, candidate);
    }
    @DeleteMapping("/candidate/{id}")
    public String deleteCandidate(@PathVariable long id) {
        return candidateService.deleteCandidate(id);
    }



}
