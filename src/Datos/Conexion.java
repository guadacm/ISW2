/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Guada
 */
public class Conexion {
    
    public static void main(String[] args) {
        String cadena = "jdbc:postgresql://localhost:5432/Penal";
        String user = "postgres";
        String pass = "carmen26";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(cadena, user, pass);
            java.sql.Statement st = conex.createStatement();
            String sql = "SELECT * FROM Interno ";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                String usuario = result.getString("nombre");
                String u = result.getString("apellido");
                String v = result.getString("sexo");
                System.out.println("User: " + usuario+" " +u+ " " + v);
            }
            result.close();
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }
}

