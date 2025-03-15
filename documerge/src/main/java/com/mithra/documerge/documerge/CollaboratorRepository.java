package com.example.collabdoc.repository;

import com.example.collabdoc.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
    List<Collaborator> findByDocumentId(String documentId);
    Collaborator findByEmailAndDocumentId(String email, String documentId);
}