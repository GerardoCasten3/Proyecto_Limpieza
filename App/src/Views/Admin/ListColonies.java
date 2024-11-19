/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.Admin;

import Models.Colonia;
import Controller.ColoniasDAO;
import java.util.List;
import javax.swing.table.*;


/**
 *
 * @author gerar
 */
public class ListColonies extends javax.swing.JPanel {

    ColoniasDAO colDAO = new ColoniasDAO();

    /**
     * Creates new form ListUsers
     */
    public ListColonies() {
        initComponents();
        showColonies();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listUsersTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activityColoniesTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1200, 777));
        setRequestFocusEnabled(false);

        listUsersTitle.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        listUsersTitle.setText("CATÁLOGO DE COLONIAS");

        activityColoniesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID de Colonia", "Colonia", "Código Postal", "Asentamiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(activityColoniesTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listUsersTitle)
                .addGap(428, 428, 428))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(listUsersTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void showColonies() {
        List<Colonia> colonies = colDAO.obtenerTodasLasColonias();
        DefaultTableModel model = (DefaultTableModel) activityColoniesTable.getModel();
        model.setRowCount(0);

        for (Colonia colonia : colonies) {
           Object[] row = {
               colonia.getId_colonia(),
               colonia.getNombre(),
               colonia.getCodigoPostal(),
               colonia.getTipoAsentamiento()
           };
           model.addRow(row);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable activityColoniesTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listUsersTitle;
    // End of variables declaration//GEN-END:variables
}
