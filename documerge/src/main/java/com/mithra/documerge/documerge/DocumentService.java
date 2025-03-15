package com.example.collabdoc.service;

import com.example.collabdoc.model.Document;
import com.example.collabdoc.model.DocumentVersion;
import com.example.collabdoc.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public Document createDocument(String title, String content, String ownerEmail) {
        Document document = new Document();
        document.setTitle(title);
        document.setContent(content);
        document.setOwnerEmail(ownerEmail);
        document.setCreatedAt(new Date());
        return documentRepository.save(document);
    }

    public List<Document> getDocumentsByOwner(String ownerEmail) {
        return documentRepository.findByOwnerEmail(ownerEmail);
    }
}