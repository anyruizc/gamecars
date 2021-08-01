package com.sofka.reto.gamecars.repositorios;

import com.sofka.reto.gamecars.entidades.Carro;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class ArchivoRepositorio {

    public void guardar(Carro carro, String posicion){
        String cadena = carro.getConductor().getNombre() + " posicion: "+ posicion +"\n\r";
        try {
            Files.writeString(
                Paths.get("ganadores.txt"), cadena,
                StandardCharsets.UTF_8,
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
