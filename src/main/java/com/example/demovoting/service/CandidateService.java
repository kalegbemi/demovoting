package com.example.demovoting.service;

import com.example.demovoting.dto.CandidateEmailDetails;
import com.example.demovoting.dto.CandidateRequest;
import com.example.demovoting.enom.Role;
import com.example.demovoting.model.Candidate;
import com.example.demovoting.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final EmailService emailService;

    @CacheEvict(value = "candidate", allEntries = true)
    public Candidate registerCandidate(CandidateRequest request) {
        Candidate candidate = new Candidate();
        candidate.setFirstName(request.getFirstName());
        candidate.setLastName(request.getLastName());
        candidate.setPosition(request.getPosition());
        candidate.setEmail(request.getEmail());
        candidate.setPartyAffiliation(request.getPartyAffiliation());
        candidate.setRole(Role.VOTER);
        candidateRepository.save(candidate);
        CandidateEmailDetails details = CandidateEmailDetails.builder()
                .name(request.getFirstName() + " " + request.getLastName())
                .to(request.getEmail())
                .party(request.getPartyAffiliation())
                .position(request.getPosition())
                .role(Role.VOTER.name()).build();
        String name = request.getFirstName() + " " + request.getLastName();
        emailService.sendCandidateMessage(details);
        return candidate;
    }
    @Cacheable(value = "singleCandidate")
    public ResponseEntity<Optional<Candidate>> getCandidateById(long id) {
        return new ResponseEntity<>(candidateRepository.findById(id),HttpStatus.OK);
    }
    @Cacheable(value = "allCandidate")
    public  List<Candidate> getAllCandidate() {
        return candidateRepository.findAll();
    }
    @CacheEvict(value = "singleCandidate", allEntries = true)
    public String updateCandidate(long id, Candidate candidate) {
        Optional<Candidate> candidateRepositoryById = candidateRepository.findById(id);
        if (candidateRepositoryById.isPresent()) {
            Candidate toUpdate = new Candidate();
            toUpdate.setFirstName(candidate.getFirstName());
            toUpdate.setLastName(candidate.getLastName());
            toUpdate.setPartyAffiliation(candidate.getPartyAffiliation());

            candidateRepository.save(toUpdate);
            return "Candidate successfully updated";
        }
        else {
            return "Candidate not found with ID: " + id;
        }
    }
    @CacheEvict(value = "singleCandidate", allEntries = true)
    public String deleteCandidate(long id) {
        candidateRepository.deleteById(id);
      return "Candidate successfully deleted";
    }
}
