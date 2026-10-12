package net.ilyasse.ebankchat.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Service
public class EbankAIAgent {
    private final ChatClient chatClient;

    public EbankAIAgent(
            ChatClient.Builder client,
            ChatMemory chatMemory,
            ToolCallbackProvider tools) {

        this.chatClient = client
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build()
                )
                .defaultTools(tools)
                .build();
    }

    public String chat(String request, String conversationId) {

        return chatClient.prompt()
                .user(request)
                .advisors(advisorSpec -> advisorSpec
                        .param(ChatMemory.CONVERSATION_ID, conversationId))
                .call()
                .content();
    }
}
