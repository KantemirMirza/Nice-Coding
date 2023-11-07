package com.example.nicecoding.parameter.controler;

import com.example.nicecoding.parameter.model.Contact;
import com.example.nicecoding.parameter.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContactController {
	private final ContactService contactService;

	@GetMapping("/contacts")
	public String listOfContact(Model model){
		List<Contact> contacts =   contactService.listOfContact();
		model.addAttribute("listOfContact", contacts);
		return "/parameter/contact/listOfContact";
	}

	@GetMapping("/addContact")
	public String addContact(){
		return"parameter/contact/addContact";
	}

	@PostMapping("/addContact")
	public String saveContact(@ModelAttribute Contact contact){
		contactService.saveContact(contact);
		return"redirect:/contacts";
	}

	@GetMapping("/contacts/{id}/edit")
	public String editContact(@PathVariable Integer id, Model model) {
		Contact contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "parameter/contact/editContact";
	}

	@PostMapping("/contacts/{id}/edit")
	public String updateContact(@PathVariable Integer id, @ModelAttribute("contact") Contact contact) {
		Contact cont = contactService.findContactById(id);
		cont.setFirstname(contact.getFirstname());
		cont.setLastname(contact.getLastname());
		cont.setPhone(contact.getPhone());
		cont.setEmail(contact.getEmail());
		cont.setMobile(contact.getMobile());
		cont.setRemarks(contact.getRemarks());
		contactService.saveContact(cont);
		return "redirect:/contacts";
	}

	@GetMapping("/contacts/{id}/delete")
	public String deleteContact(@PathVariable Integer id){
		Contact contact = contactService.findContactById(id);
		contactService.deleteContact(contact);
		return"redirect:/contacts";
	}

	@GetMapping("/contacts/{id}/info")
	public String infoContact(Model model, @PathVariable Integer id){
		Contact infoContact = contactService.findContactById(id);
		model.addAttribute("infoContact", infoContact);
		return"parameter/contact/infoContact";
	}
}
