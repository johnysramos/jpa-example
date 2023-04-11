package com.example.simulado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.simulado.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

    @Query(value="select c from Categoria c left join fetch c.musicas where c.id = ?1")
    Optional<Categoria> findById(Long id);

    @Query(value="select distinct c from Categoria c left join fetch c.musicas")
    List<Categoria> findAll();
    
}
