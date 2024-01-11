package com.project;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Aquest exemple mostra com fer una 
 * connexió a SQLite amb Java
 * 
 * A la primera crida, crea l'arxiu 
 * de base de dades hi posa dades,
 * després les modifica
 * 
 * A les següent crides ja estan
 * originalment modificades
 * (tot i que les sobreescriu cada vegada)
 */

public class Main {

   static Scanner in = new Scanner(System.in); // System.in és global, Scanner també ho a de ser

    // Main
    public static void main(String[] args) throws InterruptedException, IOException {
        
        
        boolean running = true;

        while (running) {

            String menu = "Escull una opció:";
            menu = menu + "\n 0) Mostrar tablas";
            menu = menu + "\n 1) Mostrar Personajes Por Faccion";
            menu = menu + "\n 2) Mostrar Millor Atacant Per Faccio";
            menu = menu + "\n 3) Mostrar Millor Defensor Per Faccio";
            menu = menu + "\n 4) Sortir";
            System.out.println(menu);

            int opcio = Integer.valueOf(llegirLinia("Opció:"));
            
            try {
                switch (opcio) {
                    case 0: listar(args);                break;
                    case 1: MostrarPersonajesPorFaccion.main(args);                  break;
                    case 2: MostrarMillorAtacantPerFaccio.main(args);                break;
                    case 3: MostrarMillorDefensorPerFaccio.main(args);               break;
                    case 4: running = false;                       break;
                    default: break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

		in.close();
    }

    static public String llegirLinia (String text) {
        System.out.print(text);
        return in.nextLine();
    }
    static public void listar(String[] args) throws InterruptedException, IOException, SQLException{
         boolean running = true;

        while (running) {
        String menu = "Escull una opció:";
        menu = menu + "\n 0) Listar_personajes";
        menu = menu + "\n 1) Listar_faciones";
        menu = menu + "\n 2) Sortir";
        System.out.println(menu);
        int opcio = Integer.valueOf(llegirLinia("Opció:"));
        switch (opcio) {
            case 0: Listar_personajes.main(args);                break;
            case 1: Listar_faciones.main(args);                  break;
            case 2: running = false;                             break;
            default: break;
        }
    }
}
}