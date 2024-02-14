package com.example.demovoting.repository;

import com.example.demovoting.enom.Status;
import com.example.demovoting.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Long> {
    Election findByTitle(String title);
    List<Election> findByStatus(Status status);

}