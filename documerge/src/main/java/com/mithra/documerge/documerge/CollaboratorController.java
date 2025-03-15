package com.example.collabdoc.controller;

import com.example.collabdoc.model.Collaborator;
import com.example.collabdoc.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collaborators")
public class CollaboratorController {
    @Autowired
    private CollaboratorService collaboratorService;
    
    @PostMapping("/add")
    public ResponseEntity<Collaborator> addCollaborator(@RequestParam Long documentId, @RequestParam String email, @RequestParam String accessLevel) {
        return ResponseEntity.ok(collaboratorService.addCollaborator(documentId, email, accessLevel));
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Collaborator>> getCollaborators(@RequestParam Long documentId) {
        return ResponseEntity.ok(collaboratorService.getCollaborators(documentId));
    }
    
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeCollaborator(@RequestParam Long documentId, @RequestParam String email) {
        collaboratorService.removeCollaborator(documentId, email);
        return ResponseEntity.ok("Collaborator removed successfully");
    }
}