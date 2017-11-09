package Presentacion;

import Logica.Interno;
import Logica.Management;
import Logica.Registro;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Montenegro
 */
public class FichaInterno extends javax.swing.JPanel {

    /**
     * Creates new form FichaInterno
     */
    //Conexion con = Main.conexion;
    private Component rootPane;
    FileInputStream fis;
    int longitudBytes;
    private String nroInterno;
    private String stringDni;
    
    
    
    public FichaInterno() { //modificar
        initComponents();
        
    }
    
        public FichaInterno(int dni){ //alta
        initComponents();
        this.dni.setText(Integer.toString(dni));
        Guardar1.setEnabled(true);
        Cancelar2.setEnabled(true);
        cargarFoto.setEnabled(false);
        modificarDatos.setVisible(false);
        Actualizar1.setVisible(false);
        asignarCelda.setVisible(true);
        guardarCambios1raVez.setVisible(true);
        modificarAlbergue.setVisible(false);
        guardarCambios.setVisible(false);
        this.dni.setEditable(false);
    }
    
    
    public FichaInterno(String a) { //visualizar
        //String nroInterno="";
        stringDni=a;
        initComponents();
        String sql, sql2, albergue[] = new String[3];
        InputStream is;
        ImageIcon foto;
        asignarCelda.setVisible(false);
        guardarCambios1raVez.setVisible(false);
        modificarAlbergue.setVisible(true);
        guardarCambios.setVisible(true);
        
        sql = " select * from \"Interno\" where dni ="+a;
        
        jTextEditable(false);
               
        //recuperacion de datos personales
        try{
            ResultSet rs = Management.conexion.ejecutarSQLSelect(sql);
            //ResultSet rs = con.ejecutarSQLSelect(sql);
            while(rs.next()){ 
                nroInterno=(rs.getString(1));
                apellido.setText(rs.getString(2));
                nombre.setText(rs.getString(3));
                dni.setText(rs.getString(4));
                nacionalidad.setText(rs.getString(5));
                apodo.setText(rs.getString(6));
                padre.setText(rs.getString(7));
                madre.setText(rs.getString(8));
                if("t".equals(rs.getString(9)))padre_vive.setSelected(true); else padre_vive.setSelected(false);
                if("t".equals(rs.getString(10)))madre_vive.setSelected(true); else madre_vive.setSelected(false);                
                fec_nac.setText(rs.getString(11));
                lug_nac.setText(rs.getString(12));
                dom_leg.setText(rs.getString(13));
                dom_act.setText(rs.getString(14));
                tel1.setText(rs.getString(15));
                tel2.setText(rs.getString(16));
                ocupacion.setText(rs.getString(17));
                //sexo.removeAllItems();
                
                if("t".equals(rs.getString(26))) sexo.setSelectedItem("Femenino");
                if("f".equals(rs.getString(26))) sexo.setSelectedItem("Masculino");                
                //estudios.removeAllItems();
                estudios.setSelectedItem(rs.getString(18));
                //estado_civil.removeAllItems();
                estado_civil.setSelectedItem(rs.getString(19));
                if("t".equals(rs.getString(20)))lee.setSelected(true); else lee.setSelected(false);
                if("t".equals(rs.getString(21)))escribe.setSelected(true);else escribe.setSelected(false);
                rasgos.setText(rs.getString(22));
                                
                
                is = rs.getBinaryStream(23);               
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);                
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(210, 220, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon = new ImageIcon(newimg);                
                lblfoto.setIcon(newicon);
            }
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(rootPane,"exception: "+ex);
        }
        
        //recuperacion de datos de albergue
        try{
            sql2 = "select * from \"Albergue\" where \"nInterno\"="+nroInterno;
            //ResultSet rs = Management.consultarCelda(nroInterno);
            ResultSet rs1 = Management.conexion.ejecutarSQLSelect(sql2);
            while(rs1.next()){ 
                labelUnidad.setText(rs1.getString(2));       //unidad
                labelPabellon.setText(rs1.getString(3));     //pabellon
                labelCelda.setText(rs1.getString(4));        //celda
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"exception: "+ex);
        }
    }
    
        public void jTextEditable(boolean m){
        Cancelar2.setVisible(m);
        Guardar1.setVisible(m);
        Actualizar1.setVisible(m);
        cargarFoto.setVisible(m);
        nuevoIngreso.setVisible(m);
        apellido.setEditable(m);
        nombre.setEditable(m);
        dni.setEditable(m);
        nacionalidad.setEditable(m);
        apodo.setEditable(m);
        padre.setEditable(m);
        madre.setEditable(m);
        fec_nac.setEditable(m);
        lug_nac.setEditable(m);
        dom_leg.setEditable(m);
        dom_act.setEditable(m);
        tel1.setEditable(m);
        tel2.setEditable(m);
        ocupacion.setEditable(m);        
        rasgos.setEditable(m);
        sexo.setEnabled(m);
        estudios.setEnabled(m);
        estado_civil.setEnabled(m);
        lee.setEnabled(m);
        escribe.setEnabled(m);
        padre_vive.setEnabled(m);
        madre_vive.setEnabled(m);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_FichaInterno = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblfoto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tell2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        padre_vive = new javax.swing.JCheckBox();
        estudios = new javax.swing.JComboBox<>();
        estado_civil = new javax.swing.JComboBox<>();
        dni = new javax.swing.JTextField();
        tel1 = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        dom_act = new javax.swing.JTextField();
        apodo = new javax.swing.JTextField();
        nacionalidad = new javax.swing.JTextField();
        fec_nac = new javax.swing.JTextField();
        lug_nac = new javax.swing.JTextField();
        ocupacion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        nombre = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        dom_leg = new javax.swing.JTextField();
        madre = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cargarFoto = new javax.swing.JButton();
        modificarDatos = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        lee = new javax.swing.JCheckBox();
        escribe = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Guardar1 = new javax.swing.JButton();
        padre = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        madre_vive = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        rasgos = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        tel2 = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        Cancelar2 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        nuevoIngreso = new javax.swing.JButton();
        Actualizar1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tribunal = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        preventiva = new javax.swing.JTextArea();
        jSeparator8 = new javax.swing.JSeparator();
        autocaratulados = new javax.swing.JTextField();
        oficio = new javax.swing.JTextField();
        juzgado = new javax.swing.JTextField();
        m_condena = new javax.swing.JTextField();
        fechadeIngreso = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        l_condena = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        c_condena = new javax.swing.JTextField();
        Guardar2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        guardarCambios = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        boxCelda = new javax.swing.JComboBox<>();
        boxUnidad = new javax.swing.JComboBox<>();
        boxPabellon = new javax.swing.JComboBox<>();
        modificarAlbergue = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel42 = new javax.swing.JLabel();
        labelUnidad = new javax.swing.JLabel();
        labelCelda = new javax.swing.JLabel();
        labelPabellon = new javax.swing.JLabel();
        avisoAlbergue = new javax.swing.JLabel();
        asignarCelda = new javax.swing.JButton();
        guardarCambios1raVez = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1300, 651));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_FichaInterno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setLayout(null);

        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(lblfoto);
        lblfoto.setBounds(755, 11, 210, 220);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("* Apellidos:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(27, 11, 81, 20);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("* Nombres:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(392, 11, 86, 20);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Apodo:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(26, 39, 82, 20);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Madre:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(21, 345, 88, 14);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("* Nacionalidad:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 125, 88, 14);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("* Fecha Nacimiento:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(8, 157, 100, 20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("* Lugar Nacimiento:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(378, 135, 100, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText(" * Domicilio Legal:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(20, 197, 88, 20);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Domicilio Actual:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(20, 229, 88, 20);

        tell2.setText("Telefono 2:");
        jPanel1.add(tell2);
        tell2.setBounds(419, 374, 55, 20);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Ocupación:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(20, 311, 88, 20);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Estudios:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(20, 285, 88, 14);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Estado Civil:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(392, 103, 86, 20);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Rasgos:");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(20, 420, 88, 14);

        padre_vive.setText("Vive");
        jPanel1.add(padre_vive);
        padre_vive.setBounds(343, 373, 45, 23);

        estudios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primario Incompleto", "Primario Completo", "Secundario Incompleto", "Secundario Completo", "Terciario Incompleto", "Terciario Completo", "Universitario Incompleto", "Universitario Completo", " " }));
        estudios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estudiosActionPerformed(evt);
            }
        });
        jPanel1.add(estudios);
        estudios.setBounds(118, 282, 267, 20);

        estado_civil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero", "Casado", "Divorciado", "Viudo", " " }));
        estado_civil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estado_civilActionPerformed(evt);
            }
        });
        jPanel1.add(estado_civil);
        estado_civil.setBounds(488, 103, 220, 20);
        jPanel1.add(dni);
        dni.setBounds(118, 93, 200, 20);
        jPanel1.add(tel1);
        tel1.setBounds(496, 342, 221, 20);
        jPanel1.add(apellido);
        apellido.setBounds(118, 11, 200, 20);
        jPanel1.add(dom_act);
        dom_act.setBounds(118, 229, 590, 20);
        jPanel1.add(apodo);
        apodo.setBounds(118, 39, 200, 20);
        jPanel1.add(nacionalidad);
        nacionalidad.setBounds(118, 125, 200, 20);
        jPanel1.add(fec_nac);
        fec_nac.setBounds(118, 157, 200, 20);
        jPanel1.add(lug_nac);
        lug_nac.setBounds(488, 135, 220, 20);
        jPanel1.add(ocupacion);
        ocupacion.setBounds(118, 311, 267, 20);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 262, 698, 20);
        jPanel1.add(nombre);
        nombre.setBounds(488, 11, 220, 20);
        nombre.getAccessibleContext().setAccessibleName("");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("* DNI:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(20, 93, 88, 20);

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jPanel1.add(sexo);
        sexo.setBounds(488, 39, 220, 20);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("* Sexo:");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(392, 39, 86, 20);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(40, 67, 678, 20);
        jPanel1.add(dom_leg);
        dom_leg.setBounds(118, 197, 590, 20);
        jPanel1.add(madre);
        madre.setBounds(119, 342, 222, 20);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Edad Actual:");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(392, 167, 86, 20);

        cargarFoto.setText("Cargar Foto");
        cargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarFotoActionPerformed(evt);
            }
        });
        jPanel1.add(cargarFoto);
        cargarFoto.setBounds(780, 240, 160, 23);

        modificarDatos.setText("Modificar Datos");
        modificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(modificarDatos);
        modificarDatos.setBounds(780, 450, 160, 23);

        jLabel21.setText("00");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(488, 167, 220, 20);

        lee.setText("Sabe Leer");
        jPanel1.add(lee);
        lee.setBounds(453, 284, 73, 23);

        escribe.setText("Sabe Escribir");
        jPanel1.add(escribe);
        escribe.setBounds(558, 284, 110, 23);

        jButton3.setText("Foto3");
        jPanel1.add(jButton3);
        jButton3.setBounds(2734, 251, 61, 23);

        jButton4.setText("Foto1");
        jPanel1.add(jButton4);
        jButton4.setBounds(2586, 262, 61, 23);

        jButton5.setText("Foto2");
        jPanel1.add(jButton5);
        jButton5.setBounds(2660, 251, 61, 23);

        Guardar1.setText("Guardar Cambios");
        Guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar1ActionPerformed(evt);
            }
        });
        jPanel1.add(Guardar1);
        Guardar1.setBounds(780, 360, 160, 23);
        jPanel1.add(padre);
        padre.setBounds(118, 374, 223, 20);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Padre:");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(20, 377, 88, 14);

        madre_vive.setText("Vive");
        jPanel1.add(madre_vive);
        madre_vive.setBounds(343, 341, 45, 23);

        rasgos.setColumns(20);
        rasgos.setRows(5);
        jScrollPane2.setViewportView(rasgos);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(120, 420, 580, 65);

        jLabel28.setText("Telefono 1:");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(420, 345, 55, 14);
        jPanel1.add(tel2);
        tel2.setBounds(495, 374, 222, 20);
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(20, 410, 698, 20);

        Cancelar2.setText("Cancelar");
        Cancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar2ActionPerformed(evt);
            }
        });
        jPanel1.add(Cancelar2);
        Cancelar2.setBounds(780, 390, 160, 23);

        jLabel37.setText("(*) Campos Obligatorios");
        jPanel1.add(jLabel37);
        jLabel37.setBounds(30, 524, 115, 14);

        nuevoIngreso.setText("Nuevo Ingreso");
        nuevoIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(nuevoIngreso);
        nuevoIngreso.setBounds(780, 300, 160, 23);

        Actualizar1.setText("Actualizar Datos");
        Actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actualizar1ActionPerformed(evt);
            }
        });
        jPanel1.add(Actualizar1);
        Actualizar1.setBounds(780, 328, 160, 23);

        panel_FichaInterno.addTab("Datos                                ", jPanel1);

        jLabel9.setText("Fecha de Ingreso:");

        jLabel16.setText("Juzgado Interviniente:");

        jLabel17.setText("Oficio N°:");

        jLabel27.setText("Auto Caratulados:");

        jLabel29.setText("Preventiva:");

        jLabel30.setText("Tribunal que Condena:");

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Mitad de Condena:");

        jLabel32.setText("Libertad Condicional:");

        jLabel33.setText("Cumplimiento total de la Condena:");

        tribunal.setColumns(20);
        tribunal.setRows(5);
        jScrollPane1.setViewportView(tribunal);

        preventiva.setColumns(20);
        preventiva.setRows(5);
        jScrollPane3.setViewportView(preventiva);

        autocaratulados.setText(" ");

        oficio.setText(" ");

        juzgado.setText(" ");

        fechadeIngreso.setText(" ");

        jTextField6.setText("jTextField1");

        jTextField7.setText("jTextField1");

        jTextField8.setText("jTextField1");

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Libertad Condicional:");

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Cumplimiento total de la Condena:");

        Guardar2.setText("Guardar Cambios");
        Guardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(fechadeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(juzgado, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(oficio, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(autocaratulados, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(m_condena, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(l_condena, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(c_condena, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(830, 830, 830)
                .addComponent(Guardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addComponent(fechadeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel16))
                    .addComponent(juzgado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17))
                    .addComponent(oficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel27))
                    .addComponent(autocaratulados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_condena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(l_condena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(c_condena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(Guardar2)
                .addGap(1288, 1288, 1288)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel32))
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel33))
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_FichaInterno.addTab("Situacion Legal                        ", jPanel3);

        jLabel36.setText("Observaciones:");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel36)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2868, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addContainerGap(1775, Short.MAX_VALUE))
        );

        panel_FichaInterno.addTab("Observaciones                  ", jPanel4);

        jLabel5.setText("Unidad:");

        jLabel4.setText("Pabellón:");

        jLabel3.setText("Celda:");

        guardarCambios.setText("Guardar Cambios");
        guardarCambios.setEnabled(false);
        guardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarCambiosActionPerformed(evt);
            }
        });

        boxCelda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        boxCelda.setEnabled(false);

        boxUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N° 1 -- Penados Mayores", "N° 2 -- Procesados Mayores", "N° 3 -- Jóvenes Adultos", "N° 4 -- Mujeres", "N° 5 -- Alternativa" }));
        boxUnidad.setEnabled(false);
        boxUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxUnidadActionPerformed(evt);
            }
        });

        boxPabellon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "n" }));
        boxPabellon.setEnabled(false);

        modificarAlbergue.setText("Modificar");
        modificarAlbergue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarAlbergueActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Albergue Nuevo");

        jLabel39.setText("Unidad:");

        jLabel40.setText("Pabellón:");

        jLabel41.setText("Celda:");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Albergue Actual");

        labelUnidad.setText("...");

        labelCelda.setText("...");

        labelPabellon.setText("...");

        avisoAlbergue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        avisoAlbergue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        asignarCelda.setText("Asignar Celda");
        asignarCelda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarCeldaActionPerformed(evt);
            }
        });

        guardarCambios1raVez.setText("Guardar Cambios");
        guardarCambios1raVez.setEnabled(false);
        guardarCambios1raVez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarCambios1raVezActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel5)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(labelUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(jLabel39)
                                .addGap(18, 18, 18)
                                .addComponent(boxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(avisoAlbergue, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(labelPabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                        .addComponent(jSeparator4)
                                        .addComponent(jSeparator5))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(asignarCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(modificarAlbergue, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)))))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boxPabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jLabel41)
                                .addGap(18, 18, 18)
                                .addComponent(boxCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(guardarCambios1raVez, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(guardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator9, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                        .addComponent(jSeparator10)
                                        .addComponent(jSeparator11)))))))
                .addContainerGap(2899, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel42))
                    .addComponent(jLabel38))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelUnidad))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(labelPabellon))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(boxPabellon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelCelda))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxCelda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(guardarCambios)
                        .addComponent(guardarCambios1raVez))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(modificarAlbergue)
                        .addComponent(asignarCelda)))
                .addGap(37, 37, 37)
                .addComponent(avisoAlbergue, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_FichaInterno.addTab("Albergue                                ", jPanel5);

        add(panel_FichaInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 5, -1, -1));
        panel_FichaInterno.getAccessibleContext().setAccessibleName("Datos");
        panel_FichaInterno.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1369, 287, -1, -1));

        jLabel1.setText("Interno: ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 603, -1, -1));

        jLabel2.setText("Estado:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 603, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void guardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarCambiosActionPerformed
        String nuevaUnidad, nuevoPabellon, nuevaCelda, sql;
        nuevaUnidad=(String) boxUnidad.getSelectedItem();
        nuevoPabellon = (String) boxPabellon.getSelectedItem();
        nuevaCelda=(String) boxCelda.getSelectedItem();
        try{
            sql = "update \"Albergue\" set unidad='"+nuevaUnidad+"',pabellon='"+nuevoPabellon
                 +"', celda='"+nuevaCelda+"' where \"nInterno\"="+nroInterno;
            //ResultSet rs = Management.consultarCelda(nroInterno);
            //ResultSet rs = Management.conexion.ejecutarSQLSelect(sql);
            boolean rs = Management.conexion.ejecutarSQL(sql);
            
            if (rs==false) avisoAlbergue.setText("Asignacion de celda Exitosa");
            else if(rs==true) avisoAlbergue.setText("Opps, algo no va bien");
            /*while(rs1.next()){ 
                labelUnidad.setText(rs1.getString(2));       //unidad
                labelPabellon.setText(rs1.getString(3));     //pabellon
                labelCelda.setText(rs1.getString(4));        //celda
            }*/
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"exception: "+ex);
        }
        
        
        
    }//GEN-LAST:event_guardarCambiosActionPerformed

    private void Guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar1ActionPerformed
        Interno nuevo = new Interno();
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        
        nuevo.setApellido(apellido.getText());
        nuevo.setNombre(nombre.getText());
        nuevo.setApodo(apodo.getText());
        if("Masculino".equals((String)sexo.getSelectedItem())){
            nuevo.setSexo(false);
        }else {nuevo.setSexo(true);}
        nuevo.setDni(Integer.parseInt(dni.getText()));
        nuevo.setEstado_civil((String)estado_civil.getSelectedItem());
        nuevo.setNacionalidad(nacionalidad.getText());
        nuevo.setLugar_nac(lug_nac.getText());
        nuevo.setFecha_nac(fec_nac.getText());
        nuevo.setDom_legal(dom_leg.getText());
        nuevo.setDom_actual(dom_act.getText());
        nuevo.setEstudios((String)estudios.getSelectedItem());
        nuevo.setLee(lee.isSelected());
        nuevo.setEscribe(escribe.isSelected());
        nuevo.setOcupacion(ocupacion.getText());
        nuevo.setMadre(madre.getText());
        nuevo.setMadre_vive(madre_vive.isSelected());
        nuevo.setPadre(padre.getText());
        nuevo.setPadre_vive(padre_vive.isSelected());
        nuevo.setTel1(tel1.getText());
        nuevo.setTel2(tel2.getText());
        nuevo.setRasgos(rasgos.getText());
        
        Boolean b = Management.altaInterno(nuevo);
        if(b==true){            
            System.out.println("\nAlta exitosa");
            cargarFoto.setEnabled(true);
            Guardar1.setVisible(false);
            apellido.setEnabled(false);
            nombre.setEnabled(false);
            apodo.setEnabled(false);
            sexo.setEnabled(false);
            dni.setEnabled(false);
            nacionalidad.setEnabled(false);
            fec_nac.setEnabled(false);
            estado_civil.setEnabled(false);
            lug_nac.setEnabled(false);
            dom_leg.setEnabled(false);
            dom_act.setEnabled(false);
            estudios.setEnabled(false);
            lee.setEnabled(false);
            escribe.setEnabled(false);
            ocupacion.setEnabled(false);
            madre.setEnabled(false);
            padre.setEnabled(false);
            madre_vive.setEnabled(false);
            padre_vive.setEnabled(false);
            tel1.setEnabled(false);
            tel2.setEnabled(false);
            rasgos.setEnabled(false);
            JOptionPane.showMessageDialog(rootPane,"Ingresado correctamente!");
        }
    }//GEN-LAST:event_Guardar1ActionPerformed

    private void boxUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxUnidadActionPerformed
        String opcion = boxUnidad.getSelectedItem().toString();
    if ("N° 1 -- Penados Mayores".equals(opcion)){
        boxPabellon.removeAllItems();
        boxPabellon.addItem("a");
        boxPabellon.addItem("b");
        boxPabellon.addItem("c");
        boxPabellon.addItem("d");
        boxPabellon.addItem("e");
        boxPabellon.addItem("f");
        boxPabellon.addItem("g");
        boxPabellon.addItem("h");
        boxPabellon.addItem("i");
        boxPabellon.addItem("j");
        boxPabellon.addItem("n");
        boxCelda.removeAllItems();
        boxCelda.addItem("1");
        boxCelda.addItem("2");
        boxCelda.addItem("3");
        boxCelda.addItem("4");
        boxCelda.addItem("5");
        boxCelda.addItem("6");
        boxCelda.addItem("7");
        boxCelda.addItem("8");
        boxCelda.addItem("9");
        boxCelda.addItem("10");
        boxCelda.addItem("11");
        boxCelda.addItem("12");
    }
        
    if ("N° 2 -- Procesados Mayores".equals(opcion)){
        boxPabellon.removeAllItems();
        boxPabellon.addItem("a");
        boxPabellon.addItem("b");
        boxPabellon.addItem("c");
        boxPabellon.addItem("d");
        boxPabellon.addItem("e");
        boxPabellon.addItem("f");
        boxPabellon.addItem("g");
        boxPabellon.addItem("h");
        boxPabellon.addItem("i");
        boxPabellon.addItem("j");
        boxPabellon.addItem("k");
        boxCelda.removeAllItems();
        boxCelda.addItem("1");
        boxCelda.addItem("2");
        boxCelda.addItem("3");
        boxCelda.addItem("4");
        boxCelda.addItem("5");
        boxCelda.addItem("6");
        boxCelda.addItem("7");
        boxCelda.addItem("8");
        boxCelda.addItem("9");
        boxCelda.addItem("10");
        boxCelda.addItem("11");
        boxCelda.addItem("12");
        
    }
        
    if ("N° 3 -- Jóvenes Adultos".equals(opcion)){
        boxPabellon.removeAllItems();
        boxPabellon.addItem("a");
        boxPabellon.addItem("b");
        boxPabellon.addItem("c");
        boxPabellon.addItem("d");
        boxPabellon.addItem("refugiados");
        boxCelda.removeAllItems();
        boxCelda.addItem("1");
        boxCelda.addItem("2");
        boxCelda.addItem("3");
        boxCelda.addItem("4");
        boxCelda.addItem("5");
        boxCelda.addItem("6");
        boxCelda.addItem("7");
        boxCelda.addItem("8");
        boxCelda.addItem("9");
        boxCelda.addItem("10");
        boxCelda.addItem("11");
        boxCelda.addItem("12");
        
    }
    if ("N° 4 -- Mujeres".equals(opcion)){
        boxPabellon.removeAllItems();
        boxPabellon.addItem("Procesadas");
        boxPabellon.addItem("Penadas");
        boxPabellon.addItem("Aislamiento");
        boxPabellon.addItem("Madres");
        boxCelda.removeAllItems();
        boxCelda.addItem("1");
        boxCelda.addItem("2");
        boxCelda.addItem("3");
        boxCelda.addItem("4");
        boxCelda.addItem("5");
        boxCelda.addItem("6");
        boxCelda.addItem("7");
        boxCelda.addItem("8");
        boxCelda.addItem("9");
        boxCelda.addItem("10");
        boxCelda.addItem("11");
        boxCelda.addItem("12");
        
    }
    if ("N° 5 -- Alternativa".equals(opcion)){
        boxPabellon.removeAllItems();
        boxPabellon.addItem("Policiales");
        boxPabellon.addItem("Militares");
        boxPabellon.addItem("Politicos");
        boxCelda.removeAllItems();
        boxCelda.addItem("1");
        boxCelda.addItem("2");
        boxCelda.addItem("3");
        boxCelda.addItem("4");
        boxCelda.addItem("5");
        boxCelda.addItem("6");
        
    }
        
        
    }//GEN-LAST:event_boxUnidadActionPerformed

    private void modificarAlbergueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarAlbergueActionPerformed
        boxUnidad.setEnabled(true);
        boxPabellon.setEnabled(true);
        boxCelda.setEnabled(true);
        modificarAlbergue.setEnabled(false);
        guardarCambios.setEnabled(true);
    }//GEN-LAST:event_modificarAlbergueActionPerformed

    private void modificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarDatosActionPerformed
        jTextEditable(true);   
        modificarDatos.setVisible(false); 
        nuevoIngreso.setVisible(false);
        Guardar1.setVisible(false);
    }//GEN-LAST:event_modificarDatosActionPerformed

    private void Cancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_Cancelar2ActionPerformed

    private void nuevoIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoIngresoActionPerformed
        panel_FichaInterno.setSelectedIndex(1);
        
    }//GEN-LAST:event_nuevoIngresoActionPerformed

    private void Actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actualizar1ActionPerformed
       Interno updateInterno = new Interno();
        
        updateInterno.setApellido(apellido.getText());
        updateInterno.setNombre(nombre.getText());
        updateInterno.setDni(Integer.parseInt(dni.getText()));
        updateInterno.setEstado_civil((String) estado_civil.getSelectedItem());
        updateInterno.setNacionalidad(nacionalidad.getText());        
        updateInterno.setApodo(apodo.getText());    
        if(sexo.getSelectedItem() == "Masculino") updateInterno.setSexo(false);
        if(sexo.getSelectedItem() == "Femenino") updateInterno.setSexo(true);
        updateInterno.setPadre(padre.getText());   
        updateInterno.setMadre(madre.getText());  
        updateInterno.setPadre_vive(padre_vive.isSelected());
        updateInterno.setMadre_vive(madre_vive.isSelected());
        updateInterno.setFecha_nac(fec_nac.getText());
        updateInterno.setLugar_nac(lug_nac.getText());
        updateInterno.setDom_legal(dom_leg.getText());
        updateInterno.setDom_actual(dom_act.getText());
        updateInterno.setEstudios((String) estudios.getSelectedItem());
        updateInterno.setTel1(tel1.getText());
        updateInterno.setTel2(tel2.getText());
        updateInterno.setOcupacion(ocupacion.getText());
        updateInterno.setLee(lee.isSelected());
        updateInterno.setEscribe(escribe.isSelected());
        updateInterno.setRasgos(rasgos.getText());   
        
        Boolean b = Management.modificarInterno(updateInterno);
        if(b){
            System.out.println("Modificacion Exitosa!");
            jTextEditable(false);
            JOptionPane.showMessageDialog(rootPane,"Actualizado correctamente!");
        }
        
               
    }//GEN-LAST:event_Actualizar1ActionPerformed

    private void cargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarFotoActionPerformed
        lblfoto.setIcon(null);
        JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado=j.showOpenDialog(null);
        if(estado== JFileChooser.APPROVE_OPTION){
            try{
                fis=new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes=(int)j.getSelectedFile().length();
                try {
                    Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance
                            (lblfoto.getWidth(),lblfoto.getHeight(),Image.SCALE_DEFAULT);
                    lblfoto.setIcon(new ImageIcon(icono));
                    lblfoto.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
            try{
            String sql="update \"Interno\" set foto1= ? "
                    + "where dni="+Integer.parseInt(dni.getText())+" and nacionalidad='"+nacionalidad.getText()+"'";

            Boolean b = Management.agregarFoto(sql,fis,longitudBytes);
            if(b==true){
                System.out.println("\nAlta exitosa");
                cargarFoto.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane,"Guardado correctamente");
                
            }            
            
            
        }catch(NumberFormatException | HeadlessException x){
            JOptionPane.showMessageDialog(rootPane, "exception 2 "+x);
        }           // TODO add your handling code here:
        }        // TODO add your handling code here:
        
    }//GEN-LAST:event_cargarFotoActionPerformed

    private void estado_civilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estado_civilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estado_civilActionPerformed

    private void estudiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estudiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estudiosActionPerformed

    private void asignarCeldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarCeldaActionPerformed
        boxUnidad.setEnabled(true);
        boxPabellon.setEnabled(true);
        boxCelda.setEnabled(true);
        modificarAlbergue.setEnabled(false);
        guardarCambios1raVez.setEnabled(true);
    }//GEN-LAST:event_asignarCeldaActionPerformed

    private void guardarCambios1raVezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarCambios1raVezActionPerformed
        String nuevaUnidad, nuevoPabellon, nuevaCelda, sql;
        nuevaUnidad=(String) boxUnidad.getSelectedItem();
        nuevoPabellon = (String) boxPabellon.getSelectedItem();
        nuevaCelda=(String) boxCelda.getSelectedItem();
        ResultSet val;
        
        try{
             val = Management.consultarInternoDNI(Integer.parseInt(dni.getText()));
             while(val.next()){ 
                nroInterno=(val.getString(1));
        }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"exception: "+ex);
        }
        System.out.println("nro interno: "+nroInterno);
        
        
        try{    
            sql = "insert into \"Albergue\" (\"nInterno\", \"unidad\", \"pabellon\", \"celda\") "
                + "Values ("+nroInterno+", '"+nuevaUnidad+"', '"+nuevoPabellon+"', '"+nuevaCelda+"');";
            //ResultSet rs = Management.consultarCelda(nroInterno);
            //ResultSet rs = Management.conexion.ejecutarSQLSelect(sql);
            boolean rs = Management.conexion.ejecutarSQL(sql);
            
            if (rs==false) avisoAlbergue.setText("Modificacion de celda Exitosa");
            else if(rs==true) avisoAlbergue.setText("Opps, algo no va bien");
            /*while(rs1.next()){ 
                labelUnidad.setText(rs1.getString(2));       //unidad
                labelPabellon.setText(rs1.getString(3));     //pabellon
                labelCelda.setText(rs1.getString(4));        //celda
            }*/
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"exception: "+ex);
        }
    }//GEN-LAST:event_guardarCambios1raVezActionPerformed

    private void Guardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar2ActionPerformed
        Registro nuevo = new Registro();

        
        /*nuevo.setCausa((String)autocaratulados.getText());
        nuevo.setFecha_ingreso(fechadeIngreso.getText());
        nuevo.setFecha_egreso(fechadeEgreso.getText());
        nuevo.setApodo(apodo.getText());
        if("Masculino".equals((String)sexo.getSelectedItem())){
            nuevo.setSexo(false);
        }else {nuevo.setSexo(true);}
        nuevo.setDni(Integer.parseInt(dni.getText()));
        nuevo.setEstado_civil((String)estado_civil.getSelectedItem());
        nuevo.setNacionalidad(nacionalidad.getText());
        nuevo.setLugar_nac(lug_nac.getText());        
        nuevo.setFecha_nac(fec_nac.getText());
        nuevo.setDom_legal(dom_leg.getText());
        nuevo.setDom_actual(dom_act.getText());
        nuevo.setEstudios((String)estudios.getSelectedItem());
        nuevo.setOcupacion(ocupacion.getText());
        nuevo.setMadre(madre.getText());
        nuevo.setPadre(padre.getText());
        nuevo.setTel1(tel1.getText());
        nuevo.setTel2(tel2.getText());
        nuevo.setRasgos(rasgos.getText());*/
        
        //Boolean b = Management.altaInterno(nuevo);
    }//GEN-LAST:event_Guardar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Actualizar1;
    public static javax.swing.JButton Cancelar2;
    public static javax.swing.JButton Guardar1;
    public static javax.swing.JButton Guardar2;
    private javax.swing.JTextField apellido;
    private javax.swing.JTextField apodo;
    private javax.swing.JButton asignarCelda;
    private javax.swing.JTextField autocaratulados;
    private javax.swing.JLabel avisoAlbergue;
    public static javax.swing.JComboBox<String> boxCelda;
    public static javax.swing.JComboBox<String> boxPabellon;
    public static javax.swing.JComboBox<String> boxUnidad;
    private javax.swing.JTextField c_condena;
    public static javax.swing.JButton cargarFoto;
    private javax.swing.JTextField dni;
    private javax.swing.JTextField dom_act;
    private javax.swing.JTextField dom_leg;
    private javax.swing.JCheckBox escribe;
    private javax.swing.JComboBox<String> estado_civil;
    private javax.swing.JComboBox<String> estudios;
    private javax.swing.JTextField fec_nac;
    private javax.swing.JTextField fechadeIngreso;
    private javax.swing.JButton guardarCambios;
    private javax.swing.JButton guardarCambios1raVez;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField juzgado;
    private javax.swing.JTextField l_condena;
    private javax.swing.JLabel labelCelda;
    private javax.swing.JLabel labelPabellon;
    private javax.swing.JLabel labelUnidad;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JCheckBox lee;
    private javax.swing.JTextField lug_nac;
    private javax.swing.JTextField m_condena;
    private javax.swing.JTextField madre;
    private javax.swing.JCheckBox madre_vive;
    private javax.swing.JButton modificarAlbergue;
    public static javax.swing.JButton modificarDatos;
    private javax.swing.JTextField nacionalidad;
    private javax.swing.JTextField nombre;
    public static javax.swing.JButton nuevoIngreso;
    private javax.swing.JTextField ocupacion;
    private javax.swing.JTextField oficio;
    private javax.swing.JTextField padre;
    private javax.swing.JCheckBox padre_vive;
    public static javax.swing.JTabbedPane panel_FichaInterno;
    private javax.swing.JTextArea preventiva;
    private javax.swing.JTextArea rasgos;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JTextField tel1;
    private javax.swing.JTextField tel2;
    private javax.swing.JLabel tell2;
    private javax.swing.JTextArea tribunal;
    // End of variables declaration//GEN-END:variables

}
