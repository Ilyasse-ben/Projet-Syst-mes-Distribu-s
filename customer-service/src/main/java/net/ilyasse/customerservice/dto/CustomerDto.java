package net.ilyasse.customerservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class CustomerDto {
    private String name;
    private String email;
}
