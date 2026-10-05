package net.ilyasse.ebankservice.entity;

import jakarta.persistence.*;
import lombok.*;
import net.ilyasse.ebankservice.model.Customers;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Date createdAt;
    private double balance;
    private String type;
    private UUID customerId;
    @Transient
    private Customers customers;
}
