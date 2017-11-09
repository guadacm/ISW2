/**
 *
 * @authors MEDINA, Guadalupe 
 *          MONTENEGRO, Luis
 */
package Logica;

import Datos.Conexion;
import java.awt.Component;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Management {
    public static Conexion conexion = new Conexion();
    private static Component rootPane;
    
    public static boolean crearConexion(){
        return conexion.crearConexion();
    }
    
        
    public static ResultSet consultarInternoDNI(int dni) {
        String cons = " select * from \"Interno\" where dni =" + dni;
        ResultSet rs;
        try {
            rs = conexion.ejecutarSQLSelect(cons); 
            System.out.println(rs);
            return rs;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "exception: " + ex);
            return null;
        }
    }
    
    public static boolean altaInterno(Interno nuevo){
        String cons = " insert into \"Interno\" (\"apellido\",\"nombre\",\"dni\",\"nacionalidad\",\"apodo\",\"padre\",\"madre\",\"padre_vive\",\"madre_vive\",\n" +
                "\"fecha_nac\",\"lugar_nac\",\"dom_legal\",\"dom_actual\",\"tel_1\",\"tel_2\",\"ocupacion\",\"estudios\",\"estado_civil\",\n" +
                "\"lee\",\"escribe\",\"rasgos\",\"sexo\")"
                + " values('"+nuevo.getApellido()+ "','" //2
                +nuevo.getNombre()+ "'," //3
                +nuevo.getDni()+ ",'" //4
                +nuevo.getNacionalidad()+ "','" //5
                +nuevo.getApodo()+ "','" //6
                +nuevo.getPadre()+ "','" //7
                +nuevo.getMadre()+ "'," //8
                +nuevo.getPadre_vive()+ "," //9
                +nuevo.getMadre_vive()+ ",'" //10
                +nuevo.getFecha_nac()+ "','" //11
                +nuevo.getLugar_nac()+ "','" //12
                +nuevo.getDom_legal()+ "','" //13
                +nuevo.getDom_actual()+ "','" //14
                +nuevo.getTel1()+ "','" //15
                +nuevo.getTel2()+ "','" //16
                +nuevo.getOcupacion()+ "','" //17
                +nuevo.getEstudios()+ "','" //18
                +nuevo.getEstado_civil()+ "'," //19
                +nuevo.getLee()+ "," //20
                +nuevo.getEscribe()+ ",'" //21
                +nuevo.getRasgos()+ "',"
                +nuevo.getSexo()+ ");"; 
        Boolean b;
        try {
            b = conexion.ejecutarSQL(cons); 
            System.out.println("true insert");
            
            return true;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "exception: " + ex);
            System.out.println("false insert");
            return false;
        }
    }
    
    public static boolean modificarInterno(Interno update){
        String cons = " update \"Interno\" "
                + "  set apellido='"+update.getApellido()+"', "
                + "  dni="+update.getDni()+","
                + "  nacionalidad='"+update.getNacionalidad()+ "',"
                + "  apodo='"+update.getApodo()+ "',"
                + "  padre='"+update.getPadre()+ "',"
                + "  madre='"+update.getMadre()+ "'," //8
                + "  padre_vive="+update.getPadre_vive()+ "," //9
                + "  madre_vive="+update.getMadre_vive()+ "," //10
                + "  fecha_nac='"+update.getFecha_nac()+ "'," //11
                + "  lugar_nac='"+update.getLugar_nac()+ "'," //12
                + "  dom_legal='"+update.getDom_legal()+ "'," //13
                + "  dom_actual='"+update.getDom_actual()+ "'," //14
                + "  tel_1='"+update.getTel1()+ "'," //15
                + "  tel_2='"+update.getTel2()+ "'," //16
                + "  ocupacion='"+update.getOcupacion()+ "'," //17
                + "  estudios='"+update.getEstudios()+ "'," //18
                + "  estado_civil='"+update.getEstado_civil()+ "'," //19
                + "  lee="+update.getLee()+ "," //20
                + "  escribe="+update.getEscribe()+ "," //21
                + "  rasgos='"+update.getRasgos()+ "',"
                + "  sexo="+update.getSexo()+ ", "
                + "  nombre='"+update.getNombre()+ "'" //3
                //+ "  where \"nInterno\"=1;";
                + " where dni="+update.getDni()+" and nacionalidad= '"+update.getNacionalidad()+"';";
                   System.out.println("apodo: "+update.getApodo());
                   System.out.println("padre: "+update.getPadre());
                
                //= dni="+update.getDni()+" and nacionalidad='"+update.getNacionalidad()+"';"; 
        Boolean b;
        try {
            b = conexion.ejecutarSQL(cons); 
            System.out.println("true update");
            
            return true;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "exception: " + ex);
            System.out.println("false update");
            return false;
        }
    }
    
        public static boolean agregarFoto(String sql,FileInputStream fis,int longitudBytes){
        try{
            PreparedStatement ps=conexion.getConexion().prepareStatement(sql);        
            ps.setBinaryStream(1,fis,longitudBytes);
            ps.execute();
            ps.close();                       
            //JOptionPane.showMessageDialog(rootPane,"Guardado correctamente");
            return true; 
            
        }catch(SQLException | NumberFormatException | HeadlessException x){
            //JOptionPane.showMessageDialog(rootPane, "exception 2 "+x);
            return false;
        }
        
    }
    
    public static ResultSet consultarCelda(String nroInterno){
        ResultSet rs = null;
        String ar[] = new String[3];
        String cons = "select * from \"Albergue\" "
                     +"where \"nInterno\"="+nroInterno;
        try {
            rs = conexion.ejecutarSQLSelect(cons); 
            //System.out.println(rs);
            /*while (rs.next()) {
                ar[0]=(rs.getString(2)); //unidad
                ar[1]=(rs.getString(3)); //pabellon
                ar[3]=(rs.getString(4)); //celda
            }*/
            
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "exception: " + ex);
        }
        return rs;
    }   
    
    public static void asignarCelda(int nroInterno, String unidad, String pabellon, int celda){
        String cons = "insert into \"Albergue\" "
                    + "VALUES ( "+nroInterno+",'"+unidad+"','"+pabellon+"',"+celda+");";
    }
    
   
}
