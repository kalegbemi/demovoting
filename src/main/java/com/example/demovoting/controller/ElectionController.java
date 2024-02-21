package com.example.demovoting.controller;

import com.example.demovoting.dto.ElectionPageableResponse;
import com.example.demovoting.dto.ElectionRequest;
import com.example.demovoting.dto.HttpResponse;
import com.example.demovoting.enom.Status;
import com.example.demovoting.model.Election;
import com.example.demovoting.service.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/election")
public class ElectionController {



        private final ElectionService electionService;

        @GetMapping("/all")
        public ResponseEntity<ElectionPageableResponse> getAllElections(
                @RequestParam( value = "pageNo",defaultValue = "0",required = false) int pageNo,
                @RequestParam(value = "pageSize", defaultValue = "5",required = false) int pageSize
        ){
            return electionService.findAllElection(pageNo, pageSize);
        }

        @GetMapping("/getById")
        public ResponseEntity<String> findById(@RequestParam("id") Long id){
            return electionService.findElectionById(id);
        }

        @PostMapping("/save")
        public ResponseEntity<Election> saveElection(@RequestBody ElectionRequest request){
            return electionService.createElection(request);
        }

        @GetMapping("/getByStatus")
        public ResponseEntity<List<Election>> findElectionByStatus(@RequestParam("status") Status status){
            return electionService.findElectionByStatus(status);
        }

        @GetMapping("/getByTitle")
        public ResponseEntity<Election> findElectionByTitle(@RequestParam("title") String title){
            return electionService.findElectionByTitle(title);
        }

        @PutMapping("/updateElection/{id}")
        public ResponseEntity<Election> updateElectionById(@PathVariable Long id, @RequestBody ElectionRequest request){
            return electionService.updateElectionById(id, request);
        }

        @DeleteMapping("/deleteelectionbyid/{id}")
        public ResponseEntity<HttpResponse> deleteElectionById(@PathVariable Long id) throws URISyntaxException {
            return electionService.deleteElectionById(id);
        }
}
