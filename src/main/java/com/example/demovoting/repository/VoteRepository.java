package com.example.demovoting.repository;

import com.example.demovoting.model.Vote;
import com.example.demovoting.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
    Vote findByVoterId(long id);
    List<Vote> findByVoter(Voter voter);
    List<Vote> findAllByElectionId(long electionId);
}
