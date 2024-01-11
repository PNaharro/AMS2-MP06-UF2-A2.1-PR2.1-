package com.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
        System.out.println(taules.get(1));
        displayTableContent(conn,taules.get(1));
      
        UtilsSQLite.disconnect(conn);
    }
     static void displayTableContent(Connection conn, String tableName) throws SQLException {
        ResultSet rs = UtilsSQLite.querySelect(conn, "SELECT * FROM " + tableName + ";");
        System.out.println("Content of " + tableName + ":");

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
