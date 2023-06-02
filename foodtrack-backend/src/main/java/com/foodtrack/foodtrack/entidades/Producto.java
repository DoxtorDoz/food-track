package com.foodtrack.foodtrack.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
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
    private Double proteina;

    @Column(nullable = false)
    private Double grasa;

    @Column(nullable = false)
    private Double azucar;

    @Column(nullable = false)
    private Double kcal;

    @ManyToOne
    @JoinColumn(name = "comida_id", nullable = false)
    private Comida comida;

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

    public Double getProteina() {
        return this.proteina;
    }

    public void setProteina(Double proteina) {
        this.proteina = proteina;
    }

    public Double getGrasa() {
        return this.grasa;
    }

    public void setGrasa(Double grasa) {
        this.grasa = grasa;
    }

    public Double getAzucar() {
        return this.azucar;
    }

    public void setAzucar(Double azucar) {
        this.azucar = azucar;
    }

    public Double getKcal() {
        return this.kcal;
    }

    public void setKcal(Double kcal) {
        this.kcal = kcal;
    }

    public Comida getComida() {
        return this.comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }
}
