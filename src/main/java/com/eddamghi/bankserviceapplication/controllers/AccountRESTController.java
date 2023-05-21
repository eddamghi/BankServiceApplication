package com.eddamghi.bankserviceapplication.controllers;

import com.eddamghi.bankserviceapplication.entities.Account;
import com.eddamghi.bankserviceapplication.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRESTController {
    private AccountRepository accountRepository;
    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable int id){
        return accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found", id)));
    }
    @PostMapping("/accounts")
    public Account saveAccount(@RequestBody Account account){
        return accountRepository.save(account);
    }
    @PutMapping("/accounts/{id}")
    public Account updateAccount(@PathVariable int id, @RequestBody Account account){
        Account account1 = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found", id)));
        if(account.getBalance() != null)
            account1.setBalance(account.getBalance());
        if(account.getCurrency() != null)
            account1.setCurrency(account.getCurrency());
        if(account.getType() != null)
            account1.setType(account.getType());
        if(account.getAccountNumber() != null)
            account1.setAccountNumber(account.getAccountNumber());
        if(account.getCreatedAt() != null)
            account1.setCreatedAt(account.getCreatedAt());
        return accountRepository.save(account1);
    }
    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable int id){
        accountRepository.deleteById(id);
    }


}
