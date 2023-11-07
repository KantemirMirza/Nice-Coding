package com.example.nicecoding.fleet.controler;

import com.example.nicecoding.fleet.model.Vehicle;
import com.example.nicecoding.fleet.service.*;
import com.example.nicecoding.hr.model.Employee;
import com.example.nicecoding.hr.service.EmployeeService;
import com.example.nicecoding.parameter.model.Location;
import com.example.nicecoding.parameter.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VehicleController {
	private final VehicleService vehicleService;
	private final LocationService locationService;
	private final EmployeeService employeeService ;

	@GetMapping("/vehicles")
	public String listOfVehicle(Model model){
		List<Vehicle> vehicle = vehicleService.listOfVehicles();
		model.addAttribute("listOfVehicle", vehicle);
		return"fleet/vehicle/listOfVehicle";
	}

	@GetMapping("/addVehicle")
	public String addVehicle(Model model){
		List<Location> location = locationService.listOfLocation();
		model.addAttribute("listOfLocation", location);

		List<Employee> employee = employeeService.listOfEmployee();
		model.addAttribute("listOfEmployee", employee);
		return"fleet/vehicle/addVehicle";
	}

	@PostMapping("/addVehicle")
	public String saveVehicle(@ModelAttribute Vehicle vehicle ){
		vehicleService.saveVehicle(vehicle);
		return"redirect:/vehicles";
	}

	@GetMapping("/vehicles/{id}/edit")
	public String editVehicle(@PathVariable Integer id, Model model) {
		Vehicle vehicle = vehicleService.findVehicleById(id);
		model.addAttribute("vehicle", vehicle);

		List<Location> location = locationService.listOfLocation();
		model.addAttribute("listOfLocation", location);

		List<Employee> employee = employeeService.listOfEmployee();
		model.addAttribute("listOfEmployee", employee);
		return "fleet/vehicle/editVehicle";
	}

	@PostMapping("/vehicles/{id}/edit")
	public String updateVehicle(@PathVariable Integer id, @ModelAttribute("vehicle") Vehicle vehicle) {
		Vehicle veh = vehicleService.findVehicleById(id);
		veh.setName(vehicle.getName());
		veh.setVehicleNumber(vehicle.getVehicleNumber());
		veh.setRegistrationDate(vehicle.getRegistrationDate());
		veh.setDescription(vehicle.getDescription());
		veh.setPower(vehicle.getPower());
		veh.setFuelCapacity(vehicle.getFuelCapacity());
		veh.setNetWeight(vehicle.getNetWeight());
		veh.setInCharge(vehicle.getInCharge());
		veh.setCurrentLocation(vehicle.getCurrentLocation());
		vehicleService.saveVehicle(veh);
		return "redirect:/vehicles";
	}

	@GetMapping("/vehicles/{id}/delete")
	public String deleteVehicle(@PathVariable Integer id){
		Vehicle vehicle = vehicleService.findVehicleById(id);
		vehicleService.deleteVehicle(vehicle);
		return"redirect:/vehicles";
	}

	@GetMapping("/vehicles/{id}/info")
	public String infoVehicle(Model model, @PathVariable Integer id){
		Vehicle vehicle = vehicleService.findVehicleById(id);
		model.addAttribute("infoVehicle", vehicle);

		List<Location> location = locationService.listOfLocation();
		model.addAttribute("listOfLocation", location);

		List<Employee> employee = employeeService.listOfEmployee();
		model.addAttribute("listOfEmployee", employee);

		return"fleet/vehicle/infoVehicle";
	}
}
