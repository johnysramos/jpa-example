package com.example.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simulado.entity.Pessoa;
import com.example.simulado.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository repository;

    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return repository.findById(id);
    }
}
