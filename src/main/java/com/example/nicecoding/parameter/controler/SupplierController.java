package com.example.nicecoding.parameter.controler;

import com.example.nicecoding.parameter.model.*;
import com.example.nicecoding.parameter.service.CountryService;
import com.example.nicecoding.parameter.service.StateService;
import com.example.nicecoding.parameter.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SupplierController {

	private final SupplierService supplierService;
	private final CountryService countryService;
	private final StateService stateService;


	@GetMapping("/suppliers")
	public String listOfSupplier(Model model){
		List<Supplier> suppliers = supplierService.listOfSupplier();
		model.addAttribute("listOfSupplier", suppliers);
		return"parameter/supplier/listOfSupplier";
	}

	@GetMapping("/addSupplier")
	public String addSupplier(Model model){
		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);
		return"parameter/supplier/addSupplier";
	}

	@PostMapping("/addSupplier")
	public String saveSupplier(@ModelAttribute Supplier supplier){
		supplierService.saveSupplier(supplier);
		return"redirect:/suppliers";
	}

	@GetMapping("/suppliers/{id}/edit")
	public String editSupplier(@PathVariable Integer id, Model model) {
		Supplier supplier = supplierService.findSupplierById(id);
		model.addAttribute("supplier", supplier);

		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);
		return "parameter/supplier/editSupplier";
	}

	@PostMapping("/suppliers/{id}/edit")
	public String updateSupplier(@PathVariable Integer id, @ModelAttribute("supplier") Supplier supp) {
		Supplier supplier = supplierService.findSupplierById(id);
		supplier.setName(supp.getName());
		supplier.setAddress(supp.getAddress());
		supplier.setCity(supp.getCity());
		supplier.setPhone(supp.getPhone());
		supplier.setWebsite(supp.getWebsite());
		supplier.setEmail(supp.getEmail());
		supplier.setCountry(supp.getCountry());
		supplier.setState(supp.getState());
		supplierService.saveSupplier(supplier);
		return "redirect:/suppliers";
	}

	@GetMapping("/suppliers/{id}/delete")
	public String deleteSupplier(@PathVariable Integer id){
		Supplier supplier = supplierService.findSupplierById(id);
		supplierService.deleteSupplier(supplier);
		return"redirect:/suppliers";
	}

	@GetMapping("/suppliers/{id}/info")
	public String infoSupplier(Model model, @PathVariable Integer id){
		Supplier infoSupplier = supplierService.findSupplierById(id);
		model.addAttribute("infoSupplier", infoSupplier);

		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);
		return"parameter/supplier/infoSupplier";
	}
}
