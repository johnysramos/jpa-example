package com.example.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simulado.entity.Musica;
import com.example.simulado.repository.MusicaRepository;

@Service
public class MusicaService {
    
    @Autowired
    private MusicaRepository repository;

    public Musica save(Musica Musica) {
        return repository.save(Musica);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Musica> findAll() {
        return repository.findAll();
    }

    public Optional<Musica> findById(Long id) {
        return repository.findById(id);
    }
}
