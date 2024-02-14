package com.example.demovoting.repository;

import com.example.demovoting.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {


    Voter findByEmail(String username);
}
