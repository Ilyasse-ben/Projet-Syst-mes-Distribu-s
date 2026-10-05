package net.ilyasse.ebankservice.service;

import net.ilyasse.ebankservice.entity.BankAccount;
import net.ilyasse.ebankservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EbankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public List<BankAccount> getAllBankAccount(){
        return bankAccountRepository.findAll();
    }
    public BankAccount getBankAccountById(UUID id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Bank Account not find"));
    }
    public BankAccount saveBankAccount(BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }
    public List<BankAccount> getAllBankAccountByIdCustomer(UUID customerId){
        return bankAccountRepository.findByCustomerId(customerId);

    }

}
