/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Formularios;

import SQL.Conexion_BD;
import java.awt.Component;
import SQL.Metodos_SQL;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author BRANDON
 */
public class Pnl_eliminar_profesor extends javax.swing.JPanel {

    /**
     * Creates new form Pnl_eliminar_profesor
     */
    public Pnl_eliminar_profesor() {
        initComponents();
        bloquear();
    }
    private static Connection conexion;
    private static PreparedStatement sentencia_preparada;
    private static ResultSet resultado;
    
    Metodos_SQL metodos_sql = new Metodos_SQL();
    
    public void bloquear(){
        for (Component a :pnl_eliminacion_datos.getComponents()) {
            a.setEnabled(false);
            
        }
        for(Component b : pnl_opciones_eliminar.getComponents()){
            b.setEnabled(false);
        }
        
    }
    
    public void desbloquear(){
         for (Component a :pnl_eliminacion_datos.getComponents()) {
            a.setEnabled(true);
            
        }
        for(Component b : pnl_opciones_eliminar.getComponents()){
            b.setEnabled(true);
        }
    }
    
    public void limpiar(){
        lblApellidoMEliminar.setText("---");
        lblApellidoPEliminar.setText("---");
        lblCarreraEliminar.setText("---");
        lblEmailEliminar.setText("---");
        lblGradoEstudioEliminar.setText("---");
        lblIdEliminar.setText("---");
        lblMateriasEliminar.setText("---");
        lblNombreEliminar.setText("---");
        lblNumeroEmpleadoEliminar.setText("---");
        lblRfcEliminar.setText("---");
        
        
    }
    
    public void buscarEliminarProfesor(String curp){
        try {
            conexion = Conexion_BD.conectar();
            String sql_busqueda_eliminacion = "SELECT + FROM profesor WHERE curp = ?";
            sentencia_preparada = conexion.prepareStatement(sql_busqueda_eliminacion);
            sentencia_preparada.setString(6, curp);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                lblMensajeEliminar.setText("¡ATENCION: CURP REGISTRADO!");
                lblNombreEliminar.setText(resultado.getString("nombre"));
                lblApellidoPEliminar.setText(resultado.getString("apellido_p"));
                lblApellidoMEliminar.setText(resultado.getString("apellido_m"));
                lblIdEliminar.setText(resultado.getString("id"));
                lblEmailEliminar.setText(resultado.getString("email"));
                lblGradoEstudioEliminar.setText(resultado.getString("grado_estudio"));
                lblRfcEliminar.setText(resultado.getString("rfc"));
                lblMateriasEliminar.setText(resultado.getString("materias"));
                lblCarreraEliminar.setText(resultado.getString("carrera"));
                desbloquear();
                
                
            }else{
                lblMensajeEliminar.setText("Sin resultados en la busqueda filtrada");
                bloquear();
                limpiar();
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Erro: "  + e);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Pnl_eliminar_profesor.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: " + ex);
            }
        }
        limpiarcaja();
    }
    
    public void limpiarcaja(){
        if (txtCurpBuscarEliminar.getText().isEmpty()) {
            lblMensajeEliminar.setText("");
            limpiar();
        }
    }
    
    public void eliminarProfesorPregunta(){
        int pregunta;
        pregunta = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar el profesor de la Base De Datos?","Confirmar Borrado",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (pregunta == 0) {
            metodos_sql.eliminarProfesor(txtCurpBuscarEliminar.getText());
            txtCurpBuscarEliminar.setText("");
            limpiar();
            limpiarcaja();
            bloquear();
        }   
    }
    
    public void clausula_caja_texto(java.awt.event.KeyEvent evt){
        Character  a = evt.getKeyChar();
        if (Character.isLetter(a)) {
            evt.setKeyChar(Character.toUpperCase(a));
        }
        if (txtCurpBuscarEliminar.getText().length()>= 18 ) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnl_eliminacion_datos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblNumeroEmpleadoEliminar = new javax.swing.JLabel();
        lblNombreEliminar = new javax.swing.JLabel();
        lblApellidoPEliminar = new javax.swing.JLabel();
        lblApellidoMEliminar = new javax.swing.JLabel();
        lblIdEliminar = new javax.swing.JLabel();
        lblEmailEliminar = new javax.swing.JLabel();
        lblGradoEstudioEliminar = new javax.swing.JLabel();
        lblRfcEliminar = new javax.swing.JLabel();
        lblMateriasEliminar = new javax.swing.JLabel();
        lblCarreraEliminar = new javax.swing.JLabel();
        pnl_opciones_eliminar = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtCurpEliminar = new javax.swing.JLabel();
        lblMensajeEliminar = new javax.swing.JLabel();
        txtCurpBuscarEliminar = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Baja de profesor");

        pnl_eliminacion_datos.setBackground(new java.awt.Color(255, 255, 255));
        pnl_eliminacion_datos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inserte datos del profesor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Numero de empleado:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Apellido Paterno:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Apellido Materno:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("ID");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Grado de estudios:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("RFC:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Materias:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Carrera:");

        lblNumeroEmpleadoEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblNumeroEmpleadoEliminar.setText("---");

        lblNombreEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblNombreEliminar.setText("---");

        lblApellidoPEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblApellidoPEliminar.setText("---");

        lblApellidoMEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblApellidoMEliminar.setText("---");

        lblIdEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblIdEliminar.setText("---");

        lblEmailEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblEmailEliminar.setText("---");

        lblGradoEstudioEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblGradoEstudioEliminar.setText("---");

        lblRfcEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblRfcEliminar.setText("---");

        lblMateriasEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblMateriasEliminar.setText("---");

        lblCarreraEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCarreraEliminar.setText("---");

        javax.swing.GroupLayout pnl_eliminacion_datosLayout = new javax.swing.GroupLayout(pnl_eliminacion_datos);
        pnl_eliminacion_datos.setLayout(pnl_eliminacion_datosLayout);
        pnl_eliminacion_datosLayout.setHorizontalGroup(
            pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_eliminacion_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_eliminacion_datosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(173, 173, 173)
                        .addComponent(lblCarreraEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMateriasEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRfcEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(lblGradoEstudioEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEmailEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIdEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblApellidoMEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblApellidoPEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                        .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNumeroEmpleadoEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(lblNombreEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(118, 118, 118))
        );
        pnl_eliminacion_datosLayout.setVerticalGroup(
            pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_eliminacion_datosLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                        .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                                .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                                        .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_eliminacion_datosLayout.createSequentialGroup()
                                                .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel3)
                                                    .addComponent(lblNumeroEmpleadoEliminar))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5))
                                            .addComponent(lblNombreEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4))
                                    .addComponent(lblApellidoPEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addComponent(lblApellidoMEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblIdEliminar))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblEmailEliminar))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addComponent(lblGradoEstudioEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21)
                .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblRfcEliminar))
                .addGap(18, 18, 18)
                .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblMateriasEliminar))
                .addGap(18, 18, 18)
                .addGroup(pnl_eliminacion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(lblCarreraEliminar))
                .addGap(31, 31, 31))
        );

        pnl_opciones_eliminar.setBackground(new java.awt.Color(255, 255, 255));
        pnl_opciones_eliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar Profesor");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton1.setText("Reiniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_opciones_eliminarLayout = new javax.swing.GroupLayout(pnl_opciones_eliminar);
        pnl_opciones_eliminar.setLayout(pnl_opciones_eliminarLayout);
        pnl_opciones_eliminarLayout.setHorizontalGroup(
            pnl_opciones_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opciones_eliminarLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(pnl_opciones_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        pnl_opciones_eliminarLayout.setVerticalGroup(
            pnl_opciones_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opciones_eliminarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("Inserte el CURP para eliminar datos: ");

        txtCurpEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        lblMensajeEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblMensajeEliminar.setText("---");

        txtCurpBuscarEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCurpBuscarEliminarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCurpBuscarEliminarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnl_eliminacion_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(pnl_opciones_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCurpEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCurpBuscarEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblMensajeEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtCurpEliminar)
                    .addComponent(lblMensajeEliminar)
                    .addComponent(txtCurpBuscarEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_eliminacion_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_opciones_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarProfesorPregunta();
        

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCurpBuscarEliminarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurpBuscarEliminarKeyTyped
        // TODO add your handling code here:
        
         clausula_caja_texto(evt);
    }//GEN-LAST:event_txtCurpBuscarEliminarKeyTyped

    private void txtCurpBuscarEliminarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurpBuscarEliminarKeyReleased
        // TODO add your handling code here:
         
         buscarEliminarProfesor(txtCurpBuscarEliminar.getText());
    }//GEN-LAST:event_txtCurpBuscarEliminarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtCurpBuscarEliminar.setText("");
        limpiarcaja();
        limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidoMEliminar;
    private javax.swing.JLabel lblApellidoPEliminar;
    private javax.swing.JLabel lblCarreraEliminar;
    private javax.swing.JLabel lblEmailEliminar;
    private javax.swing.JLabel lblGradoEstudioEliminar;
    private javax.swing.JLabel lblIdEliminar;
    private javax.swing.JLabel lblMateriasEliminar;
    private javax.swing.JLabel lblMensajeEliminar;
    private javax.swing.JLabel lblNombreEliminar;
    private javax.swing.JLabel lblNumeroEmpleadoEliminar;
    private javax.swing.JLabel lblRfcEliminar;
    private javax.swing.JPanel pnl_eliminacion_datos;
    private javax.swing.JPanel pnl_opciones_eliminar;
    public javax.swing.JTextField txtCurpBuscarEliminar;
    private javax.swing.JLabel txtCurpEliminar;
    // End of variables declaration//GEN-END:variables
}
