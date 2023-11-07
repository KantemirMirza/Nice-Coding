package com.example.nicecoding.parameter.controler;

import com.example.nicecoding.parameter.model.Client;
import com.example.nicecoding.parameter.model.Country;
import com.example.nicecoding.parameter.model.State;
import com.example.nicecoding.parameter.service.ClientService;
import com.example.nicecoding.parameter.service.CountryService;
import com.example.nicecoding.parameter.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientController {

	private final ClientService clientService;
	private final CountryService countryService;
	private final StateService stateService;


	@GetMapping("/clients")
	public String listOfClient(Model model){
		List<Client> clients = clientService.listOfClient();
		model.addAttribute("listOfClient", clients);
		return"parameter/client/listOfClient";
	}

	@GetMapping("/addClient")
	public String addClient(Model model){
		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);
		return"parameter/client/addClient";
	}

	@PostMapping("/addClient")
	public String saveClient(@ModelAttribute Client client){
		clientService.saveClient(client);
		return"redirect:/clients";
	}

	@GetMapping("/clients/{id}/edit")
	public String editClient(@PathVariable Integer id, Model model) {
		Client client = clientService.findClientById(id);
		model.addAttribute("client", client);

		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);
		return "parameter/client/editClient";
	}

	@PostMapping("/clients/{id}/edit")
	public String updateClient(@PathVariable Integer id, @ModelAttribute("client") Client cl) {
		Client client = clientService.findClientById(id);
		client.setName(cl.getName());
		client.setAddress(cl.getAddress());
		client.setCity(cl.getCity());
		client.setPhone(cl.getPhone());
		client.setWebsite(cl.getWebsite());
		client.setEmail(cl.getEmail());
		client.setCountry(cl.getCountry());
		client.setState(cl.getState());
		clientService.saveClient(client);
		return "redirect:/clients";
	}

	@GetMapping("/clients/{id}/delete")
	public String deleteClient(@PathVariable Integer id){
		Client client = clientService.findClientById(id);
		clientService.deleteClient(client);
		return"redirect:/clients";
	}

	@GetMapping("/clients/{id}/info")
	public String infoClient(Model model, @PathVariable Integer id){
		Client infoClient = clientService.findClientById(id);
		model.addAttribute("infoClient", infoClient);

		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);
		return"parameter/client/infoClient";
	}
}
