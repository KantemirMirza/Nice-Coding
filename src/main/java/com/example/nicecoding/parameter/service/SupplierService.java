package com.example.nicecoding.parameter.service;

import com.example.nicecoding.parameter.model.Supplier;
import com.example.nicecoding.parameter.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
	private final SupplierRepository supplierRepository;

	//Get All Suppliers
	public List<Supplier> listOfSupplier() {
		return supplierRepository.findAll();
	}

	//Get Supplier By Id
	public Supplier findSupplierById(int id) {
		return supplierRepository.findById(id).orElse(null);
	}

	//Delete Supplier
	public void deleteSupplier(Supplier supplier) {
		supplierRepository.delete(supplier);
	}

	//Save Supplier
	public void saveSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}
}
