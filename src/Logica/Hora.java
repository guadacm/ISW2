package Logica;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class Hora extends Thread{
    private JLabel etiqueta;
    public Hora(JLabel etiqueta){
       this.etiqueta = etiqueta;
    }

    @Override
    public void run(){
        while(true){
           Date hoy = new Date();
           SimpleDateFormat sdf = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy ' - ' HH:mm:ss");
           etiqueta.setText(sdf.format(hoy));
           try{
              sleep(1000); //Segundo a segundo... 
           }catch(Exception e){
              e.getMessage();
           }
       }
   }
    
    public int obtenerAnio(){
        int anio;
        Date hoy = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        anio = Integer.parseInt((String)sdf.format(hoy));
        return anio;
    }
}