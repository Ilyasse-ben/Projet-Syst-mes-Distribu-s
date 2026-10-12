package net.ilyasse.ebankservice.dto;

import jakarta.websocket.server.ServerEndpoint;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Getter @Setter
public class AccountDto {
    private double balance;
    private String type;
    private UUID customerId;
}
