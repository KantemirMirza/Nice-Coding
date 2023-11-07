package com.example.nicecoding.account.controler;

import com.example.nicecoding.account.model.Transaction;
import com.example.nicecoding.account.service.TransactionService;
import com.example.nicecoding.parameter.model.*;
import com.example.nicecoding.parameter.service.ClientService;
import com.example.nicecoding.parameter.service.ContactService;
import com.example.nicecoding.parameter.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final ContactService contactService;
    private final SupplierService supplierService;
    private final ClientService clientService;

    @GetMapping("/transactions")
    public String listOfTransaction(Model model){
        List<Transaction> transaction = transactionService.listOfTransaction();
        model.addAttribute("listOfTransaction", transaction);
        return"account/transaction/listOfTransaction";
    }

    @GetMapping("/addTransaction")
    public String addTransaction(Model model){
        List<Contact> contact = contactService.listOfContact();
        model.addAttribute("listOfContact", contact);

        List<Supplier> supplier = supplierService.listOfSupplier();
        model.addAttribute("listOfSupplier", supplier);

        List<Client> client = clientService.listOfClient();
        model.addAttribute("listOfClient", client);
        return"account/transaction/addTransaction";
    }

    @PostMapping("/addTransaction")
    public String saveTransaction(@ModelAttribute Transaction transaction){
        transactionService.saveTransaction(transaction);
        return"redirect:/transactions";
    }

    @GetMapping("/transactions/{id}/edit")
    public String editTransaction(@PathVariable Integer id, Model model) {
        Transaction transaction = transactionService.findTransactionById(id);
        model.addAttribute("transaction", transaction);

        List<Contact> contact = contactService.listOfContact();
        model.addAttribute("listOfContact", contact);

        List<Supplier> supplier = supplierService.listOfSupplier();
        model.addAttribute("listOfSupplier", supplier);

        List<Client> client = clientService.listOfClient();
        model.addAttribute("listOfClient", client);
        return "account/transaction/editTransaction";
    }

    @PostMapping("/transactions/{id}/edit")
    public String updateTransaction(@PathVariable Integer id, @ModelAttribute("transaction") Transaction transaction) {
        Transaction tr = transactionService.findTransactionById(id);
        tr.setAmount(transaction.getAmount());
        tr.setPurpose(transaction.getPurpose());
        tr.setTransactionDate(transaction.getTransactionDate());
        tr.setContact(transaction.getContact());
        tr.setSupplier(transaction.getSupplier());
        tr.setClient(transaction.getClient());
        tr.setRemarks(transaction.getRemarks());
       transactionService.saveTransaction(tr);
        return "redirect:/transactions";
    }

    @GetMapping("/transactions/{id}/delete")
    public String deleteTransaction(@PathVariable Integer id){
        Transaction tr = transactionService.findTransactionById(id);
       transactionService.deleteTransaction(tr);
        return"redirect:/transactions";
    }

    @GetMapping("/transactions/{id}/info")
    public String infoTransaction(Model model, @PathVariable Integer id){
        Transaction tr = transactionService.findTransactionById(id);
        model.addAttribute("infoTransaction", tr);

        List<Contact> contact = contactService.listOfContact();
        model.addAttribute("listOfContact", contact);

        List<Supplier> supplier = supplierService.listOfSupplier();
        model.addAttribute("listOfSupplier", supplier);

        List<Client> client = clientService.listOfClient();
        model.addAttribute("listOfClient", client);
        return"account/transaction/infoTransaction";
    }
}
