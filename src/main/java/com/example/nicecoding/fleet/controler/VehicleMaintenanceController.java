package com.example.nicecoding.fleet.controler;

import com.example.nicecoding.fleet.model.Vehicle;
import com.example.nicecoding.fleet.model.VehicleMaintenance;
import com.example.nicecoding.fleet.service.VehicleMaintenanceService;
import com.example.nicecoding.fleet.service.VehicleService;
import com.example.nicecoding.parameter.model.Supplier;
import com.example.nicecoding.parameter.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VehicleMaintenanceController {
	private final VehicleMaintenanceService vehicleMaintenanceService;
	private final VehicleService vehicleService;
	 private final SupplierService supplierService;

	@GetMapping("/maintenances")
	public String listOfMaintenance(Model model){
		List<VehicleMaintenance> maintenance = vehicleMaintenanceService.listOfMaintenance();
		model.addAttribute("listOfMaintenance", maintenance);
		return"fleet/maintenance/listOfMaintenance";
	}

	@GetMapping("/addMaintenance")
	public String addMaintenance(Model model){

		List<Vehicle> vehicle = vehicleService.listOfVehicles();
		model.addAttribute("listOfVehicle", vehicle);

		List<Supplier> supplier = supplierService.listOfSupplier();
		model.addAttribute("listOfSupplier", supplier);

		return"fleet/maintenance/addMaintenance";
	}

	@PostMapping("/addMaintenance")
	public String saveMaintenance(@ModelAttribute VehicleMaintenance maintenance ){
		vehicleMaintenanceService.saveMaintenance(maintenance);
		return"redirect:/maintenances";
	}

	@GetMapping("/maintenances/{id}/edit")
	public String editMaintenance(@PathVariable Integer id, Model model) {
		VehicleMaintenance maintenance = vehicleMaintenanceService.findMaintenanceById(id);
		model.addAttribute("maintenance", maintenance);

		List<Vehicle> vehicle = vehicleService.listOfVehicles();
		model.addAttribute("listOfVehicle", vehicle);

		List<Supplier> supplier = supplierService.listOfSupplier();
		model.addAttribute("listOfSupplier", supplier);

		return "fleet/maintenance/editMaintenance";
	}

	@PostMapping("/maintenances/{id}/edit")
	public String updateMovement(@PathVariable Integer id, @ModelAttribute("maintenance") VehicleMaintenance maintenance) {
		VehicleMaintenance main = vehicleMaintenanceService.findMaintenanceById(id);
		main.setVehicle(maintenance.getVehicle());
		main.setStartDate(maintenance.getStartDate());
		main.setEndDate(maintenance.getEndDate());
		main.setPrice(maintenance.getPrice());
		main.setSupplier(maintenance.getSupplier());
		main.setRemarks(maintenance.getRemarks());
		vehicleMaintenanceService.saveMaintenance(main);
		return "redirect:/maintenances";
	}

	@GetMapping("/maintenances/{id}/delete")
	public String deleteMaintenance(@PathVariable Integer id){
		VehicleMaintenance main = vehicleMaintenanceService.findMaintenanceById(id);
		vehicleMaintenanceService.deleteMaintenance(main);
		return"redirect:/maintenances";
	}

	@GetMapping("/maintenances/{id}/info")
	public String infoMaintenance(Model model, @PathVariable Integer id){
		VehicleMaintenance main = vehicleMaintenanceService.findMaintenanceById(id);
		model.addAttribute("infoMaintenance", main);

		List<Vehicle> vehicle = vehicleService.listOfVehicles();
		model.addAttribute("listOfVehicle", vehicle);

		List<Supplier> supplier = supplierService.listOfSupplier();
		model.addAttribute("listOfSupplier", supplier);
		return"fleet/maintenance/infoMaintenance";
	}
}
