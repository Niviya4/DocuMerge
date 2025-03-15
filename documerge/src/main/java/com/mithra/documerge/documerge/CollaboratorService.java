package com.example.collabdoc.service;

import com.example.collabdoc.model.Collaborator;
import com.example.collabdoc.model.Document;
import com.example.collabdoc.repository.CollaboratorRepository;
import com.example.collabdoc.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorService {
    @Autowired
    private CollaboratorRepository collaboratorRepository;
    
    @Autowired
    private DocumentRepository documentRepository;
    
    public Collaborator addCollaborator(Long documentId, String email, String accessLevel) {
        Document document = documentRepository.findById(documentId).orElseThrow(() -> new RuntimeException("Document not found"));
        Collaborator collaborator = new Collaborator();
        collaborator.setDocument(document);
        collaborator.setEmail(email);
        collaborator.setAccessLevel(accessLevel);
        return collaboratorRepository.save(collaborator);
    }
    
    public List<Collaborator> getCollaborators(Long documentId) {
        return collaboratorRepository.findByDocumentId(documentId);
    }
    
    public void removeCollaborator(Long documentId, String email) {
        Collaborator collaborator = collaboratorRepository.findByDocumentIdAndEmail(documentId, email);
        if (collaborator != null) {
            collaboratorRepository.delete(collaborator);
        }
    }
}