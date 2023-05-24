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
@Table(name = "cena")
public class Cena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cena_id")
    private List<Producto> productos;

    // Getters and Setters, constructor, and other methods
    public Cena() {
    }

    public Cena(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public Cena(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public Cena(String nombre, Producto producto) {
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
