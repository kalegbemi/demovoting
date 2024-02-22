package com.example.demovoting.repository;

import com.example.demovoting.enom.Status;
import com.example.demovoting.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Long> {
    Election findByTitle(String title);
    List<Election> findByStatus(Status status);

    @Modifying
    @Query("UPDATE Election e set e.status = CASE " +
            "WHEN e.startDate > CURRENT_TIMESTAMP THEN 'UPCOMING' " +
            "WHEN e.startDate <= current_timestamp AND e.endDate >= current_timestamp THEN 'ONGOING' " +
            "ELSE 'COMPLETED' END ")
    void updateElectionStatusBaseOnDates();

    @Query("SELECT e FROM Election e WHERE e.status = 'UPCOMING'")
    List<Election> FindByStatusUpcoming();


}