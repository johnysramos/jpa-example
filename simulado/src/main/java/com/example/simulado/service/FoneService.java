package com.example.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simulado.entity.Fone;
import com.example.simulado.repository.FoneRepository;

@Service
public class FoneService {
    
    @Autowired
    private FoneRepository repository;

    public Fone save(Fone fone) {
        return repository.save(fone);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Fone> findAll() {
        return repository.findAll();
    }

    public Optional<Fone> findById(Long id) {
        return repository.findById(id);
    }
}
