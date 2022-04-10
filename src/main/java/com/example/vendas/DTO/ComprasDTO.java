package com.example.vendas.DTO;
import java.time.LocalDate;
import com.example.vendas.entities.Compras;

public class ComprasDTO {
	
	private int id;
	private Double totalCompra;
	private LocalDate dataCompra;
	
	private ClientesDTO cliente;//adicionei

	public ComprasDTO(Compras entidade) {
		this.id = entidade.getId();
		this.totalCompra = entidade.getTotalCompra();
		this.dataCompra = entidade.getDataCompra();
		this.cliente=new ClientesDTO(entidade.getCliente());//adicionei
	}
		
	public ComprasDTO(int id, Double totalCompra, LocalDate dataCompra,ClientesDTO cliente) {//adicionei
		this.id = id;
		this.totalCompra = totalCompra;
		this.dataCompra = dataCompra;
		this.cliente=cliente;
	}
	
	public ComprasDTO() {//adicionei

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(Double totalCompra) {
		this.totalCompra = totalCompra;
	}
	public LocalDate getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public ClientesDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClientesDTO cliente) {
		this.cliente = cliente;
	}

	
}