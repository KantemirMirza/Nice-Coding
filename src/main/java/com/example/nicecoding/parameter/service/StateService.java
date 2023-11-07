package com.example.nicecoding.parameter.service;

import com.example.nicecoding.parameter.model.State;
import com.example.nicecoding.parameter.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {
	private final StateRepository stateRepository;


	//Get All States
	public List<State> listOfState() {
		return stateRepository.findAll();
	}

	public State findStateById(Integer id) {
		return stateRepository.findById(id).orElse(null);
	}
	
	//Delete State
	public void deleteState(State state) {
		stateRepository.delete(state);
	}
	
	//Update State
	public void saveState(State state) {
		stateRepository.save(state);
	}
}
