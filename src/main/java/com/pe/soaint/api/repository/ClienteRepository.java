package com.pe.soaint.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.soaint.api.dto.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
