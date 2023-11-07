package com.example.nicecoding.parameter.service;

import com.example.nicecoding.parameter.model.Location;
import com.example.nicecoding.parameter.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LocationService {
	private final LocationRepository locationRepository;

	public List<Location> listOfLocation() {
		return (List<Location>) locationRepository.findAll();
	}

	public void saveLocation(Location location) {
		locationRepository.save(location);
	}

	public Location findLocationById(Integer id) {
		return locationRepository.findById(id).orElse(null);
	}

	public void deleteLocation(Location location) {
		locationRepository.delete(location);
	}
}
