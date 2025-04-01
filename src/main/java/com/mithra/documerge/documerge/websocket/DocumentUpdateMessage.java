package com.mithra.documerge.documerge.websocket;

import lombok.Data;

@Data
public class DocumentUpdateMessage {
    private Long documentId;
    private String content;
}