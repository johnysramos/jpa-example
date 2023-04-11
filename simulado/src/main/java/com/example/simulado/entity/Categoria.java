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
@Table(name = "categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_categoria", nullable = false)
    private Long id;

    @Column(name = "desc_categoria", nullable = false)
    private String desc;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private List<Musica> musicas;

    //Methods
    public List<Musica> getMusicas() {
        if (this.musicas != null) {
            return this.musicas;
        }
        else {
            return new ArrayList<Musica>();
        }
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;

        for (Musica musica : this.musicas) {
            musica.setCategoria(this);
        }
    }

    @Override
    public String toString() {
        return "Categoria(" +
            "id = " + this.id + 
            ", desc = " + this.desc + ")";
    }
}
