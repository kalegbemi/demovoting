package com.example.demovoting.service;

import com.example.demovoting.dto.CandidateEmailDetails;
import com.example.demovoting.enom.Role;
import com.example.demovoting.model.Candidate;
import com.example.demovoting.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
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


    public Candidate registerCandidate(Candidate candidate1) {
//        Candidate candidate1 = new Candidate();
//        candidate1.setFirstName(candidate.getFirstName());
//        candidate1.setLastName(candidate.getLastName());
//        candidate1.setPartyAffiliation(candidate.getPartyAffiliation());
//        candidate1.setPosition(candidate.getPosition());
//        candidate1.setRole(Role.VOTER);
        candidateRepository.save(candidate1);
        CandidateEmailDetails details = CandidateEmailDetails.builder()
                .to(candidate1.getEmail())
                .party(candidate1.getPartyAffiliation())
                .role(candidate1.getRole().name())
                .position(candidate1.getPosition())
                .name(candidate1.getFirstName() + " " + candidate1.getLastName())
                .build();
        //String name = candidate1.getFirstName() + " " + candidate1.getLastName();
        emailService.sendCandidateMessage(details);
        return candidate1;
    }

    public ResponseEntity<Optional<Candidate>> getCandidateById(long id) {
        return new ResponseEntity<>(candidateRepository.findById(id),HttpStatus.OK);
    }

    public  List<Candidate> getAllCandidate() {
        return candidateRepository.findAll();
    }

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

    public String deleteCandidate(long id) {
        candidateRepository.deleteById(id);
      return "Candidate successfully deleted";
    }
}
