package com.foodtrack.foodtrack.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @Column(name = "calorias")
    private Double calorias;

    @Column(name = "proteinas")
    private Double proteinas;

    @Column(name = "grasas")
    private Double grasas;

    @Column(name = "carbohidratos")
    private Double carbohidratos;

    @Column(name = "azucares")
    private Double azucares;

    @Column(name = "fibra")
    private Double fibra;

    public Producto() {
    }

    public Producto(String nombre, Double calorias, Double proteinas, Double grasas, Double carbohidratos,
            Double azucares, Double fibra) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.carbohidratos = carbohidratos;
        this.azucares = azucares;
        this.fibra = fibra;
    }

    public Producto(Long id, String nombre, Double calorias, Double proteinas, Double grasas, Double carbohidratos,
            Double azucares, Double fibra) {
        this.id = id;
        this.nombre = nombre;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.carbohidratos = carbohidratos;
        this.azucares = azucares;
        this.fibra = fibra;
    }

    public Producto(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.calorias = producto.getCalorias();
        this.proteinas = producto.getProteinas();
        this.grasas = producto.getGrasas();
        this.carbohidratos = producto.getCarbohidratos();
        this.azucares = producto.getAzucares();
        this.fibra = producto.getFibra();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getCalorias() {
        return calorias;
    }

    public Double getProteinas() {
        return proteinas;
    }

    public Double getGrasas() {
        return grasas;
    }

    public Double getCarbohidratos() {
        return carbohidratos;
    }

    public Double getAzucares() {
        return azucares;
    }

    public Double getFibra() {
        return fibra;
    }

}
