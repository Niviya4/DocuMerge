package com.example.collabdoc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "collaborators")
public class Collaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String documentId;
    private String role;

    public Collaborator() {}

    public Collaborator(String email, String documentId, String role) {
        this.email = email;
        this.documentId = documentId;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}