package com.example.nicecoding.parameter.service;

import com.example.nicecoding.parameter.model.Client;
import com.example.nicecoding.parameter.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
	private final ClientRepository clientRepository;

	//Get All Clients
	public List<Client> listOfClient() {
		return clientRepository.findAll();
	}

	public Client findClientById(Integer id) {
		return clientRepository.findById(id).orElse(null);
	}


	//Delete Client
	public void deleteClient(Client client) {
		clientRepository.delete(client);
	}

	//Save Client
	public void saveClient(Client client) {
		clientRepository.save(client);
	}
}
