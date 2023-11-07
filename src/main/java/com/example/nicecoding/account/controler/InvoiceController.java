package com.example.nicecoding.account.controler;

import com.example.nicecoding.account.model.Invoice;
import com.example.nicecoding.account.service.InvoiceService;
import com.example.nicecoding.parameter.model.Client;
import com.example.nicecoding.parameter.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class InvoiceController {
	private final InvoiceService invoiceService;
	private final ClientService clientService;

	@GetMapping("/invoices")
	public String listOfInvoice(Model model){
		List<Invoice> invoice = invoiceService.listOfInvoice();
		model.addAttribute("listOfInvoice", invoice);
		return"account/invoice/listOfInvoices";
	}

	@GetMapping("/addInvoice")
	public String addInvoice(Model model){
		List<Client> client = clientService.listOfClient();
		model.addAttribute("listOfClient", client);
		return"account/invoice/addInvoice";
	}

	@PostMapping("/addInvoice")
	public String saveInvoice(@ModelAttribute Invoice invoice){
		invoiceService.saveInvoice(invoice);
		return"redirect:/invoices";
	}

	@GetMapping("/invoices/{id}/edit")
	public String editInvoice(@PathVariable Integer id, Model model) {
		Invoice invoice = invoiceService.findInvoiceById(id);
		model.addAttribute("invoice", invoice);

		List<Client> client = clientService.listOfClient();
		model.addAttribute("listOfClient", client);
		return "account/invoice/editInvoice";
	}

	@PostMapping("/invoices/{id}/edit")
	public String updateInvoice(@PathVariable Integer id, @ModelAttribute("invoice") Invoice invoice) {
		Invoice in = invoiceService.findInvoiceById(id);
		in.setInvoiceDate(invoice.getInvoiceDate());
		in.setClient(invoice.getClient());
		in.setRemarks(invoice.getRemarks());
		invoiceService.saveInvoice(in);
		return "redirect:/invoices";
	}

	@GetMapping("/invoices/{id}/delete")
	public String deleteInvoice(@PathVariable Integer id){
		Invoice in = invoiceService.findInvoiceById(id);
		invoiceService.deleteInvoice(in);
		return"redirect:/invoices";
	}

	@GetMapping("/invoices/{id}/info")
	public String infoInvoice(Model model, @PathVariable Integer id){
		Invoice in = invoiceService.findInvoiceById(id);
		model.addAttribute("infoInvoice", in);

		List<Client> client = clientService.listOfClient();
		model.addAttribute("listOfClient", client);
		return"account/invoice/infoInvoice";
	}
}
