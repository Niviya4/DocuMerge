package com.example.collabdoc.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "document_versions")
public class DocumentVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;
    
    private String content;
    private Date modifiedAt;
    private String modifiedBy;
}