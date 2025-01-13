package org.gestioneventi.bept4;

import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    //costrutttore
    public Evento(String titolo, LocalDate data, int postiTotali){

        //controllo che la data inserita non sia già passata
        if (data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Hai inserito una data non valida");
        }
        //controllo che il numero di posti totali sia un numero positivo
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali non può essere meno di 0");
        }
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0; //il numero di posti prenotati viene inizializzato a 0
    }

}
