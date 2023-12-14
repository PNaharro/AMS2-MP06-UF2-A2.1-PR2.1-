package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mostrar_lista {
      static Scanner in = new Scanner(System.in); // System.in és global, Scanner també ho a de ser

    // Main
    public static void main(String[] args) throws InterruptedException, IOException {
        
        boolean running = true;

        while (running) {

            String menu = "Escull una opció:";
            menu = menu + "\n 0) Listar_personajes";
            menu = menu + "\n 1) Listar_faciones";
            menu = menu + "\n 2) Sortir";
            System.out.println(menu);

            int opcio = Integer.valueOf(llegirLinia("Opció:"));
            
            try {
                switch (opcio) {
                    case 0: Listar_personajes.main(args);                break;
                    //case 1: PR141Main.main(args);                break;
                    case 2: Main.main(args);              break;
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

}
