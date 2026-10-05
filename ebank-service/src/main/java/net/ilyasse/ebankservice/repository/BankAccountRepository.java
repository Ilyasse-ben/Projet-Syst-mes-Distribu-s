package net.ilyasse.ebankservice.repository;

import net.ilyasse.ebankservice.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {

    List<BankAccount> findByCustomerId(UUID id);
}
