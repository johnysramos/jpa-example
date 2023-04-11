package com.example.simulado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.simulado.entity.Gravadora;

public interface GravadoraRepository extends JpaRepository<Gravadora, Long>{
    
    @Query(value="select g from Gravadora g left join fetch g.gravacoes where g.id = ?1")
    Optional<Gravadora> findById(Long id);

    @Query(value="select distinct g from Gravadora g left join fetch g.gravacoes")
    List<Gravadora> findAll();
}
