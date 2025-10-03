package com.example.demo.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.TransferDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

	@Autowired
    private AccountRepository accountRepo;
	
	@Autowired
    private TransactionRepository txRepo;
	
	@Autowired
    private AccountMapper mapper;

    public Account createAccount(AccountDTO dto) {
        return accountRepo.save(mapper.toAccount(dto));
    }

    @Transactional
    public String transferMoney(TransferDTO dto) {
        Account from = accountRepo.findById(dto.getFromId())
                .orElseThrow(() -> new ResourceNotFoundException("Sender not found"));
        Account to = accountRepo.findById(dto.getToId())
                .orElseThrow(() -> new ResourceNotFoundException("Receiver not found"));

        if (from.getBalance() < dto.getAmount())
            throw new RuntimeException("Insufficient balance");

        from.setBalance(from.getBalance() - dto.getAmount());
        to.setBalance(to.getBalance() + dto.getAmount());

        accountRepo.save(from);
        accountRepo.save(to);

        Transaction tx = mapper.toTransaction(dto);
        txRepo.save(tx);

        return "Transferred " + dto.getAmount() + " from " + from.getAccountName() +
                " to " + to.getAccountName();
    }

    public List<Account> getAllAccounts(){ 
    	return accountRepo.findAll(); 
    	}

    public List<Transaction> getAllTransactions(){ 
    	return txRepo.findAll();
    	}
}
