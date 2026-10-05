package net.ilyasse.ebankservice.controller;

import lombok.RequiredArgsConstructor;
import net.ilyasse.ebankservice.entity.BankAccount;
import net.ilyasse.ebankservice.service.EbankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class BankAccountController {
    private final EbankService ebankService;
    @GetMapping
    public List<BankAccount> getAllAccount(){
        return ebankService.getAllBankAccount();
    }
    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable UUID id){
        return ebankService.getBankAccountById(id);
    }
    @GetMapping("/customer/{customerId}")
    public List<BankAccount> getAllAccountByIdCoustomer(@PathVariable UUID customerId){
        return ebankService.getAllBankAccountByIdCustomer(customerId);
    }
    @PostMapping
    public BankAccount addAccount(@RequestBody BankAccount bankAccount){
        return ebankService.saveBankAccount(bankAccount);
    }


}
