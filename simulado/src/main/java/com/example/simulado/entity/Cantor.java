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
@Table(name = "cantor")
public class Cantor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cantor", nullable = false)
    private Long id;

    @Column(name = "nome_cantor", nullable = false)
    private String nome;

    @Column(name = "pais", nullable = false)
    private String pais;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cantor")
    private List<Gravacao> gravacoes;

    //Methods
    public List<Gravacao> getGravacoes() {
        if (this.gravacoes != null) {
            return this.gravacoes;
        }
        else {
            return new ArrayList<Gravacao>();
        }
    }

    public void setGravacoes(List<Gravacao> gravacoes) {
        this.gravacoes = gravacoes;

        for (Gravacao gravacao : this.gravacoes) {
            gravacao.setCantor(this);
        }
    }

    @Override
    public String toString() {
        return "Cantor(" +
            "id = " + this.id + 
            ", nome = " + this.nome +
            ", pais = " + this.pais + ")";
    }
}
