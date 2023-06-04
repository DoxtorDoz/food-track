package com.foodtrack.foodtrack.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double kcal;

    // @ManyToOne
    // @JoinColumn(name = "comida_id", nullable = false)
    // @JsonBackReference
    // private Comida comida;

    // Constructor, getters y setters

    public Producto() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getKcal() {
        return this.kcal;
    }

    public void setKcal(Double kcal) {
        this.kcal = kcal;
    }

    // public Comida getComida() {
    // return this.comida;
    // }

    // public void setComida(Comida comida) {
    // if (this.comida != null) {
    // this.comida.getAlimentos().remove(this);
    // }
    // this.comida = comida;
    // if (comida != null && !comida.getAlimentos().contains(this)) {
    // comida.getAlimentos().add(this);
    // }
    // }
}
