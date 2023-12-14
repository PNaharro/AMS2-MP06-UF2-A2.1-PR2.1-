package com.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Listar_personajes {
    public static void main(String[] args) throws SQLException {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "database.db";
        ResultSet rs = null;
        // Connectar (crea la BBDD si no existeix)
        Connection conn = UtilsSQLite.connect(filePath);

        // Llistar les taules
        ArrayList<String> taules = UtilsSQLite.listTables(conn);
        System.out.println(taules);




        // Demanar informació de la taula
        // rs = UtilsSQLite.querySelect(conn, "SELECT * FROM warehouses;");
        // ResultSetMetaData rsmd = rs.getMetaData();
        // System.out.println("Informació de la taula:");
        // for (int cnt = 1; cnt < rsmd.getColumnCount(); cnt = cnt + 1) { 
        //     // Les columnes començen a 1, no hi ha columna 0!
        //     String label = rsmd.getColumnLabel(cnt);
        //     String name = rsmd.getColumnName(cnt);
        //     int type = rsmd.getColumnType(cnt);
        //     System.out.println("    " + label + ", " + name + ", " + type);
        // }

        // // SELECT a la base de dades
        // rs = UtilsSQLite.querySelect(conn, "SELECT * FROM warehouses;");
        // System.out.println("Contingut de la taula:");
        // while (rs.next()) {
        //     System.out.println("    " + rs.getInt("id") + ", " + rs.getString("name"));
        // }

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
