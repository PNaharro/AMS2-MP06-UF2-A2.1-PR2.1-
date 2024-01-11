package com.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MostrarMillorAtacantPerFaccio {

    public static void main(String[] args) throws SQLException {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "database.db";
        ResultSet rs = null;
        Connection conn = UtilsSQLite.connect(filePath);

        mostrarMillorAtacantPerFaccio(conn, "Cavalleros"); 
        mostrarMillorAtacantPerFaccio(conn, "Vikingos"); 
        mostrarMillorAtacantPerFaccio(conn, "Samurais"); 
        mostrarMillorAtacantPerFaccio(conn, "Wu lin"); 

        UtilsSQLite.disconnect(conn);
    }

    static void mostrarMillorAtacantPerFaccio(Connection conn, String nomFaccio) throws SQLException {
        ResultSet rs = UtilsSQLite.querySelect(conn,
                "SELECT * FROM Personatge WHERE idFaccio = (SELECT id FROM Facció WHERE nom = '" + nomFaccio + "') ORDER BY atac DESC LIMIT 1;");
        
        displayTableContent(rs, "Millor Atacant de " + nomFaccio);
    }

    static void displayTableContent(ResultSet rs, String tableName) throws SQLException {
        System.out.println("Contenido de " + tableName + ":");

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

