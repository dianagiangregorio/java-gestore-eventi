package org.gestioneventi.bept4;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

    //variabili di istanza del concerto
    private LocalTime ora;
    private float prezzo;

    //costruttore con gli attributi della superclasse e quelli della classe concerto
    public Concerto (String titolo, LocalDate data, int postiPrenotati, LocalTime ora, float prezzo){
        super(titolo, data, postiPrenotati);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    //getter and setter
    public LocalTime getOra(){
        return this.ora;
    } 

    public void setOra(LocalTime ora){
        this.ora = ora;
    }

    public float getPrezzo(){
        return this.prezzo;
    }

    public void setPrezzo(float prezzo){
        this.prezzo = prezzo;
    }

    public String oraFormattata(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return ora.format(formatter);
    }

    public String prezzoFormattato(){
        return String.format("%.2f€", prezzo); //converto in stringa un numero decimale e scrivo il valore con 2 cifre decimali (x simbolo € \u20AC)
        }

    @Override
    public String toString(){
        return dataFormattata() + " " + oraFormattata() + " - " + getTitolo() + " - " + prezzoFormattato();
    }
}
