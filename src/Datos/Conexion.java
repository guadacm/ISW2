/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guada
 */
public class Conexion {
    
        private Connection conexion = null;
    
    public Connection getConexion()
    {
       return conexion;
    }
    
    public boolean crearConexion()
    {
       try {
          Class.forName("org.postgresql.Driver");
          conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Penal","postgres","carmen26");
          if(conexion!=null){
              System.out.println("conexion exitosa");
              return true;
          }
       }
       catch (SQLException ex) {
          System.out.println("error en conexion: "+ex);
       }
       catch (ClassNotFoundException ex) {
          System.out.println(ex);
       }
       return false;
    }
    
    public boolean ejecutarSQL(String sql)
    {
       try {
          PreparedStatement sentencia = conexion.prepareStatement(sql);
          sentencia.executeQuery();
          return true;
       } catch (SQLException ex) {
            return false;
       }
    } 
    
    public ResultSet ejecutarSQLSelect(String sql)
    {
       ResultSet resultado;
       try {
          PreparedStatement sentencia = conexion.prepareStatement(sql);
          resultado = sentencia.executeQuery();
          return resultado;
       } catch (SQLException ex) {
          System.err.println("Error "+ex);
          return null;
       }
    }
}
    
/*    public static void main(String[] args) {
        String cadena = "jdbc:postgresql://localhost:5432/Penal";
        String user = "postgres"; //"luiis11";
        String pass = "12345";//"bocajuniots11";

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
}*/

