/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.swing.ImageIcon;

/**
 *
 * @author Guada
 */
public class Interno {
    String apellido;
    String nombre;
    int dni;
    int edad;
    String apodo;
    String padre;
    String madre;
    boolean padre_vive;
    boolean madre_vive;
    String nacionalidad;
    String fecha_nac;
    String lugar_nac;
    String dom_legal;
    String dom_actual;
    String tel1;
    String tel2;
    String ocupacion;
    String estudios;
    String estado_civil;
    boolean sexo;
    boolean lee;
    boolean escribe;
    String rasgos;
    ImageIcon foto1;
    ImageIcon foto2;
    ImageIcon foto3;
    
    public Interno(){};
    
 

    public void setApellido(String s) {apellido = s;}
    public void setNombre(String s) {nombre = s;}
    public void setDni(int s) {dni = s;}
    public void setEdad(int s) {edad = s;}
    public void setApodo(String s) {apodo = s;}
    public void setPadre(String s) {padre = s;}
    public void setMadre(String s) {madre = s;}
    public void setPadre_vive(boolean s) {padre_vive = s;}
    public void setMadre_vive(boolean s) {madre_vive = s;}
    public void setNacionalidad(String s) {nacionalidad = s;}
    public void setFecha_nac(String f) {fecha_nac = f;}
    public void setLugar_nac(String l) {lugar_nac = l;}
    public void setDom_legal(String s) {dom_legal = s;}
    public void setDom_actual(String s) {dom_actual = s;}
    public void setTel1(String s) {tel1 = s;}
    public void setTel2(String s) {tel2 = s;}
    public void setOcupacion(String s) {ocupacion = s;}
    public void setEstudios(String s) {estudios = s;}
    public void setEstado_civil(String s) {estado_civil = s;}
    public void setSexo(boolean s) {sexo = s;}
    public void setLee(boolean s) {lee = s;}
    public void setEscribe(boolean s) {escribe = s;}
    public void setRasgos(String s) {rasgos = s;}
    public void setFoto1(ImageIcon f) {foto1 = f;}
    public void setFoto2(ImageIcon f) {foto2 = f;}
    public void setFoto3(ImageIcon f) {foto3 = f;}
    
    public String getApellido() {return apellido;}
    public String getNombre() {return nombre;}
    public int getDni() {return dni;}
    public int getEdad() {return edad;}
    public String getApodo() {return apodo;}
    public String getPadre() {return padre;}
    public String getMadre() {return madre;}
    public boolean getPadre_vive() {return padre_vive;}
    public boolean getMadre_vive() {return madre_vive;}
    public String getNacionalidad() {return nacionalidad;}
    public String getFecha_nac() {return fecha_nac;}
    public String getLugar_nac() {return lugar_nac;}
    public String getDom_legal() {return dom_legal;}
    public String getDom_actual() {return dom_actual;}
    public String getTel1() {return tel1;}
    public String getTel2() {return tel2;}
    public String getOcupacion() {return ocupacion;}
    public String getEstudios() {return estudios;}
    public String getEstado_civil() {return estado_civil;}
    public boolean getSexo() {return sexo;}
    public boolean getLee() {return lee;}
    public boolean getEscribe() {return escribe;}
    public String getRasgos() {return rasgos;}
    public ImageIcon getFoto1() {return foto1;}
    public ImageIcon getFoto2() {return foto2;}
    public ImageIcon getFoto3() {return foto3;}
}
