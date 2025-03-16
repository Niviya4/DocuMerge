package com.mithra.documerge.documerge.controller;

import com.mithra.documerge.documerge.model.Collaborator;
import com.mithra.documerge.documerge.repository.CollaboratorRepository;
import com.mithra.documerge.documerge.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/collaboration")
public class CollaborationController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @PostMapping("/invite")
    public ResponseEntity<String> inviteCollaborator(@RequestParam String email,
                                                     @RequestParam String documentId,
                                                     @RequestParam String role) {
        Collaborator collaborator = new Collaborator(email, documentId, role);
        collaboratorRepository.save(collaborator);
        emailService.sendInvitationEmail(email, documentId, role);
        return ResponseEntity.ok("Invitation sent to " + email);
    }

    @GetMapping("/list/{documentId}")
    public ResponseEntity<List<Collaborator>> getCollaborators(@PathVariable String documentId) {
        return ResponseEntity.ok(collaboratorRepository.findByDocumentId(documentId));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeCollaborator(@RequestParam String email, @RequestParam String documentId) {
        Collaborator collaborator = collaboratorRepository.findByEmailAndDocumentId(email, documentId);
        if (collaborator != null) {
            collaboratorRepository.delete(collaborator);
            return ResponseEntity.ok("Collaborator removed");
        }
        return ResponseEntity.badRequest().body("Collaborator not found");
    }

    @GetMapping("/access/{documentId}/{email}")
    public ResponseEntity<String> checkAccess(@PathVariable String documentId, @PathVariable String email) {
        Collaborator collaborator = collaboratorRepository.findByEmailAndDocumentId(email, documentId);
        if (collaborator != null) {
            return ResponseEntity.ok(collaborator.getRole());
        }
        return ResponseEntity.badRequest().body("No access");
    }

    @PutMapping("/update-role")
    public ResponseEntity<String> updateRole(@RequestParam String email, @RequestParam String documentId, @RequestParam String role) {
        Collaborator collaborator = collaboratorRepository.findByEmailAndDocumentId(email, documentId);
        if (collaborator != null) {
            collaborator.setRole(role);
            collaboratorRepository.save(collaborator);
            return ResponseEntity.ok("Role updated");
        }
        return ResponseEntity.badRequest().body("Collaborator not found");
    }
}