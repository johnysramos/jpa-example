package com.example.simulado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "fone")
public class Fone {

    public static enum TipoFone{
        R, /* Residencial */
        C, /* Comercial */
        L  /* Celular */
     }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_fone")
    private Long id;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoFone tipoFone;

    @ManyToOne
    @JoinColumn(name = "cod_pessoa")
    private Pessoa pessoa;
}
