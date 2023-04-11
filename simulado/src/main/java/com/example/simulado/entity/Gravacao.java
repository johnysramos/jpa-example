package com.example.simulado.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "gravacao")
public class Gravacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_gravacao", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_gravadora", nullable = false)
    private Gravadora gravadora;

    @ManyToOne
    @JoinColumn(name = "cod_cantor", nullable = false)
    private Cantor cantor;

    @ManyToOne
    @JoinColumn(name = "cod_musica", nullable = false)
    private Musica musica;

    @Column(name = "data_gravacao") 
    @Temporal(TemporalType.DATE)
    private Date dataGravacao;
}
