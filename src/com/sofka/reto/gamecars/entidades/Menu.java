package com.sofka.reto.gamecars.entidades;

import java.util.Scanner;

public class Menu {
    private Juego juego;

    public Menu(Juego juego) {
        this.juego = juego;
    }

    public void mostrarOpciones(){
        System.out.println("Ingrese una opción: ");
        System.out.println("[P] para iniciar pista: ");
        System.out.println("[C] para agregar un carril con su respectivo carro y conductor a la pista: ");
        System.out.println("[I] para iniciar el juego: ");
        System.out.println("[X] para salir: ");
    }

    public String optenerOpcion(){
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public void menu(){
        String opcion = "";
        do{
            mostrarOpciones();
            opcion = optenerOpcion();
            switch (opcion){
                case "P": this.juego.iniciarPista(); break;
                case "C": this.juego.agregarCarril(); break;
                case "I": this.juego.iniciarJuego(); break;
                case "X": break;
            }
            System.out.println(opcion);
        }while(! "X".equalsIgnoreCase(opcion));
    }
}
