package com.example.nicecoding.fleet.controler;

import com.example.nicecoding.fleet.model.Vehicle;
import com.example.nicecoding.fleet.model.VehicleHire;
import com.example.nicecoding.fleet.service.VehicleHireService;
import com.example.nicecoding.fleet.service.VehicleService;
import com.example.nicecoding.parameter.model.Client;
import com.example.nicecoding.parameter.model.Location;
import com.example.nicecoding.parameter.service.ClientService;
import com.example.nicecoding.parameter.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VehicleHireController {
	private final VehicleHireService vehicleHireService;
	private final ClientService clientService;
	private final LocationService locationService;
	private final VehicleService vehicleService;

	@GetMapping("/hires")
	public String listOfHire(Model model){
		List<VehicleHire> hire = vehicleHireService.listOfHire();
		model.addAttribute("listOfHire", hire);
		return"fleet/hire/listOfHire";
	}

	@GetMapping("/addHire")
	public String addHire(Model model){

		List<Client> client = clientService.listOfClient();
		model.addAttribute("listOfClient", client);

		List<Location> location = locationService.listOfLocation();
		model.addAttribute("listOfLocation", location);

		List<Vehicle> vehicle = vehicleService.listOfVehicles();
		model.addAttribute("listOfVehicle", vehicle);

		return"fleet/hire/addHire";
	}

	@PostMapping("/addHire")
	public String saveHire(@ModelAttribute VehicleHire hire ){
		vehicleHireService.saveHire(hire);
		return"redirect:/hires";
	}

	@GetMapping("/hires/{id}/edit")
	public String editHire(@PathVariable Integer id, Model model) {
		VehicleHire hire = vehicleHireService.findHireById(id);
		model.addAttribute("hire", hire);

		List<Client> client = clientService.listOfClient();
		model.addAttribute("listOfClient", client);

		List<Location> location = locationService.listOfLocation();
		model.addAttribute("listOfLocation", location);

		List<Vehicle> vehicle = vehicleService.listOfVehicles();
		model.addAttribute("listOfVehicle", vehicle);

		return "fleet/hire/editHire";
	}

	@PostMapping("/hires/{id}/edit")
	public String updateHire(@PathVariable Integer id, @ModelAttribute("hire") VehicleHire hire) {
		VehicleHire veh = vehicleHireService.findHireById(id);
		veh.setVehicle(hire.getVehicle());
		veh.setDateOut(hire.getDateOut());
		veh.setTimeOut(hire.getTimeOut());
		veh.setDateIn(hire.getDateIn());
		veh.setTimeIn(hire.getTimeIn());
		veh.setClient(hire.getClient());
		veh.setLocation(hire.getLocation());
		veh.setPrice(hire.getPrice());
		vehicleHireService.saveHire(veh);
		return "redirect:/hires";
	}

	@GetMapping("/hires/{id}/delete")
	public String deleteHire(@PathVariable Integer id){
		VehicleHire hire = vehicleHireService.findHireById(id);
		vehicleHireService.deleteHire(hire);
		return"redirect:/hires";
	}

	@GetMapping("/hires/{id}/info")
	public String infoHire(Model model, @PathVariable Integer id){
		VehicleHire hire = vehicleHireService.findHireById(id);
		model.addAttribute("infoHire", hire);

		List<Client> client = clientService.listOfClient();
		model.addAttribute("listOfClient", client);

		List<Location> location = locationService.listOfLocation();
		model.addAttribute("listOfLocation", location);

		List<Vehicle> vehicle = vehicleService.listOfVehicles();
		model.addAttribute("listOfVehicle", vehicle);

		return"fleet/hire/infoHire";
	}

}
