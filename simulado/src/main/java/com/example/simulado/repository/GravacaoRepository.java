package com.example.simulado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simulado.entity.Gravacao;

public interface GravacaoRepository extends JpaRepository<Gravacao, Long>{
    
}
