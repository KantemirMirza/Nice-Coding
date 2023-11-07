package com.example.nicecoding.fleet.service;

import com.example.nicecoding.fleet.model.Vehicle;
import com.example.nicecoding.fleet.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {
	private final VehicleRepository vehicleRepository;
	
	//Get All Vehicles
	public List<Vehicle> listOfVehicles() {
		return vehicleRepository.findAll();
	}
	
	//Get Vehicle By Id
	public Vehicle findVehicleById(int id) {
		return vehicleRepository.findById(id).orElse(null);
	}	
	
	//Delete Vehicle
	public void deleteVehicle(Vehicle vehicle) {
		vehicleRepository.delete(vehicle);
	}
	
	//Update Vehicle
	public void saveVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
}
