package com.example.collabdoc.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class DocumentUpdateController {

    @MessageMapping("/edit")
    @SendTo("/topic/updates")
    public DocumentUpdateMessage sendUpdate(DocumentUpdateMessage message) {
        return message;
    }
}