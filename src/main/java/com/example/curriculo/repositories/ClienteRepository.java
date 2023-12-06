package com.example.curriculo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.curriculo.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
