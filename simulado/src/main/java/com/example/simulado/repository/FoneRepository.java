package com.example.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simulado.entity.Fone;

public interface FoneRepository extends JpaRepository<Fone, Long>{
    
}
