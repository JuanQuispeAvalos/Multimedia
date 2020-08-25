/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author josue
 */
public class Conexion {

    private static Connection cnx;

    public static Connection conectar() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnx = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=FileUpload;user=sa; password=sa");
        } catch (SQLException e) {
            System.out.println("ERROR" + e.getMessage());
        }
        return cnx;
    }

    public void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Conexion.conectar();
        if (Conexion.cnx != null) {
            System.out.println("eureka!!!");
        } else {
            System.out.println("Error :(");
        }
    }
}
