package com.example.simulado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.simulado.entity.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long>{
    
    @Query(value="select m from Musica m left join fetch m.gravacoes where m.id = ?1")
    Optional<Musica> findById(Long id);

    @Query(value="select distinct m from Musica m left join fetch m.gravacoes")
    List<Musica> findAll();
}
