package com.example.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simulado.entity.Gravadora;
import com.example.simulado.repository.GravadoraRepository;

@Service
public class GravadoraService {
    
    @Autowired
    private GravadoraRepository repository;

    public Gravadora save(Gravadora gravadora) {
        return repository.save(gravadora);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Gravadora> findAll() {
        return repository.findAll();
    }

    public Optional<Gravadora> findById(Long id) {
        return repository.findById(id);
    }
}
