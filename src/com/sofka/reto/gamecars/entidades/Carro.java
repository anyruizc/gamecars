package com.sofka.reto.gamecars.entidades;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Carro implements IVehiculo{

    public Carro(Conductor conductor) {
        this.conductor = conductor;
        this.recorrido = 0;
        this.enCarrera = true;
    }

    //recorrido en metros
    private int recorrido;
    private Conductor conductor;

    public boolean isEnCarrera() {
        return enCarrera;
    }

    public void setEnCarrera(boolean enCarrera) {
        this.enCarrera = enCarrera;
    }

    private boolean enCarrera;

    public int getRecorrido() {
        return recorrido;
    }

    public Conductor getConductor() {
        return conductor;
    }

    @Override
    public void avanzar() {
        if(this.enCarrera){
            System.out.println(conductor.getNombre()+ " Presione cualquier letra + Enter para lanzar los dados");
            try {
                Scanner in = new Scanner(System.in);
                String enter = in.next();
                Random random = new Random();
                int numero = random.nextInt(6)+1;
                numero = numero * 100;
                System.out.println(conductor.getNombre() +" Ha avanzado "+numero +" en metros");

                this.recorrido = this.recorrido + numero;
            }catch (InputMismatchException e){
                System.out.println("Algo ocurrió mal");
            }
        }
    }
}
