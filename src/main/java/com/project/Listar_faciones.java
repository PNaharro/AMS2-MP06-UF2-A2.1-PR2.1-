package com.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Listar_faciones {
    public static void main(String[] args) throws SQLException {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "database.db";
        ResultSet rs = null;
        // Connectar (crea la BBDD si no existeix)
        Connection conn = UtilsSQLite.connect(filePath);

        // Llistar les taules
        ArrayList<String> taules = UtilsSQLite.listTables(conn);
        System.out.println(taules);


        // // SELECT a la base de dades
        rs = UtilsSQLite.querySelect(conn, "SELECT * FROM Facció;");
        System.out.println("Contingut de la taula:");
        while (rs.next()) {
            System.out.println("    " + rs.getInt("id") + ", " + rs.getString("nom"));
        }

        // // Actualitzar una fila
        // UtilsSQLite.queryUpdate(conn, "UPDATE warehouses SET name=\"MediaMarkt\" WHERE id=2;");

        // // Esborrar una fila
        // UtilsSQLite.queryUpdate(conn, "DELETE FROM warehouses WHERE id=3;");

        // // SELECT a la base de dades
        // rs = UtilsSQLite.querySelect(conn, "SELECT * FROM warehouses;");
        // System.out.println("Contingut de la taula modificada:");
        // while (rs.next()) {
        //     System.out.println("    " + rs.getInt("id") + ", " + rs.getString("name"));
        // }

        // Desconnectar
        UtilsSQLite.disconnect(conn);
    }
}
