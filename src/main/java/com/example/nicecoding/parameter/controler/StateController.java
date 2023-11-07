package com.example.nicecoding.parameter.controler;

import com.example.nicecoding.parameter.model.Country;
import com.example.nicecoding.parameter.model.State;
import com.example.nicecoding.parameter.service.CountryService;
import com.example.nicecoding.parameter.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StateController {
	private final StateService stateService;
	private final CountryService countryService;

	@GetMapping("/states")
	public String listOfState(Model model){
		List<State> states = stateService.listOfState();
		model.addAttribute("listOfSate", states);
		return"parameter/state/listOfState";
	}

	@GetMapping("/addState")
	public String addState(Model model){
		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);
		return"parameter/state/addState";
	}

	@PostMapping("/addState")
	public String saveState(@ModelAttribute State state){
		stateService.saveState(state);
		return"redirect:/states";
	}

	@GetMapping("/states/{id}/edit")
	public String editState(@PathVariable Integer id, Model model) {
		State state = stateService.findStateById(id);
		model.addAttribute("state", state);
		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);
		return "parameter/state/editState";
	}

	@PostMapping("/states/{id}/edit")
	public String updateState(@PathVariable Integer id, @ModelAttribute("state") State updatedState) {
		State state = stateService.findStateById(id);
		state.setName(updatedState.getName());
		state.setCapital(updatedState.getCapital());
		state.setCode(updatedState.getCode());
		state.setCountry(updatedState.getCountry());
		state.setDetails(updatedState.getDetails());
		stateService.saveState(state);
		return "redirect:/states";
	}

	@GetMapping("/states/{id}/delete")
	public String deleteState(@PathVariable Integer id){
		State state = stateService.findStateById(id);
		stateService.deleteState(state);
		return"redirect:/states";
	}

	@GetMapping("/states/{id}/info")
	public String getInfoState(Model model, @PathVariable Integer id){
		State infoState = stateService.findStateById(id);
		model.addAttribute("infoState", infoState);
		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);
		return"parameter/state/infoState";
	}
}
