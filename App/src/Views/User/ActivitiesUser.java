/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.User;

import Models.*;
import Controller.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.*;


/**
 *
 * @author gerar
 */
public class ActivitiesUser extends javax.swing.JPanel {

    ActividadLimpiezaDAO actDAO = new ActividadLimpiezaDAO();
    EmpleadoDAO empDAO = new EmpleadoDAO();


    /**
     * Creates new form ListUsers
     */
    public ActivitiesUser() {
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
        activityTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 777));
        setRequestFocusEnabled(false);

        listUsersTitle.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        listUsersTitle.setText("ACTIVIDADES");

        activityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID de Actividad", "Descripción", "Fecha", "Retroalimentación", "Evidencia", "Cuadrilla", "Completado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(activityTable);

        jPanel1.setBackground(new java.awt.Color(33, 58, 87));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel2.setText("SISTEMA DE LIMPIEZA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(402, 402, 402))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(522, 522, 522)
                .addComponent(listUsersTitle)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listUsersTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
    }// </editor-fold>//GEN-END:initComponents
  
    private void showActivities() {
        Usuario usuario = Sesion.getInstance().getUsuarioActivo();
        Empleado empleado = empDAO.obtenerEmpleadoPorIdUsuario(usuario.getId_usuario());
        List<ActividadLimpieza> actividad = actDAO.obtenerActividadesPorIdCuadrilla(empleado.getCuadrilla().getId_cuadrilla());
        DefaultTableModel model = (DefaultTableModel) activityTable.getModel();
        model.setRowCount(0);

        for (ActividadLimpieza act : actividad) {
            Object[] row = {
                act.getId_actividad(),
                act.getDescripcion(),
                act.getFecha(),
                act.getRetroalimentacion(),
                act.getImagenEvidencia(), // Ruta de la imagen
                act.getCuadrilla().getNombre(),
                act.isTerminado()
            };
            model.addRow(row);
        }

        // Configurar renderizador para la columna de imágenes
        activityTable.setRowHeight(80);
        configureTableRenderer();
    }

    public class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {
            JLabel label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            if (value != null) {
                String imagePath = value.toString();
                File imageFile = new File(imagePath);

                // Verificar si la imagen existe como ruta absoluta o relativa
                if (!imageFile.exists()) {
                    imagePath = System.getProperty("user.dir") + "/" + imagePath;
                    imageFile = new File(imagePath);
                }

                if (imageFile.exists()) {
                    ImageIcon icon = new ImageIcon(imagePath);
                    // Escalar la imagen si es necesario
                    Image scaledImage = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(scaledImage));
                } else {
                    label.setText("Imagen no encontrada");
                }
            }
            return label;
        }
    }

    private void configureTableRenderer() {
        activityTable.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer());
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable activityTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listUsersTitle;
    // End of variables declaration//GEN-END:variables
}