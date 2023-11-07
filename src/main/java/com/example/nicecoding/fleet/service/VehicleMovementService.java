//package com.example.nicecoding.fleet.service;
//
//import com.example.nicecoding.fleet.model.VehicleMovement;
//import com.example.nicecoding.fleet.repository.VehicleMovementRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class VehicleMovementService {
//	private final VehicleMovementRepository vehicleMovementRepository;
//
//	//Get All VehicleMovements
//	public List<VehicleMovement> listOfMovement() {
//		return vehicleMovementRepository.findAll();
//	}
//
//	//Get VehicleMovement By Id
//	public VehicleMovement findMovementById(int id) {
//		return vehicleMovementRepository.findById(id).orElse(null);
//	}
//
//	//Delete VehicleMovement
//	public void deleteMovement(VehicleMovement movement) {
//		vehicleMovementRepository.delete(movement);
//	}
//
//	//Update VehicleMovement
//	public void saveMovement(VehicleMovement vehicleMovement) {
//		vehicleMovementRepository.save(vehicleMovement);
//	}
//
//}
