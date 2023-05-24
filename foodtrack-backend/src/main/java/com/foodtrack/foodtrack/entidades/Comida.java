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
@Table(name = "comida")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "comida_id")
    private List<Producto> productos;

    // Getters and Setters, constructor, and other methods

    public Comida() {
    }

    public Comida(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public Comida(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public Comida(String nombre, Producto producto) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
        this.productos.add(producto);
    }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

}
