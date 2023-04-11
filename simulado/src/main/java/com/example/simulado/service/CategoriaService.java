package com.example.simulado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simulado.entity.Categoria;
import com.example.simulado.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return repository.findById(id);
    }
}
