package com.foodtrack.foodtrack.entidades;

import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name = "dia")
public class Dia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Double totalProteinas;

    @Column(nullable = false)
    private Double totalGrasas;

    @Column(nullable = false)
    private Double totalAzucares;

    @Column(nullable = false)
    private Double totalKcal;

    @OneToMany(mappedBy = "dia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comida> comidas;

    // Constructor, getters y setters
    public Dia() {
    }
}
