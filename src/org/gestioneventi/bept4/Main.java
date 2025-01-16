package org.gestioneventi.bept4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        // creo uno scanner per chiedere infornmazioni all'utente
        Scanner input = new Scanner(System.in);

        // chiedo all'utente di inserire il titolo dell'evento e verifico che non sia
        // vuoto
        String titolo = "";
        while (titolo.isEmpty()) {
            System.out.println("Inserisci il nome dell'evento: ");
            titolo = input.nextLine();
        }

        // chiedo all'utente di inserire la data, lo scanner restituirà una variabile di
        // tipo Stringa
        // utilizzo un ciclo while per permettere all'utente di riprovare ad inserire la
        // data finchè non è corretta
        // controllo che il formato della data inserito sia corretto e lo inserisco
        // nella variabile LocalDate data

        LocalDate data = null;
        while (data == null) {
            System.out.println("Inserisci la data dell'evento in formato dd/MM/yyyy: ");
            String dataString = input.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                // il metodo parse converte la stringa in LocalDate se il formato è corretto
                data = LocalDate.parse(dataString, formatter);
            } catch (Exception e) {
                System.out.println("Il formato della data non è valido. Inserisci una data corretta:");
            }
        }

        // chiedo all'utente di inserire il numero di posti totali dell'evento
        System.out.println("Inserisci il numero di posti totali: ");
        int postiTotali = Integer.parseInt(input.nextLine());

        // creo l'evento
        Evento evento = null;
        try {
            evento = new Evento(titolo, data, postiTotali);
            // se non si verificano errori creo l'evento e stampo i dettagli
            System.out.println("Hai creato l'evento:");
            System.out.println(evento);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore, evento non creato.");
        }

        //effettuare prenotazioni
        // controllo che l'evento sia stato creato correttamente
        if (evento != null) {
            String effettuoPrenotazione = "";
            while (!effettuoPrenotazione.equals("Y") && !effettuoPrenotazione.equals("N")) {

                //chiedo all'utente se vuole effettuare delle prenotazioni
                System.out.println("Vuoi fare delle prenotazioni? (Y/N)");
                effettuoPrenotazione = input.nextLine().toUpperCase();

                //verifico la risposta
                if (!effettuoPrenotazione.equals("Y") && !effettuoPrenotazione.equals("N")) {
                    System.out.println("Risposta non valida. Rispondi con Y(yes) oppre N(no)");
                }
            }

            // se la risposta è Y(Yes) allora chiedo quante prenotazioni effettuare
            if (effettuoPrenotazione.equals("Y")) {
                int numeroPrenotazioni = 0;

                while (true) {
                    System.out.println("Quante prenotazioni vuoi effettuare?");

                    try {
                        numeroPrenotazioni = Integer.parseInt(input.nextLine());

                        // finchè l'utente non inserisce un numero valido non vado avanti nel codice
                        if (numeroPrenotazioni <= 0) {
                            System.out.println("Inserisci un numero maggiore di 0.");
                            continue;
                        }

                        // controllo che ci siano posti disponibili per l'evento
                        if (numeroPrenotazioni > (evento.getPostiTotali() - evento.getPostiPrenotati())) {
                            System.out.println("Non ci sono posti disponibili per l'evento.");
                            continue;
                        }

                        // se tutto è corretto effettuo le prenotazioni
                        for (int i = 0; i < numeroPrenotazioni; i++) {
                            evento.prenota();
                        }

                        System.out.println("Prenotazioni effettuate.");
                        // Stampare a video il numero di posti prenotati e quelli disponibili
                        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                        System.out.println(
                                "Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("Inserisci un numero corretto.");
                    }
                }
            } else {
                System.out.println("Nessuna prenotazione effettuata.");
            }

            // disdire le prenotazioni
            String disdiciPrenotazioni = "";
            while (!disdiciPrenotazioni.equals("Y") && !disdiciPrenotazioni.equals("N")) {

                //chiedo all'utente se vuole effettuare delle prenotazioni
                System.out.println("Vuoi disdire delle prenotazioni? (Y/N)");
                disdiciPrenotazioni = input.nextLine().toUpperCase();

                //verifico la risposta
                if (!disdiciPrenotazioni.equals("Y") && !disdiciPrenotazioni.equals("N")) {
                    System.out.println("Risposta non valida. Rispondi con Y(yes) oppre N(no)");
                }
            }

            // se la risposta è Y(Yes) allora chiedo quanti posti vuole disdire
            if (disdiciPrenotazioni.equals("Y")) {
                int disdettePrenotazioni = 0;

                while (true) {
                    System.out.println("Quante prenotazioni vuoi disdire?");

                    try {
                        disdettePrenotazioni = Integer.parseInt(input.nextLine());

                        // finchè l'utente non inserisce un numero valido non vado avanti nel codice
                        if (disdettePrenotazioni <= 0) {
                            System.out.println("Inserisci un numero maggiore di 0.");
                            continue;
                        }

                        // controllo che ci siano posti da disdire per l'evento
                        if (disdettePrenotazioni > evento.getPostiPrenotati()) {
                            System.out.println("Non ci sono prenotazioni da disdire.");
                            continue;
                        }

                        // se tutto è corretto effettuo la disdetta delle prenotazioni
                        for (int i = 0; i < disdettePrenotazioni; i++) {
                            evento.disdici();
                        }

                        System.out.println("Prenotazioni disdette.");
                        // Stampare a video il numero di posti prenotati e quelli disponibili
                        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                        System.out.println(
                                "Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("Inserisci un numero corretto.");
                    }
                }
            } else {
                System.out.println("Nessuna prenotazione disdetta.");
            }

        }
        input.close();
    }
}
