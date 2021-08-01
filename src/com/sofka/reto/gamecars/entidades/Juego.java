package com.sofka.reto.gamecars.entidades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Juego {
    private Pista pista;
    private List<Carro> ganadores;

    public Juego() {}

    private int pedirDistanciaPista() {
        System.out.println("Ingrese la distancia (en kilómetros) de la pista");
        try {
            Scanner in = new Scanner(System.in);
            return in.nextInt();
        }catch (InputMismatchException e){
            return -1;
        }
    }

    public void iniciarPista(){
        int distancia = 0;
        do{
            distancia = pedirDistanciaPista();
            if(distancia == -1) {
                System.out.println("Número con formato incorrecto, inténtelo de nuevo...");
            }
        } while(distancia == -1);
        this.pista = new Pista(distancia);
        this.ganadores = new ArrayList<Carro>();
    }

    public void agregarCarril(){
        System.out.println("Ingrese el nombre del conductor del carro");
        try {
            Scanner in = new Scanner(System.in);
            String nombre = in.next();
            Conductor conductor = new Conductor(nombre);
            Carro carro = new Carro(conductor);
            Carril carril = new Carril(carro);
            this.pista.agregarCarril(carril);
        }catch (InputMismatchException e){
            System.out.println("Algo ocurrió mal");
        }
    }

    public void iniciarJuego() {
        if(pista.getCarriles().size() < 3){
            System.out.println("Deben Existir al menos 3 carriles en la pista");
            return;
        }

        boolean finDelJuego = false;
        do{
            for (Carril carril: this.pista.getCarriles()) {
                carril.getCarro().avanzar();
                if (carril.getCarro().getRecorrido() / 1000 >= this.pista.getDistancia()){
                    carril.getCarro().setEnCarrera(false);
                    ganadores.add(carril.getCarro());
                    if(ganadores.size() == 3){
                        finDelJuego = true;
                        break;
                    }
                }
            }
        }while(finDelJuego == false);

        System.out.println("los ganadores son: ");
        int posicion = 0;
        for(Carro carro: ganadores){
            posicion= posicion+1;
            System.out.println("Posición "+ posicion + " : "+carro.getConductor().getNombre());
        }
    }
}
