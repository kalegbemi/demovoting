package com.example.demovoting.service;



import com.example.demovoting.dto.CandidateEmailDetails;
import com.example.demovoting.util.MessageUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailService {
    public static final String SUBJECT = "welcome Onboard";

    private String From = "kydjams@gmail.com";
    private static final String UTF_8_ENCODING = "UTF-8";


    @Autowired
    private JavaMailSender mailSender;

    public void sendVoterMessage(String email, String name, String role) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(From);
            message.setTo(email);
            message.setSubject(SUBJECT);
            message.setText("Hello " + name + ",\n\nYou have been registered as a " + role + " on the INGRYD VOTING APPLICATION." +
                    "\n\nFurther information will be communicated as the needs arises.\n\n\n\nThank you,\n\nSupport team.");
            mailSender.send(message);
            String messageString = message.toString();
            System.out.println(messageString);

        } catch (MailException E) {
            throw new RuntimeException(E.getMessage() + "\n\nEMAIL SENDING FAILED");

        }

    }

    public void sendMessage(String to, String name, String role) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setPriority(1);
            helper.setText(MessageUtil.getVoterMessage(name, role));
            helper.setTo(to);
            helper.setFrom(From);
            helper.setSubject(SUBJECT);
            mailSender.send(message);

            String messageString = message.toString();
            log.info("mimemessage sent using 2 parameters {} and {}", name, role);
            System.out.println(messageString);

        } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void sendCandidateMessage(CandidateEmailDetails details) {
        log.info("sending email to candidate {}", details.getName());
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, UTF_8_ENCODING);
            helper.setFrom(From);
            helper.setTo(details.getTo());
            helper.setSubject(SUBJECT);
            helper.setText(MessageUtil.getCandidateMessage(details));
            mailSender.send(message);

            String messageString = message.toString();
            log.info("mimemessage sent using candidate dto {}", details);
            System.out.println(messageString);
        } catch (MessagingException e) {
            log.error(e.getMessage());
        }

    }
}
