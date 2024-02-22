package com.example.demovoting.configuration;

import com.example.demovoting.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class ElectionScheduler {
    @Autowired
    private ElectionService electionService;

    @Scheduled(cron = "0 */2 * * * *")
    public void updateElectionBaseOnDate(){
        electionService.updateElectionStatusBaseOnDate();
    }

}
