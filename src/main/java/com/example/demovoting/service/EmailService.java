package com.example.demovoting.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailService {
    public static final String SUBJECT = "welcome Onboard";

    private String From = "kydjams@gmail.com";



    @Autowired
    private JavaMailSender mailSender;

    public void sendVoterMessage(String email, String name, String role) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(From);
            message.setTo(email);
            message.setSubject(SUBJECT);
            message.setText("Hello "+ name+",\n\nYou have been registered as a "+role+" on the INGRYD VOTING APPLICATION." +
                    "\n\nFurther information will be communicated as the needs arises.\n\n\n\nThank you,\n\nSupport team.");
            mailSender.send(message);
            String messageString = message.toString();
            System.out.println(messageString);

        }catch (MailException E){
            throw new RuntimeException(E.getMessage()+"\n\nEMAIL SENDING FAILED");

        }

    }



    public void sendCandidateMessage(String email, String name, String role, String partyAffliation, String positon) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(From);
            message.setTo(email);
            message.setSubject(SUBJECT);
            message.setText("Hello "+ name +",\n\nYou have been registered as a "+ role +" on the INGRYD VOTING APPLICATION." +
                    "\n\nYou were registered as a candidate contesting for the position of "+ positon +"under" +
                    "the party "+ partyAffliation +"."+
                    "\n\nFurther information will be communicated as the needs arises.\n\n\n\nThank you,\n\nSupport team.");

            mailSender.send(message);
            String messageString = message.toString();
            System.out.println(messageString);
        } catch (MailException E){
        throw new RuntimeException(E.getMessage()+"\n\nEMAIL SENDING FAILED");

    }


}}
