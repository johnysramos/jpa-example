package com.example.simulado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.simulado.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
    @Query(value="select p from Pessoa p left join fetch p.fones where p.id = ?1")
    Optional<Pessoa> findById(Long id);

    @Query(value="select distinct p from Pessoa p left join fetch p.fones")
    List<Pessoa> findAll();
}
