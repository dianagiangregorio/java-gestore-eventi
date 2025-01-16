package org.gestioneventi.bept4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    //getter e setter: titolo e data sono sia in lettura che in scrittura; posti totali e prenotati sono solo in lettura.

    public String getTitolo(){
        return this.titolo;
    }

    public LocalDate getDate(){
        return this.data;
    }

    public int getPostiTotali(){
        return this.postiTotali;
    }

    public int getPostiPrenotati(){
        return this.postiPrenotati;
    }

    public void setTitolo(String titolo){
        this.titolo = titolo;
    }

    public void setData(LocalDate data){
        this.data = data;
        // if (data.isAfter(LocalDate.now())) {
        //     this.data = data;            
        // }
        // else {
        //     System.out.println("La data inserita non è corretta.");
        // }
    }

    //metodo per prenotare un post ad un evento
    public void prenota(){
        if (data.isBefore(LocalDate.now())) {
            System.out.println("L'evento è già passato.");
        }
        else if (postiPrenotati >= postiTotali) {
            System.out.println("Non ci sono posti disponibili.");
        }
        else{
            postiPrenotati ++;
        }
    }

    public void disdici(){
        if (data.isBefore(LocalDate.now())) {
            System.out.println("L'evento è già passato.");
        }
        else if (postiPrenotati <= 0) {
            System.out.println("Non ci sono prenotazioni per questo evento.");
        }
        else{
            postiPrenotati --;
            System.out.println("La tua prenotazione è stata disdetta.");
        }
    }

    public String dataFormattata(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    @Override
    public String toString(){
        return "Data evento: " + dataFormattata() + " - Evento: " + titolo;
    }
}
