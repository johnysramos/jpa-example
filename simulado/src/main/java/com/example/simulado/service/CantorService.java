package com.example.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simulado.entity.Cantor;
import com.example.simulado.repository.CantorRepository;

@Service
public class CantorService {
    
    @Autowired
    private CantorRepository repository;

    public Cantor save(Cantor cantor) {
        return repository.save(cantor);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Cantor> findAll() {
        return repository.findAll();
    }

    public Optional<Cantor> findById(Long id) {
        return repository.findById(id);
    }
}
