package com.example.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendas.DTO.ClientesDTO;
import com.example.vendas.entities.Cliente;
import com.example.vendas.services.ClienteService;

@RestController // classe ela vai ter endpoints
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<ClientesDTO>> findAll() {
		List<ClientesDTO> lista = clienteService.findAll();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<ClientesDTO> saveCliente(@RequestBody ClientesDTO clienteDTO) {
		Cliente entidade = clienteService.fromDTO(clienteDTO);
		clienteService.saveCliente(entidade);
		return new ResponseEntity<ClientesDTO>(clienteDTO, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	@ResponseBody
	public ResponseEntity<ClientesDTO> updateCliente(@PathVariable Integer id, @RequestBody ClientesDTO clienteDTO) {
		Cliente entidade = clienteService.fromDTO(clienteDTO);
		if (clienteService.updateCliente(id, entidade) != null) {
			return new ResponseEntity<ClientesDTO>(clienteDTO, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
		clienteService.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}
}