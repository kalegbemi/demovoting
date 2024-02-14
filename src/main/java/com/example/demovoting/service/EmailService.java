package com.example.demovoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    public static final String SUBJECT = "welcome Onboard";
    @Value("${EMAIL_ADDRESS}")
    private String From;

    @Autowired
    private JavaMailSender mailSender;

    public void sendVoterMessage(String email, String name, String role) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {

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
}
