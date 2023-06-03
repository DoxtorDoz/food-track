package com.foodtrack.foodtrack.entidades;

import java.util.List;
import jakarta.persistence.CascadeType;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import jakarta.persistence.Enumerated;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "comida")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoComida tipoComida;

    public enum TipoComida {
        DESAYUNO,
        COMIDA,
        MERIENDA,
        CENA
    }

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
    @JsonIgnore
    private Dia dia;

    @OneToMany(mappedBy = "comida", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Producto> alimentos;

    // Constructor, getters y setters

    public Comida() {
        this.alimentos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public TipoComida getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }

    public Double getTotalProteinas() {
        return totalProteinas;
    }

    public void setTotalProteinas(Double totalProteinas) {
        this.totalProteinas = totalProteinas;
    }

    public Double getTotalGrasas() {
        return totalGrasas;
    }

    public void setTotalGrasas(Double totalGrasas) {
        this.totalGrasas = totalGrasas;
    }

    public Double getTotalAzucares() {
        return totalAzucares;
    }

    public void setTotalAzucares(Double totalAzucares) {
        this.totalAzucares = totalAzucares;
    }

    public Double getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(Double totalKcal) {
        this.totalKcal = totalKcal;
    }

    public Dia getDia() {
        return dia;
    }

    // public void setDia(Dia dia) {
    // this.dia = dia;
    // }

    public void setDia(Dia dia) {
        if (this.dia != null) {
            this.dia.getComidas().remove(this);
        }
        this.dia = dia;
        if (dia != null) {
            dia.getComidas().add(this);
        }
    }

    public List<Producto> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Producto> alimentos) {
        this.alimentos = alimentos;
    }

    @PrePersist
    public void calcularTotales() {
        this.totalProteinas = 0.0;
        this.totalGrasas = 0.0;
        this.totalAzucares = 0.0;
        this.totalKcal = 0.0;
        for (Producto alimento : this.alimentos) {
            this.totalProteinas += alimento.getProteina();
            this.totalGrasas += alimento.getGrasa();
            this.totalAzucares += alimento.getAzucar();
            this.totalKcal += alimento.getKcal();
        }
    }

    public void addProducto(Producto producto) {
        alimentos.add(producto);
        producto.setComida(this);
    }

}
