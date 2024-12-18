/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.Admin;

import Models.ActividadColonia;
import Models.Colonia;
import Controller.ActividadColoniaDAO;
import java.util.List;
import javax.swing.table.*;


/**
 *
 * @author gerar
 */
public class ListActivitiesColonies extends javax.swing.JPanel {

    ActividadColoniaDAO activityCD = new ActividadColoniaDAO();

    /**
     * Creates new form ListUsers
     */
    public ListActivitiesColonies() {
        initComponents();
        showActivities();
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
        listUsersTitle.setText("CATÁLOGO DE ACTIVIDADES POR COLONIA");

        activityColoniesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre de la Actividad", "Colonia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(listUsersTitle)))
                .addContainerGap(80, Short.MAX_VALUE))
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

    private void showActivities() {
        List<ActividadColonia> actividadesColonia = activityCD.obtenerActividadesColonia();
        DefaultTableModel model = (DefaultTableModel) activityColoniesTable.getModel();
        model.setRowCount(0);

        // Iterar sobre cada ActividadColonia
        for (ActividadColonia actividadColonia : actividadesColonia) {
            // Para cada colonia asociada a la actividad, agregar una fila
            for (Colonia colonia : actividadColonia.getColonias()) {
                Object[] fila = {
                    actividadColonia.getActividad().getDescripcion(), 
                    colonia.getNombre() 
                };
                model.addRow(fila);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable activityColoniesTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listUsersTitle;
    // End of variables declaration//GEN-END:variables
}
