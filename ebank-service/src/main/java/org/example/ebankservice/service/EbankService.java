package org.example.ebankservice.service;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.example.ebankservice.entities.BankAccount;
import org.example.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class EbankService {
    private BankAccountRepository accountRepository;

    public EbankService(BankAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<BankAccount> getAllBankAccount(){
        return accountRepository.findAll();
    }

    public BankAccount getBankAccountById(String id){
      return accountRepository.findById(id)
              .orElseThrow(()->new RuntimeException("Account Not Found"));
    };

    public BankAccount save(BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return accountRepository.save(bankAccount);
    }
}
