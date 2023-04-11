package com.example.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simulado.entity.Gravacao;
import com.example.simulado.repository.GravacaoRepository;

@Service
public class GravacaoService {
    
    @Autowired
    private GravacaoRepository repository;

    public Gravacao save(Gravacao gravacao) {
        return repository.save(gravacao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Gravacao> findAll() {
        return repository.findAll();
    }

    public Optional<Gravacao> findById(Long id) {
        return repository.findById(id);
    }
}
