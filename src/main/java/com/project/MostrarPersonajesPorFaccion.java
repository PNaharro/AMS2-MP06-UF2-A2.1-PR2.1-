package com.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MostrarPersonajesPorFaccion {

    public static void main(String[] args) throws SQLException {
       String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "database.db";
        ResultSet rs = null;
        // Connectar (crea la BBDD si no existeix)
        Connection conn = UtilsSQLite.connect(filePath);

        // Reemplaza 1 con el ID de la facción que deseas mostrar
        for (int i = 0; i<4;i++){
            int idFaccion = i+1;

            displayCharactersByFaction(conn, idFaccion);
        }
        

        UtilsSQLite.disconnect(conn);
    }

    static void displayCharactersByFaction(Connection conn, int idFaccion) throws SQLException {
        ResultSet rs = UtilsSQLite.querySelect(conn,
                "SELECT * FROM Personatge WHERE idFaccio = " + idFaccion + ";");

        System.out.println("Personajes de la facción con ID " + idFaccion + ":");

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        while (rs.next()) {
            System.out.print("    ");
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + ": " + rs.getString(i) + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
