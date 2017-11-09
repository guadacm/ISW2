package Presentacion;

import Datos.Conexion;
import Logica.Management;

public class Main {
    public static Conexion conexion = new Conexion();
    
    public static void main(String[] args) {
        //System.out.println("Conectado: "+conexion.crearConexion());
        //if(conexion.crearConexion()){
        if(Management.crearConexion()){    
            //Ventana v = new Ventana();
            NuevoDiseño v = new NuevoDiseño();
            v.setVisible(true);
        }
    }
}
