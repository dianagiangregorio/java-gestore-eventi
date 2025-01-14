package org.gestioneventi.bept4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        //creo uno scanner per chiedere infornmazioni all'utente
        Scanner input = new Scanner(System.in);

        //chiedo all'utente di inserire il titolo dell'evento
        System.out.println("Inserisci il nome dell'evento: ");
        String titolo = input.nextLine();

        //chiedo all'utente di inserire la data, che sarà una variabile di tipo Stringa e inizializzo una variabile di tipo LocalDate
        //controllo che il formato della data inserito sia corretto e lo inserisco nella variabile LocalDate data
        //utilizzo un ciclo while per permettere all'utente di riprovare ad inserire la data finchè non è corretta

        LocalDate data = null;
        while (data == null) {
            System.out.println("Inserisci la data dell'evento in formato dd/MM/yyyy: ");
            String dataString = input.nextLine();

            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                //il metodo parse converte la stringa in LocalDate se il formato è corretto
                data = LocalDate.parse(dataString, formatter);
            }
            catch(Exception e){
                System.out.println("Il formato della data non è valido. Inserisci una data corretta:");
            }
        }

        //chiedo all'utente di inserire il numero di posti totali dell'evento
        System.out.println("Inserisci il numero di posti totali: ");
        int postiTotali = input.nextInt(); 

        //creo l'evento
        try{
            Evento evento = new Evento(titolo, data, postiTotali);
            
            //se non si verificano errori creo l'evento e stampo i dettagli
            System.out.println("Hai creato l'evento:");
            System.out.println(evento);
        }
        catch(IllegalArgumentException e){
            System.out.println("Errore");
        }

        input.close();
    }
}
