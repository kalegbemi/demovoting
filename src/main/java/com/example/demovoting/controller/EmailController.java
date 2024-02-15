package com.example.demovoting.controller;


import com.example.demovoting.dto.CandidateEmailDetails;
import com.example.demovoting.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mail")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/send")
    public String sendmail() {
        CandidateEmailDetails details = CandidateEmailDetails.builder()
                .to("kydjams@yahoo.com")
                .party("APC")
                .name("Kayode J Alegbemi")
                .position("PRESIDENCY")
                .role("Candidate")
                .build();
        emailService.sendCandidateMessage(details);
        return "message sent successfully";
    }

    @GetMapping("/send1")
    public String sendmail1() {
        String to = ("kydjams@yahoo.com");

        String name = "Kayode J Alegbemi";

        String role = "Candidate";

        emailService.sendMessage(to,name,role);
        return "message sent successfully";
    }
}
