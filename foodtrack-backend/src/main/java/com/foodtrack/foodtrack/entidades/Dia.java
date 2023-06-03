package com.foodtrack.foodtrack.entidades;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;

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
    // @JsonIgnore
    private List<Comida> comidas;

    // Constructor, getters y setters
    public Dia() {
        this.comidas = new ArrayList<>();
    }

    public Dia(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTotalProteinas() {
        return this.totalProteinas;
    }

    public void setTotalProteinas(Double totalProteinas) {
        this.totalProteinas = totalProteinas;
    }

    public Double getTotalGrasas() {
        return this.totalGrasas;
    }

    public void setTotalGrasas(Double totalGrasas) {
        this.totalGrasas = totalGrasas;
    }

    public Double getTotalAzucares() {
        return this.totalAzucares;
    }

    public void setTotalAzucares(Double totalAzucares) {
        this.totalAzucares = totalAzucares;
    }

    public Double getTotalKcal() {
        return this.totalKcal;
    }

    public void setTotalKcal(Double totalKcal) {
        this.totalKcal = totalKcal;
    }

    public List<Comida> getComidas() {
        return this.comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    @PrePersist
    public void calcularTotales() {
        double totalProteinas = 0.0;
        double totalGrasas = 0.0;
        double totalAzucares = 0.0;
        double totalKcal = 0.0;

        for (Comida comida : this.comidas) {
            totalProteinas += comida.getTotalProteinas();
            totalGrasas += comida.getTotalGrasas();
            totalAzucares += comida.getTotalAzucares();
            totalKcal += comida.getTotalKcal();
        }

        this.totalProteinas = totalProteinas;
        this.totalGrasas = totalGrasas;
        this.totalAzucares = totalAzucares;
        this.totalKcal = totalKcal;
    }

    public void setComida(Comida comida) {
        this.comidas.add(comida);
        comida.setDia(this);
    }
}
