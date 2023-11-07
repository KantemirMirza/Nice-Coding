package com.example.nicecoding.parameter.controler;
import com.example.nicecoding.parameter.model.Country;
import com.example.nicecoding.parameter.model.Location;
import com.example.nicecoding.parameter.model.State;
import com.example.nicecoding.parameter.service.CountryService;
import com.example.nicecoding.parameter.service.LocationService;
import com.example.nicecoding.parameter.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LocationController {

	private final LocationService locationService;
	private final CountryService countryService;
	private final StateService stateService;

	@GetMapping("/locations")
	public String listOfLocation(Model model){
		List<Location> locations = locationService.listOfLocation();
		model.addAttribute("listOfLocation", locations);
		return"parameter/location/listOfLocation";
	}

	@GetMapping("/addLocation")
	public String addLocation(Model model){
		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);
		return"parameter/location/addLocation";
	}

	@PostMapping("/addLocation")
	public String saveLocation(@ModelAttribute Location location){
		locationService.saveLocation(location);
		return"redirect:/locations";
	}

	@GetMapping("/locations/{id}/edit")
	public String editLocation(@PathVariable Integer id, Model model) {
		Location location = locationService.findLocationById(id);
		model.addAttribute("location", location);

		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);
		return "parameter/location/editLocation";
	}

	@PostMapping("/locations/{id}/edit")
	public String updateLocation(@PathVariable Integer id, @ModelAttribute("location") Location loc) {
		Location location = locationService.findLocationById(id);
		location.setDescription(loc.getDescription());
		location.setDetails(loc.getDetails());
		location.setCountry(loc.getCountry());
		location.setState(loc.getState());
		location.setAddress(loc.getAddress());
		locationService.saveLocation(location);
		return "redirect:/locations";
	}

	@GetMapping("/locations/{id}/delete")
	public String deleteLocation(@PathVariable Integer id){
		Location location = locationService.findLocationById(id);
		locationService.deleteLocation(location);
		return"redirect:/locations";
	}

	@GetMapping("/locations/{id}/info")
	public String infoLocation(Model model, @PathVariable Integer id){
		Location infoLocation = locationService.findLocationById(id);
		model.addAttribute("infoLocation", infoLocation);

		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);
		return"parameter/location/infoLocation";
	}
}
