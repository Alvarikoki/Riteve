package Views;

import Controller.VehiculosController;
import Models.Hilo;

import Models.Vehiculo;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Duarte Garcia
 */
public class FrmVehiculos extends javax.swing.JFrame {

    private VehiculosController controller;
    private Hilo hl;
    private Thread hilo;
    private FrmVehiculos frm;

    /**
     * Creates new form FrmVehiculos
     */
    public FrmVehiculos() {
        initComponents();
        controller = new VehiculosController(this);
        this.mostrarTodo();
        hl = new Hilo(this);
        hilo = new Thread(hl);
        hilo.start();
    }

    public void mostrarTodo() {
        ArrayList<Vehiculo> array = controller.readAll();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Placa");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("FechaInscripcion");
        model.addColumn("Antiguedad");
        model.addColumn("IdDueño");
        model.addColumn("NombreDueño");
        model.addColumn("Año");
        for (Vehiculo v : array) {
            Object[] fila = {
                v.getPlaca(),
                v.getMarca(),
                v.getModelo(),
                v.getFechaInscripcion(),
                v.getEdad(),
                v.getIdDueño(),
                v.getNombreDueño(),
                v.getAño()
            };
            model.addRow(fila);
        }
        tblVehiculos.setModel(model);
    }
    public void llenarCampos(Vehiculo obj){
        txtPlaca.setText(obj.getPlaca());
        txtMarca.setText(obj.getMarca());
        txtModelo.setText(obj.getModelo());
        spinV.setValue(obj.getFechaInscripcion());
        txtDueño.setText(obj.getIdDueño());
        txtNombreDueño.setText(obj.getNombreDueño());
        txtAño.setText(String.valueOf(obj.getAño()));
     
        revalidate();
        repaint();
    }
    public void moverArriba(int fila) {
        if (fila >= 0 && fila < tblVehiculos.getRowCount()) {
            DefaultTableModel model = (DefaultTableModel) tblVehiculos.getModel();
            Vector<Object> vec = new Vector<>();
            for (int col = 0; col < model.getColumnCount(); col++) {
                vec.add(model.getValueAt(fila, col));
            }
            model.removeRow(fila);
            model.insertRow(0, vec);
            tblVehiculos.setRowSelectionInterval(0, 0);
        }
    }

    public void msj(String msj, int tipo) {
        if (tipo == 1) {
            JOptionPane.showMessageDialog(rootPane, msj, "Notificación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, msj, "Error", JOptionPane.ERROR_MESSAGE);
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

        btnAgregar = new javax.swing.JButton();
        txtPlaca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtDueño = new javax.swing.JTextField();
        txtAño = new javax.swing.JTextField();
        txtNombreDueño = new javax.swing.JTextField();
        spinV = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        spinV.setModel(new javax.swing.SpinnerDateModel());

        jLabel1.setText("Placa");

        jLabel2.setText("Cedula Dueño");

        jLabel3.setText("Marca");

        jLabel4.setText("Modelo");

        jLabel5.setText("Fecha");

        jLabel6.setText("Nombre del Dueño");

        jLabel7.setText("Año");

        jLabel8.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel8.setText("VEHÍCULOS");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/update.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Placa", "Marca", "Modelo", "Cedula Dueño", "Nombre Dueño", "Año", "Antiguedad", "Fecha Inscripcion"
            }
        ));
        jScrollPane1.setViewportView(tblVehiculos);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/escoba2.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cruz.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(jLabel8)
                .addGap(315, 315, 315)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addGap(252, 252, 252)
                .addComponent(jLabel4)
                .addGap(229, 229, 229)
                .addComponent(jLabel6)
                .addGap(99, 99, 99)
                .addComponent(jLabel7))
            .addGroup(layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel3))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(txtDueño, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(txtNombreDueño, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(spinV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnBuscar)
                .addGap(36, 36, 36)
                .addComponent(btnActualizar)
                .addGap(36, 36, 36)
                .addComponent(btnEliminar)
                .addGap(36, 36, 36)
                .addComponent(btnLimpiar)
                .addGap(46, 46, 46)
                .addComponent(jButton2))
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jButton1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreDueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel5)))
                .addGap(4, 4, 4)
                .addComponent(spinV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton2)))
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        Object valorSeleccionado = spinV.getValue();
        if (valorSeleccionado instanceof java.util.Date) {
            java.util.Date fechaUtil = (java.util.Date) valorSeleccionado;
            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());
            //String placa, String marca, String modelo, Date fechaInscripcion, String id, String nombre, int año
            Vehiculo vh = new Vehiculo(txtPlaca.getText(), txtMarca.getText(), txtModelo.getText(), fechaSQL, txtDueño.getText(), txtNombreDueño.getText(), Integer.parseInt(txtAño.getText()));
            controller.add(vh);
            JOptionPane.showMessageDialog(this, "Se agregó correctamente", "Agregado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtPlaca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite la placa para buscar");
        } else {
            String pc = txtPlaca.getText();
            tblVehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            for (int i = 0; i < tblVehiculos.getRowCount(); i++) {
                String placa = tblVehiculos.getValueAt(i, 0).toString();
                if (pc.equals(placa)) {
                    this.moverArriba(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtDueño.setText("");
        txtNombreDueño.setText("");
        txtAño.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (txtPlaca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite la placa para eliminar");

        } else {
            controller.delete(txtPlaca.getText());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed

    }//GEN-LAST:event_txtPlacaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = tblVehiculos.getSelectedRow();
            if (row != -1) {
                String placa = tblVehiculos.getValueAt(row, 0).toString();
                String marca = tblVehiculos.getValueAt(row, 1).toString();
                String modelo = tblVehiculos.getValueAt(row, 2).toString();
                Object fechaObject = tblVehiculos.getValueAt(row, 3);
                java.sql.Date fecha = null;
                if (fechaObject instanceof java.util.Date) {
                    java.util.Date fechaUtil = (java.util.Date) fechaObject;
                    fecha = new java.sql.Date(fechaUtil.getTime());
                }
                String IdDueño="",nombreD="";
                int año=0;
                try{
                 IdDueño = tblVehiculos.getValueAt(row, 4).toString();
                 nombreD = tblVehiculos.getValueAt(row, 5).toString();
                  año = Integer.parseInt(tblVehiculos.getValueAt(row, 6).toString());
                }catch (Exception ex){
                    System.out.println("ERROR CON EL CASTING");
                }
               //String placa, String marca, String modelo, Date fechaInscripcion, String id, String nombre, int año
                Vehiculo vh = new Vehiculo(placa,marca,modelo,fecha,IdDueño,nombreD,año);
                frm.llenarCampos(vh);
                txtPlaca.setText(placa);
                //frm.setVisible(true);
            
            }         
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVehiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSpinner spinV;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtDueño;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombreDueño;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
