package com.example.simulado.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_pessoa")
    private Long id;

    @Column(name = "nome_pessoa", nullable = false)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Fone> fones;

    //Methods
    public List<Fone> getFones() {
        if (this.fones != null) {
            return this.fones;
        }
        else {
            return new ArrayList<Fone>();
        }
    }

    public void setFones(List<Fone> fones) {
        this.fones = fones;

        for (Fone fone : fones) {
            fone.setPessoa(this);
        }
    }

    @Override
    public String toString() {
        return "Pessoa(" +
            "id = " + this.id + 
            ", nome = " + this.nome + ")";
    }
}
