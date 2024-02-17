package com.example.demovoting.controller;

import com.example.demovoting.dto.VoteRequest;
import com.example.demovoting.model.Vote;
import com.example.demovoting.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class VoteController {
    private VoteService voteService;

    @PostMapping("/castVote")
    public ResponseEntity<String> castVote(@RequestBody VoteRequest voteRequest) {
        return voteService.castVote(voteRequest);
    }

    @GetMapping("/election/{electionId}")
    public ResponseEntity<Vote> getElectionById(@PathVariable("electionId") long id) {
        return voteService.getElectionById(id);

    }

    @GetMapping("/voter/{voterId}")
    public ResponseEntity<Vote> getVoteByVoterId(@PathVariable("voterId") long id) {
        return voteService.getVoteByVoterId(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vote>> findAllVote() {
        return voteService.findAllVote();
    }


}
