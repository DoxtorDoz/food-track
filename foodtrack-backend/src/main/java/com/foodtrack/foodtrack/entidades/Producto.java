package com.foodtrack.foodtrack.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

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

}
