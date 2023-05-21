package com.eddamghi.bankserviceapplication;

import com.eddamghi.bankserviceapplication.entities.Account;
import com.eddamghi.bankserviceapplication.enums.AccountType;
import com.eddamghi.bankserviceapplication.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountRepository accountRepository){
        return args -> {
            for(int i=0;i<10;i++){
                Account account = Account.builder()
                        .id(i)
                        .accountNumber(UUID.randomUUID().toString())
                        .balance(10000 + Math.random() * 10000)
                        .currency("MAD")
                        .createdAt(new Date())
                        .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                        .build();
                accountRepository.save(account);
            }
        };
    }

}
