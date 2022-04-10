package com.example.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendas.entities.Compras;

public interface ComprasRepository extends JpaRepository<Compras, Integer> {

}
