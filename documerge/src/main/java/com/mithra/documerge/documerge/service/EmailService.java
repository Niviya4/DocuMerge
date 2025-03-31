package com.mithra.documerge.documerge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender; // Spring Boot automatically injects the configured JavaMailSender

    public void sendInvitationEmail(String toEmail, String documentId, String role) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Collaboration Invitation");
        message.setText("You have been invited to collaborate on a document. Access Level: " + role +
                "\nClick the link to join: http://localhost:8080/documents/" + documentId);
        
        mailSender.send(message);
    }
}
