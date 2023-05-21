package com.eddamghi.bankserviceapplication.repositories;

import com.eddamghi.bankserviceapplication.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByAccountNumber(String accountNumber);
}
