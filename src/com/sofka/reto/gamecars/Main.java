package com.sofka.reto.gamecars;

import com.sofka.reto.gamecars.entidades.Juego;
import com.sofka.reto.gamecars.entidades.Menu;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Juego juego = new Juego();
        Menu menu = new Menu(juego);
        menu.menu();
    }
}
