package net.ilyasse.ebankservice.service;

import net.ilyasse.ebankservice.entity.BankAccount;
import net.ilyasse.ebankservice.feign.CustomerRestClient;
import net.ilyasse.ebankservice.model.Customers;
import net.ilyasse.ebankservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private CustomerRestClient client;

    public List<BankAccount> getAllBankAccount(){
        return bankAccountRepository.findAll();
    }
    public BankAccount getBankAccountById(UUID id){
        BankAccount bankAccount=bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Bank Account not find"));
        bankAccount.setCustomers(client.getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }
    public BankAccount saveBankAccount(BankAccount bankAccount){
        try {
            Customers customers=client.getCustomerById(bankAccount.getId());
            bankAccount.setCreatedAt(new Date());
            return bankAccountRepository.save(bankAccount);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    public List<BankAccount> getAllBankAccountByIdCustomer(UUID customerId){
        return bankAccountRepository.findByCustomerId(customerId);

    }

}
