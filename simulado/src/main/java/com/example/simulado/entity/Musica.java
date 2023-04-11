package com.example.simulado.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "musica")
public class Musica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_musica", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "duracao", nullable = false)
    private Long duracao;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musica")
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
            gravacao.setMusica(this);
        }
    }

    @Override
    public String toString() {
        return "Musica(" +
            "id = " + this.id + 
            ", categoria = " + this.categoria +
            ", duracao = " + this.duracao + 
            ", titulo = " + this.titulo + ")";
    }
}
