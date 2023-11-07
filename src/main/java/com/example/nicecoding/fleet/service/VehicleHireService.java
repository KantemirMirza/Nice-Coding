package com.example.nicecoding.fleet.service;

import com.example.nicecoding.fleet.model.VehicleHire;
import com.example.nicecoding.fleet.repository.VehicleHireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleHireService {

	private final VehicleHireRepository vehicleHireRepository;
	
	//Get All VehicleHires
	public List<VehicleHire> listOfHire() {
		return vehicleHireRepository.findAll();
	}
	
	//Get VehicleHire By Id
	public VehicleHire findHireById(int id) {
		return vehicleHireRepository.findById(id).orElse(null);
	}	
	
	//Delete VehicleHire
	public void deleteHire(VehicleHire hire) {
		vehicleHireRepository.delete(hire);
	}
	
	//Update VehicleHire
	public void saveHire(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}

}
