package com.example.nicecoding.account.service;

import com.example.nicecoding.account.model.Invoice;
import com.example.nicecoding.account.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {
	private final InvoiceRepository invoiceRepository;
	
	//Get All Invoices
	public List<Invoice> listOfInvoice() {
		return invoiceRepository.findAll();
	}
	
	//Get Invoice By Id
	public Invoice findInvoiceById(int id) {
		return invoiceRepository.findById(id).orElse(null);
	}
	
	//Update Invoice
	public void saveInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	//Delete Invoice
    public void deleteInvoice(Invoice in) {
		invoiceRepository.delete(in);
    }

}
