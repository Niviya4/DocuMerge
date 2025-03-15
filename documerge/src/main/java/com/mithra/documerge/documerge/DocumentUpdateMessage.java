package com.example.collabdoc.websocket;

import lombok.Data;

@Data
public class DocumentUpdateMessage {
    private Long documentId;
    private String content;
}