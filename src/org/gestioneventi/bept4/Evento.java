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

        setTitolo(titolo);
        setData(data);

        //controllo che il numero di posti totali sia un numero positivo
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere maggiore di 0");
        }

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
        
        //controllo che la data inserita non sia già passata
        if (data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("L'evento è già passato.");
        }
            this.data = data;
    }

    //metodo per prenotare posti ad un evento
    public void prenota(){
        if (postiPrenotati >= postiTotali) {
            System.out.println("Non ci sono posti disponibili.");
        }
        else{
            postiPrenotati ++;
        }
    }

    //metodo per disdire posti ad un evento
    public void disdici(){
        if (postiPrenotati <= 0) {
            System.out.println("Non ci sono prenotazioni per questo evento.");
        }
        else{
            postiPrenotati --;
        }
    }

    public String dataFormattata(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    @Override
    public String toString(){
        return "Evento: " + titolo + " - Data evento: " + dataFormattata();
    }
}
