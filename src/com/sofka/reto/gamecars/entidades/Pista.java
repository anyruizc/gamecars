package com.sofka.reto.gamecars.entidades;

import java.util.ArrayList;
import java.util.List;

public class Pista {
    //distancia en kilómetros
    private int distancia;

    private List<Carril> carriles;

    public Pista(int distancia) {
        this.distancia = distancia;
        this.carriles = new ArrayList<>();
    }

    public void agregarCarril(Carril carril){
        this.carriles.add(carril);
    }

    public List<Carril> getCarriles() {
        return carriles;
    }

    public int getDistancia() {
        return distancia;
    }
}
