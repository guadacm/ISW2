package Logica;

/**
 * 
 * @authors  MEDINA, Guadalupe
 *           MONTENEGRO, Luis
 */
public class Registro {
    String causa;
    String fecha_ingreso;
    String fecha_egreso;
    String tipo_egreso;
    String observaciones;
    
    public Registro(){};
    

    
    public void setCausa(String s){causa=s;};
    public void setFecha_ingreso(String s){fecha_ingreso=s;};
    public void setFecha_egreso(String s){fecha_egreso=s;};
    public void setTipo_egreso(String s){tipo_egreso=s;};
    public void setObservaciones(String s){observaciones=s;};
    
    public String getCausa(){return causa;}
    public String getFecha_ingreso(){return fecha_ingreso;};
    public String getFecha_egreso(){return fecha_egreso;};
    public String getTipo_egreso(){return tipo_egreso;};
    public String getObservaciones(){return observaciones;};
    
}
