package com.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MostrarMillorDefensorPerFaccio {

    public static void main(String[] args) throws SQLException {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "database.db";
        ResultSet rs = null;
   
        Connection conn = UtilsSQLite.connect(filePath);
        for (int i = 0; i<4;i++){
            int idFaccion = i+1;
            mostrarMillorDefensorPerFaccio(conn, idFaccion); 
        }
        UtilsSQLite.disconnect(conn);
    }

    static void mostrarMillorDefensorPerFaccio(Connection conn, int idFaccion) throws SQLException {
        ResultSet rs = UtilsSQLite.querySelect(conn,
                "SELECT * FROM Personatge WHERE idFaccio = " + idFaccion + " ORDER BY defensa DESC LIMIT 1;");
        System.out.println("Millor Defensor de la Facció " + idFaccion + ":");

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        if (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + ": " + rs.getString(i) + ", ");
            }
            System.out.println();
        } else {
            System.out.println("No hay información disponible para la facción " + idFaccion);
        }

        System.out.println();
    }
}
