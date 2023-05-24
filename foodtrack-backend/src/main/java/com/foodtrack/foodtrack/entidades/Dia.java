package com.foodtrack.foodtrack.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Desayuno> desayunos;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comida> comidas;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Merienda> meriendas;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cena> cenas;

    // Constructor, getters y setters

    public Dia(List<Desayuno> desayunos, List<Comida> comidas, List<Merienda> meriendas, List<Cena> cenas) {
        this.desayunos = desayunos;
        this.comidas = comidas;
        this.meriendas = meriendas;
        this.cenas = cenas;
    }

    public Dia() {
    }

    public List<Desayuno> getDesayunos() {
        return desayunos;
    }

    public void setDesayunos(List<Desayuno> desayunos) {
        this.desayunos = desayunos;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    public List<Merienda> getMeriendas() {
        return meriendas;
    }

    public void setMeriendas(List<Merienda> meriendas) {
        this.meriendas = meriendas;
    }

    public List<Cena> getCenas() {
        return cenas;
    }

    public void setCenas(List<Cena> cenas) {
        this.cenas = cenas;
    }

    // ...

    public void addDesayuno(Desayuno desayuno) {
        if (desayunos == null) {
            desayunos = new ArrayList<>();
        }
        desayunos.add(desayuno);
    }

    public void addComida(Comida comida) {
        if (comidas == null) {
            comidas = new ArrayList<>();
        }
        comidas.add(comida);
    }

    public void addMerienda(Merienda merienda) {
        if (meriendas == null) {
            meriendas = new ArrayList<>();
        }
        meriendas.add(merienda);
    }

    public void addCena(Cena cena) {
        if (cenas == null) {
            cenas = new ArrayList<>();
        }
        cenas.add(cena);
    }
}