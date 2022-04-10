package com.example.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vendas.DTO.ClientesDTO;
import com.example.vendas.entities.Cliente;
import com.example.vendas.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClientesDTO> findAll() {
		
		List<Cliente>res=clienteRepository.findAll();
		return res.stream().map(c->new ClientesDTO(c)).collect(Collectors.toList());
	}

	
}
