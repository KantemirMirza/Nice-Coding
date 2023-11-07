//package com.example.nicecoding.fleet.controler;
//
//import com.example.nicecoding.fleet.model.Vehicle;
//import com.example.nicecoding.fleet.model.VehicleMovement;
//import com.example.nicecoding.fleet.service.VehicleMovementService;
//import com.example.nicecoding.fleet.service.VehicleService;
//import com.example.nicecoding.parameter.model.Location;
//import com.example.nicecoding.parameter.service.LocationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class VehicleMovementController {
//	private final VehicleMovementService vehicleMovementService;
//	private final LocationService locationService;
//	private final VehicleService vehicleService;
//
//	@GetMapping("/movements")
//	public String listOfMovement(Model model){
//		List<VehicleMovement> movement = vehicleMovementService.listOfMovement();
//		model.addAttribute("listOfMovement", movement);
//		return"fleet/movement/listOfMovement";
//	}
//
//	@GetMapping("/addMovement")
//	public String addMovement(Model model){
//
//		List<Location> location = locationService.listOfLocation();
//		model.addAttribute("listOfLocation", location);
//
//		List<Vehicle> vehicle = vehicleService.listOfVehicles();
//		model.addAttribute("listOfVehicle", vehicle);
//
//		return"fleet/movement/addMovement";
//	}
//
//	@PostMapping("/addMovement")
//	public String saveMovement(@ModelAttribute VehicleMovement movement ){
//		vehicleMovementService.saveMovement(movement);
//		return"redirect:/movements";
//	}
//
//	@GetMapping("/movements/{id}/edit")
//	public String editMovement(@PathVariable Integer id, Model model) {
//		VehicleMovement movement = vehicleMovementService.findMovementById(id);
//		model.addAttribute("movement", movement);
//
//		List<Location> location = locationService.listOfLocation();
//		model.addAttribute("listOfLocation", location);
//
//		List<Vehicle> vehicle = vehicleService.listOfVehicles();
//		model.addAttribute("listOfVehicle", vehicle);
//
//		return "fleet/movement/editMovement";
//	}
//
//	@PostMapping("/movements/{id}/edit")
//	public String updateMovement(@PathVariable Integer id, @ModelAttribute("movement") VehicleMovement movement) {
//		VehicleMovement veh = vehicleMovementService.findMovementById(id);
//		veh.setVehicle(movement.getVehicle());
////		veh.setLocation1(movement.getLocation1());
//		veh.setDate1(movement.getDate1());
//		veh.setLocation2(movement.getLocation2());
//		veh.setDate2(movement.getDate2());
//		veh.setRemarks(movement.getRemarks());
//		vehicleMovementService.saveMovement(veh);
//		return "redirect:/movements";
//	}
//
//	@GetMapping("/movements/{id}/delete")
//	public String deleteMovement(@PathVariable Integer id){
//		VehicleMovement veh = vehicleMovementService.findMovementById(id);
//		vehicleMovementService.deleteMovement(veh);
//		return"redirect:/movements";
//	}
//
//	@GetMapping("/movements/{id}/info")
//	public String infoMovement(Model model, @PathVariable Integer id){
//		VehicleMovement movement = vehicleMovementService.findMovementById(id);
//		model.addAttribute("infoMovement", movement);
//
//		List<Location> location = locationService.listOfLocation();
//		model.addAttribute("listOfLocation", location);
//
//		List<Vehicle> vehicle = vehicleService.listOfVehicles();
//		model.addAttribute("listOfVehicle", vehicle);
//
//		return"fleet/movement/infoMovement";
//	}
//}
