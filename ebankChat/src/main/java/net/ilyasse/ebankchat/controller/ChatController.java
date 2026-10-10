
package net.ilyasse.ebankchat.controller;

import net.ilyasse.ebankchat.agents.EbankAIAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private EbankAIAgent ebankAIAgent;

    @GetMapping
    public String chat(
            @RequestParam(name = "question",
                    defaultValue = "What is a Spring Framework?")
            String request,

            @RequestParam(name = "conversationId",
                    defaultValue = "conversation-1")
            String conversationId) {

        return ebankAIAgent.chat(request,conversationId);
    }
}