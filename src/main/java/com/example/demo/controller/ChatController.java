package com.example.demo.controller;

import com.example.demo.model.ChatMessage;
import com.example.demo.repository.ChatRepository;
import com.example.demo.service.AIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final AIService aiService;
    private final ChatRepository repo;

    public ChatController(AIService aiService, ChatRepository repo) {
        this.aiService = aiService;
        this.repo = repo;
    }

    @PostMapping
    public String chat(@RequestParam double budget, @RequestParam String category) {

        String response = aiService.getSuggestion(budget, category);

        repo.save(new ChatMessage(null,
                "Budget: " + budget + ", Category: " + category,
                response));

        return response;
    }
}