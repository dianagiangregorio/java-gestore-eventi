package org.gestioneventi.bept4;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {

        String titolo = "Concerto PTN";
        LocalDate data = LocalDate.of(2025,12, 12);
        int postiTotali = 150;
        LocalTime ora = LocalTime.of(20, 30);
        float prezzo = 46;

        //creo il concerto
        Concerto concerto = new Concerto(titolo, data, postiTotali, ora, prezzo);

        System.out.println(concerto);
        }
    }