package com.foodtrack.foodtrack.entidades;

import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "comida")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo; // Puede ser Desayuno, Comida, Merienda o Cena

    @Column(nullable = false)
    private Double totalProteinas;

    @Column(nullable = false)
    private Double totalGrasas;

    @Column(nullable = false)
    private Double totalAzucares;

    @Column(nullable = false)
    private Double totalKcal;

    @ManyToOne
    @JoinColumn(name = "dia_id", nullable = false)
    private Dia dia;

    @OneToMany(mappedBy = "comida", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> alimentos;

    // Constructor, getters y setters
}
