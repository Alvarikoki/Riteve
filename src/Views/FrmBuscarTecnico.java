
package Views;

import Controller.TecnicoController;
import Models.DTO.TecnicoDto;
import Models.Tecnico;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Álvaro Álvarez R
 */
public class FrmBuscarTecnico extends javax.swing.JFrame {

    /**
     * Creates new form FrmBuscarTecnico
     */
    
    private TecnicoController controller;
    private FrmTecnicos frm;
    
    public FrmBuscarTecnico() {
        initComponents();
        controller = new TecnicoController(this);
        this.mostrarTodo();
        
    }
    
    public void mostrarTodo() {
        ArrayList<Tecnico> array = controller.readAll();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Fecha de Nacimiento");
        model.addColumn("Telefono");
        model.addColumn("Correo");
        model.addColumn("Salario");
        
        for (Tecnico dto : array){
            Object[] fila = {dto.getId(),dto.getNombre(),dto.getFechaNacimiento(),dto.getTelefono(),dto.getEmail(),dto.getSalario()};
            model.addRow(fila);
        }
        table.setModel(model);
    }

    public void setFrm(FrmTecnicos frm) {
        this.frm = frm;
    }
    
    public void moverArriba(int fila) {
        if (fila >= 0 && fila < table.getRowCount()) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Vector<Object> vec = new Vector<>();
            for (int col = 0; col < model.getColumnCount(); col++) {
                vec.add(model.getValueAt(fila, col));
            }
        model.removeRow(fila);
        model.insertRow(0, vec);
        table.setRowSelectionInterval(0, 0);
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

        jFrame1 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSi = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        btnSi1 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel3.setText("TECNICOS");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel4.setText("Buscar Técnicos");

        btnSi.setForeground(new java.awt.Color(153, 255, 153));
        btnSi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/controlar.png"))); // NOI18N
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });

        btnNo.setForeground(new java.awt.Color(255, 51, 51));
        btnNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cruz.png"))); // NOI18N
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });

        btnSi1.setForeground(new java.awt.Color(153, 255, 153));
        btnSi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cerrar.png"))); // NOI18N
        btnSi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSi1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSi1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(btnSi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(156, 156, 156)
                    .addComponent(jLabel3)
                    .addContainerGap(156, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSi1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(176, 176, 176)
                    .addComponent(jLabel3)
                    .addContainerGap(178, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        int row = table.getSelectedRow();
            if (row != -1) {
                String id = table.getValueAt(row, 0).toString();
                String nombre = table.getValueAt(row, 1).toString();
                Object fechaObject = table.getValueAt(row, 2);
                java.sql.Date fecha = null;
                if (fechaObject instanceof java.util.Date) {
                    java.util.Date fechaUtil = (java.util.Date) fechaObject;
                    fecha = new java.sql.Date(fechaUtil.getTime());
                }
                String tel = table.getValueAt(row, 3).toString();
                String correo = table.getValueAt(row, 4).toString();
                Double salario = Double.valueOf(table.getValueAt(row, 5).toString());
                Tecnico tec = new Tecnico(id,nombre,fecha,tel,correo,salario,10);
                frm.llenarCampos(tec);
                txtId.setText(id);
                //frm.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this,"Selecciona un campo", "Error",JOptionPane.ERROR_MESSAGE);
            }        
    }//GEN-LAST:event_btnSiActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnNoActionPerformed

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        String id = txtId.getText();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        for (int i = 0; i < table.getRowCount(); i++) {
            String idd = table.getValueAt(i, 0).toString();
            if(id.equals(idd)){
                this.moverArriba(i);
            break;
            }
        }
    }//GEN-LAST:event_txtIdKeyReleased

    private void btnSi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSi1ActionPerformed
        int row = table.getSelectedRow();
        if (row != -1) {
            String idd = table.getValueAt(row, 0).toString();
            FrmContra contra = new FrmContra();
            contra.setPass(controller.read(idd).getPassword());
            contra.setId(idd);
            contra.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this,"Selecciona un campo", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSi1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBuscarTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBuscarTecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JButton btnSi1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
