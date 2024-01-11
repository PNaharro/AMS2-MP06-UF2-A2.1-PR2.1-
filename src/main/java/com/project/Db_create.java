package com.project;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Db_create {
    
     public static void main(String[] args) throws SQLException {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "database.db";
        ResultSet rs = null;

        // Si no hi ha l'arxiu creat, el crea i li posa dades
        File fDatabase = new File(filePath);
        if (!fDatabase.exists()) { initDatabase(filePath); }

       
    }

    static void initDatabase (String filePath) {
        // Connectar (crea la BBDD si no existeix)
        Connection conn = UtilsSQLite.connect(filePath);

        
        UtilsSQLite.queryUpdate(conn, "DROP TABLE IF EXISTS Facció;");
        UtilsSQLite.queryUpdate(conn, "DROP TABLE IF EXISTS Personatge;");

        UtilsSQLite.queryUpdate(conn, "CREATE TABLE IF NOT EXISTS Facció ("
                                    + "	id integer PRIMARY KEY AUTOINCREMENT,"
                                    + "	nom varchar(15) NOT NULL,"
                                    + "	resum varchar(500) NOT NULL);");

        UtilsSQLite.queryUpdate(conn, "INSERT INTO Facció (nom, resum) VALUES ('Cavalleros', 'Orden noble de caballeros');");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Facció (nom, resum) VALUES ('Vikingos', 'Guerreros nórdicos intrépidos');");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Facció (nom, resum) VALUES ('Samurais', 'Guerreros japoneses con honor');");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Facció (nom, resum) VALUES ('Wu lin','Facción de guerreros chinos');");

        UtilsSQLite.queryUpdate(conn, "CREATE TABLE IF NOT EXISTS Personatge ("
                                    + "	id integer PRIMARY KEY AUTOINCREMENT,"
                                    + "	nom varchar(15) NOT NULL,"
                                    + "	atac real NOT NULL,"
                                    + "	defensa real NOT NULL,"
                                    + "	idFaccio integer NOT NULL,"
                                    + "	FOREIGN KEY (idFaccio) REFERENCES Facció(id));");

        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Warden', 15.2, 10.0, 1);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Centurion', 14.8, 9.5, 1);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Gladiador', 13.5, 8.0, 1);");
    
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Raider', 14.5, 9.0, 2);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Warlord', 13.7, 8.5, 2);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Valkyrie', 12.9, 7.8, 2);");
    
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Shinobi', 11.5, 8.2, 3);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Orochi', 12.0, 8.7, 3);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Nobushi', 11.2, 8.5, 3);");
    
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Tiandi', 14.0, 9.5, 4);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Nuxia', 13.3, 8.8, 4);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Shaolin', 15.5, 10.2, 4);");


        // Desconnectar
        UtilsSQLite.disconnect(conn);
    }

}
