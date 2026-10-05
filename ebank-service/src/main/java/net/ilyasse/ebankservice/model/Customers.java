package net.ilyasse.ebankservice.model;

import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.UUID;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Customers {
    private UUID id;
    private String email;
    private String name;
}
