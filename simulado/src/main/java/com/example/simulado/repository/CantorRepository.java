package com.example.simulado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.simulado.entity.Cantor;

public interface CantorRepository extends JpaRepository<Cantor, Long>{
    
    @Query(value="select c from Cantor c left join fetch c.gravacoes where c.id = ?1")
    Optional<Cantor> findById(Long id);

    @Query(value="select distinct c from Cantor c left join fetch c.gravacoes")
    List<Cantor> findAll();
}
