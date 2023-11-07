package com.example.nicecoding.fleet.service;

import com.example.nicecoding.fleet.model.VehicleMaintenance;
import com.example.nicecoding.fleet.repository.VehicleMaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleMaintenanceService {
	private final VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
	//Get All VehicleMaintenances
	public List<VehicleMaintenance> listOfMaintenance() {
		return vehicleMaintenanceRepository.findAll();
	}
	public VehicleMaintenance findMaintenanceById(int id) {
		return vehicleMaintenanceRepository.findById(id).orElse(null);
	}	
	
	//Delete VehicleMaintenance
	public void deleteMaintenance(VehicleMaintenance maintenance) {
		vehicleMaintenanceRepository.delete(maintenance);
	}
	
	//Update VehicleMaintenance
	public void saveMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}

}
