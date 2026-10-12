package net.ilyasse.ebankservice.service;

import net.ilyasse.ebankservice.dto.AccountDto;
import net.ilyasse.ebankservice.entity.BankAccount;
import net.ilyasse.ebankservice.feign.CustomerRestClient;
import net.ilyasse.ebankservice.model.Customers;
import net.ilyasse.ebankservice.repository.BankAccountRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
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
    @McpTool(description = "donner tous les comptes bankaire")
    public List<BankAccount> getAllBankAccount(){
        return bankAccountRepository.findAll();
    }
    @McpTool(description = "donner un compte banckaires par id")
    public BankAccount getBankAccountById(@McpToolParam(description = "L'id de compte banckaire") UUID id){
        BankAccount bankAccount=bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Bank Account not find"));
        bankAccount.setCustomers(client.getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }
    @McpTool(description = "Ajouter un compte banckaire")
    public BankAccount saveBankAccount(@McpToolParam(description = "le compte bancaire a ajouter (balance type customerId)") AccountDto accountDto){
        try {
            Customers customers=client.getCustomerById(accountDto.getCustomerId());
            BankAccount bankAccount=BankAccount.builder().createdAt(new Date()).balance(accountDto.getBalance()).type(accountDto.getType()).customers(customers).customerId(accountDto.getCustomerId()).build();
            return bankAccountRepository.save(bankAccount);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    @McpTool(description = "donner tous les comptes banckaire associer a un utilisateur")
    public List<BankAccount> getAllBankAccountByIdCustomer(@McpToolParam(description = "L'id de l'utilisateur") UUID customerId){
        return bankAccountRepository.findByCustomerId(customerId);

    }

}
