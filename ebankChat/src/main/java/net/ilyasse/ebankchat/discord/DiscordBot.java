package net.ilyasse.ebankchat.discord;

import com.zgamelogic.discord.annotations.DiscordController;
import com.zgamelogic.discord.annotations.DiscordMapping;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.ilyasse.ebankchat.agents.EbankAIAgent;
import org.springframework.beans.factory.annotation.Autowired;

@DiscordController
public class DiscordBot {
    @Autowired
    private EbankAIAgent ebankAIAgent;
    private final String conversationid="conversation-1";

    @DiscordMapping
    private void perform(MessageReceivedEvent event) {
        System.out.println(event);
        if (event.getAuthor().isBot()) return;

        String query = event.getMessage().getContentRaw();

        // Modification : passer directement la chaîne de caractères si la méthode attend un String
        String response = ebankAIAgent.chat(query,conversationid);

        event.getChannel().sendMessage(response).queue();
    }
}
