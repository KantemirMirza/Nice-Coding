package com.example.nicecoding.account.service;

import com.example.nicecoding.account.model.Transaction;
import com.example.nicecoding.account.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    //Get All Transactions
    public List<Transaction> listOfTransaction() {
        return transactionRepository.findAll();
    }

    //Get Transaction By Id
    public Transaction findTransactionById(int id) {
        return transactionRepository.findById(id).orElse(null);
    }

    //Delete Transaction
    public void deleteTransaction(Transaction transaction) {
        transactionRepository.delete(transaction);
    }

    //Save Transaction
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

}
