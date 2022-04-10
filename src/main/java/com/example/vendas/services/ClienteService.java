package com.example.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.vendas.DTO.ClientesDTO;
import com.example.vendas.entities.Cliente;
import com.example.vendas.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClientesDTO> findAll() {
		List<Cliente> res = clienteRepository.findAll();
		return res.stream().map(c -> new ClientesDTO(c)).collect(Collectors.toList());
	}

	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente updateCliente(Integer id, Cliente newCliente) {
		return clienteRepository.findById(id).map(c -> {
			c.setNome(newCliente.getNome());
			c.setDn(newCliente.getDn());
			Cliente atualizado = clienteRepository.save(c);
			return atualizado;
		}).orElse(null);
	}

	public void deleteCliente(Integer id) {
		try {
		if (clienteRepository.findById(id) != null)
			clienteRepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Você não pode deletar um cliente fez compras");
		}
	}

	public Cliente fromDTO(ClientesDTO clienteDTO) {
		Cliente entidade = new Cliente(0, clienteDTO.getNome(), clienteDTO.getDn());
		return entidade;
	}

}
