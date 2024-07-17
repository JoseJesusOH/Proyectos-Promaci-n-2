/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazUsuario;
import control.Control;
import java.awt.Dimension;
import java.awt.Point;
import objetosNegocio.Libro;
import javax.swing.DefaultComboBoxModel; 
import javax.swing.JFrame;
import objetosServicios.*;
/**
 *
 * @author jvale
 */
public class DlgLibro extends javax.swing.JDialog {

    /**
     * Creates new form DlgLibro
     */
    public DlgLibro(java.awt.Frame parent,String title, boolean modal, Libro libro, int operacion,StringBuffer respuesta) {
        super(parent, modal);
        initComponents();
        this.libro=libro;
        this.operacion=operacion;
        this.respuesta=respuesta;
        centraCuadroDialogo(parent); 
        // Modifica el título del botón botonAceptar y establece si los 
        // botones botonRestaurar y botonCancelar estarán habilitados. 
        // Si la operación es agregar 
        if(operacion == ConstantesGUI.AGREGAR) 
        botonAceptar.setText("Aceptar"); 
        // Si la operación es actualizar 
        else if(operacion == ConstantesGUI.ACTUALIZAR) 
        botonAceptar.setText("Actualizar"); 
        // Si la operación es eliminar 
        else if(operacion == ConstantesGUI.ELIMINAR) { 
        botonAceptar.setText("Eliminar"); 
        botonRestaurar.setEnabled(false); 
        } 
        // Si la operación es desplegar 
        else if(operacion == ConstantesGUI.DESPLEGAR) { 
        botonAceptar.setText("Continuar"); 
        botonRestaurar.setEnabled(false); 
        botonCancelar.setEnabled(false); 
        }
        // Despliega el isbn del libro 
        campoTextoIsbn.setText(libro.getIsbn()); 
        // Si la operación es de actualizar, eliminar o desplegar, 
        if((operacion == ConstantesGUI.ELIMINAR) || 
        (operacion == ConstantesGUI.ACTUALIZAR) || 
        (operacion == ConstantesGUI.DESPLEGAR)) { 
        // despliega el resto de los datos del libro 
        campoTextoTitulo.setText(libro.getTitulo()); 
        campoTextoEditorial.setText(libro.getEditorial()); 
        campoTextoClasificacion.setText(libro.getClasificacion()); 
        campoTextoAutor.setText(libro.getAutor());
        campoTextoEdicion.setText(libro.getEdicion());  
        // Si la operación es de eliminar o desplegar 
        if((operacion == ConstantesGUI.ELIMINAR) || 
        (operacion == ConstantesGUI.DESPLEGAR)) { 
        // hace los campos de texto de sólo lectura 
        campoTextoIsbn.setEditable(false); 
        campoTextoTitulo.setEditable(false); 
        campoTextoEditorial.setEditable(false);
        campoTextoClasificacion.setEditable(false); 
        campoTextoAutor.setEditable(false);
        campoTextoEdicion.setEditable(false);
        }
        // Establece el valor por omisión para respuesta, por si se cierra el 
        // cuadro de diálogo presionando el botón cerrar o el botón cancelar 
        respuesta.append(ConstantesGUI.CANCELAR); 
        // centra el cuadro de dialogo sobre la ventana de la aplicación 
        

        // Muestra el cuadro de diálogo 
       
 } 
 setVisible(true);

    }
    /** 
        * Este método centra el cuadro de dialogo sobre la ventana de la 
        * aplicación. 
        * @param parent Ventana sobre la que aparecerá el cuadro de diálogo 
        */ 
        private void centraCuadroDialogo(java.awt.Frame parent) { 
        // Obtiene el tamaño y posición de la ventana de la aplicación 
        Dimension frameSize = parent.getSize(); 
        Point loc = parent.getLocation(); 
        // Obtiene el tamaño del cuadro de diálogo 
        Dimension dlgSize = getPreferredSize(); 

        // Centra el cuadro de diálogo sobre la ventana padre 
        setLocation( (frameSize.width - dlgSize.width) / 2 + loc.x, 
        (frameSize.height - dlgSize.height) / 2 + loc.y); 
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoTextoIsbn = new javax.swing.JTextField();
        campoTextoTitulo = new javax.swing.JTextField();
        campoTextoEditorial = new javax.swing.JTextField();
        campoTextoClasificacion = new javax.swing.JTextField();
        campoTextoAutor = new javax.swing.JTextField();
        campoTextoEdicion = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonRestaurar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Captura datos libros");

        jLabel1.setText("ISBN");

        jLabel2.setText("Título");

        jLabel3.setText("Editorial");

        jLabel4.setText("Clasificacion");

        jLabel5.setText("Autor");

        jLabel6.setText("Edición");

        campoTextoIsbn.setEditable(false);
        campoTextoIsbn.setColumns(10);
        campoTextoIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoIsbnActionPerformed(evt);
            }
        });

        campoTextoTitulo.setColumns(10);

        campoTextoEditorial.setColumns(10);

        campoTextoClasificacion.setColumns(10);
        campoTextoClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoClasificacionActionPerformed(evt);
            }
        });

        campoTextoAutor.setColumns(10);

        campoTextoEdicion.setColumns(10);

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonRestaurar.setText("Restaurar");
        botonRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestaurarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTextoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTextoEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTextoClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTextoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTextoEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(botonRestaurar)
                        .addGap(70, 70, 70)
                        .addComponent(botonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoTextoIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoTextoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoTextoEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoTextoClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoTextoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoTextoEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonRestaurar)
                    .addComponent(botonCancelar))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoTextoIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoIsbnActionPerformed

    private void campoTextoClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoClasificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoClasificacionActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
       // Si la operación es Agregar o Actualizar 
        if((operacion == ConstantesGUI.AGREGAR) || 
        (operacion == ConstantesGUI.ACTUALIZAR)) { 
        // Toma los valores capturados en los campos de texto y en la caja 
        // combinada y almacénalos en el parametro libro. 
        libro.setTitulo(campoTextoTitulo.getText()); 
        libro.setEditorial(campoTextoEditorial.getText()); 
        libro.setClasificacion(campoTextoClasificacion.getText());
        libro.setAutor(campoTextoAutor.getText()); 
        libro.setEdicion(campoTextoEdicion.getText());
        
        } 
        // Borra el contenido de respuesta 
        respuesta.delete(0, respuesta.length()); 
        // Establece que se presionó el botón botonAceptar 
        respuesta.append(ConstantesGUI.ACEPTAR); 
        // Destruye el cuadro de díalogo 
        dispose(); 

    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaurarActionPerformed
        // Restaura el contenido de los campos de texto a su valor original 
        // Si la operación es Agregar 
        if(operacion == ConstantesGUI.AGREGAR) { 
        campoTextoTitulo.setText(""); 
        campoTextoEditorial.setText(""); 
        campoTextoClasificacion.setText("");
        campoTextoAutor.setText(""); 
        campoTextoEdicion.setText("");
        }
        if(operacion == ConstantesGUI.ACTUALIZAR) { 
        campoTextoTitulo.setText(libro.getTitulo()); 
        campoTextoEditorial.setText(libro.getEditorial()); 
        campoTextoClasificacion.setText(libro.getClasificacion());
        campoTextoAutor.setText(libro.getAutor()); 
        campoTextoEdicion.setText(libro.getEdicion());
        }
    }//GEN-LAST:event_botonRestaurarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonRestaurar;
    private javax.swing.JTextField campoTextoAutor;
    private javax.swing.JTextField campoTextoClasificacion;
    private javax.swing.JTextField campoTextoEdicion;
    private javax.swing.JTextField campoTextoEditorial;
    private javax.swing.JTextField campoTextoIsbn;
    private javax.swing.JTextField campoTextoTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
    private Libro libro; 
    private int operacion; 
    private StringBuffer respuesta;
    Control control;
}