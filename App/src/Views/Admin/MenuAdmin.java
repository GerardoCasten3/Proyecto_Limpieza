/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views.Admin;

import javax.swing.JOptionPane;
import Controller.Sesion;
import Models.Usuario;
import Views.Login;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author gerar
 */
public class MenuAdmin extends javax.swing.JFrame {

    Sesion sesion = Sesion.getInstance();

    /**
     * Creates new form Content
     */
    public MenuAdmin() {
        if (sesion.estaAutenticado()) {
            initComponents();
            Dashboard top = new Dashboard();
            showPanel(top);
        }
        else{
            JOptionPane.showMessageDialog(null, "Debes estar autenticado para acceder a estas características.", "No has iniciado sesión.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
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

        jMenu1 = new javax.swing.JMenu();
        PanelContent = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        topMenu = new javax.swing.JMenu();
        topMenuItem = new javax.swing.JMenuItem();
        userMenu = new javax.swing.JMenu();
        adminUsersItem = new javax.swing.JMenuItem();
        listUsersItem = new javax.swing.JMenuItem();
        employeesMenu = new javax.swing.JMenu();
        adminEmployeesItem = new javax.swing.JMenuItem();
        listEmployeesItem = new javax.swing.JMenuItem();
        squadMenu = new javax.swing.JMenu();
        adminSquadsItem = new javax.swing.JMenuItem();
        listSquadsItem = new javax.swing.JMenuItem();
        activitiesMenu = new javax.swing.JMenu();
        adminActivitiesItem = new javax.swing.JMenuItem();
        listActivitiesItem = new javax.swing.JMenuItem();
        ActivitiesColonies = new javax.swing.JMenuItem();
        colonyMenu = new javax.swing.JMenu();
        adminColoniesItem = new javax.swing.JMenuItem();
        listColoniesItem = new javax.swing.JMenuItem();
        sessionItem = new javax.swing.JMenu();
        closeSessionItem = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelContent.setPreferredSize(new java.awt.Dimension(1200, 800));

        javax.swing.GroupLayout PanelContentLayout = new javax.swing.GroupLayout(PanelContent);
        PanelContent.setLayout(PanelContentLayout);
        PanelContentLayout.setHorizontalGroup(
            PanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        PanelContentLayout.setVerticalGroup(
            PanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        topMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/top.png"))); // NOI18N
        topMenu.setText("Inicio");

        topMenuItem.setText("Inicio/Dashboard");
        topMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topMenuItemActionPerformed(evt);
            }
        });
        topMenu.add(topMenuItem);

        jMenuBar1.add(topMenu);

        userMenu.setBackground(new java.awt.Color(11, 100, 119));
        userMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users.png"))); // NOI18N
        userMenu.setText("Usuarios");

        adminUsersItem.setText("Administrar Usuarios");
        adminUsersItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminUsersItemActionPerformed(evt);
            }
        });
        userMenu.add(adminUsersItem);

        listUsersItem.setText("Listar Usuarios");
        listUsersItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listUsersItemActionPerformed(evt);
            }
        });
        userMenu.add(listUsersItem);

        jMenuBar1.add(userMenu);

        employeesMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/employees.png"))); // NOI18N
        employeesMenu.setText("Empleados");

        adminEmployeesItem.setText("Administrar Empleados");
        adminEmployeesItem.setToolTipText("");
        adminEmployeesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminEmployeesItemActionPerformed(evt);
            }
        });
        employeesMenu.add(adminEmployeesItem);

        listEmployeesItem.setText("Listar Empleados");
        listEmployeesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listEmployeesItemActionPerformed(evt);
            }
        });
        employeesMenu.add(listEmployeesItem);

        jMenuBar1.add(employeesMenu);

        squadMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/squads.png"))); // NOI18N
        squadMenu.setText("Cuadrillas");

        adminSquadsItem.setText("Administrar Cuadrillas");
        adminSquadsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminSquadsItemActionPerformed(evt);
            }
        });
        squadMenu.add(adminSquadsItem);

        listSquadsItem.setText("Listar Cuadrillas");
        listSquadsItem.setToolTipText("");
        listSquadsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listSquadsItemActionPerformed(evt);
            }
        });
        squadMenu.add(listSquadsItem);

        jMenuBar1.add(squadMenu);

        activitiesMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/activities.png"))); // NOI18N
        activitiesMenu.setText("Actividades");
        activitiesMenu.setToolTipText("");

        adminActivitiesItem.setText("Administrar Actividades");
        adminActivitiesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActivitiesItemActionPerformed(evt);
            }
        });
        activitiesMenu.add(adminActivitiesItem);

        listActivitiesItem.setText("Listar Actividades");
        listActivitiesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listActivitiesItemActionPerformed(evt);
            }
        });
        activitiesMenu.add(listActivitiesItem);

        ActivitiesColonies.setText("Listar Actividades y Colonias");
        ActivitiesColonies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivitiesColoniesActionPerformed(evt);
            }
        });
        activitiesMenu.add(ActivitiesColonies);

        jMenuBar1.add(activitiesMenu);

        colonyMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/colonies.png"))); // NOI18N
        colonyMenu.setText("Colonias");

        adminColoniesItem.setText("Administrar Colonias");
        adminColoniesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminColoniesItemActionPerformed(evt);
            }
        });
        colonyMenu.add(adminColoniesItem);

        listColoniesItem.setText("Listar Colonias");
        listColoniesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listColoniesItemActionPerformed(evt);
            }
        });
        colonyMenu.add(listColoniesItem);

        jMenuBar1.add(colonyMenu);

        sessionItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/session.png"))); // NOI18N
        sessionItem.setText("Sesión");

        closeSessionItem.setText("Cerrar Sesión");
        closeSessionItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeSessionItemActionPerformed(evt);
            }
        });
        sessionItem.add(closeSessionItem);

        jMenuBar1.add(sessionItem);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showPanel(JPanel p) {
        p.setSize(1200, 777);
        p.setLocation(0, 0);
        PanelContent.removeAll();
        PanelContent.add(p, BorderLayout.CENTER);
        PanelContent.revalidate();
        PanelContent.repaint();
    }
    private void closeSessionItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeSessionItemActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas cerrar tu sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);
        if (opcion == 0) {
            sesion.cerrarSesion();
            this.setVisible(false);
            Login login = new Login();
            login.setVisible(true);
        }
    }//GEN-LAST:event_closeSessionItemActionPerformed

    private void listUsersItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listUsersItemActionPerformed
        // TODO add your handling code here:
        ListUsers listUPanel = new ListUsers();
        showPanel(listUPanel);

    }//GEN-LAST:event_listUsersItemActionPerformed

    private void topMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topMenuItemActionPerformed
        // TODO add your handling code here:
        Dashboard top = new Dashboard();
        showPanel(top);
    }//GEN-LAST:event_topMenuItemActionPerformed

    private void listEmployeesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listEmployeesItemActionPerformed
        // TODO add your handling code here:
        ListEmployees listEPanel = new ListEmployees();
        showPanel(listEPanel);
    }//GEN-LAST:event_listEmployeesItemActionPerformed

    private void listSquadsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listSquadsItemActionPerformed
        // TODO add your handling code here:
        ListSquads listSPanel = new ListSquads();
        showPanel(listSPanel);
    }//GEN-LAST:event_listSquadsItemActionPerformed

    private void listActivitiesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActivitiesItemActionPerformed
        // TODO add your handling code here:
        ListActivities listAPanel = new ListActivities();
        showPanel(listAPanel);
    }//GEN-LAST:event_listActivitiesItemActionPerformed

    private void ActivitiesColoniesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivitiesColoniesActionPerformed
        // TODO add your handling code here:
        ListActivitiesColonies listACPanel = new ListActivitiesColonies();
        showPanel(listACPanel);
    }//GEN-LAST:event_ActivitiesColoniesActionPerformed

    private void listColoniesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listColoniesItemActionPerformed
        // TODO add your handling code here:
        ListColonies listCPanel = new ListColonies();
        showPanel(listCPanel);
    }//GEN-LAST:event_listColoniesItemActionPerformed

    private void adminUsersItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminUsersItemActionPerformed
        // TODO add your handling code here:
        AdminUsers admUserPanel = new AdminUsers();
        showPanel(admUserPanel);
    }//GEN-LAST:event_adminUsersItemActionPerformed

    private void adminEmployeesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminEmployeesItemActionPerformed
        // TODO add your handling code here:
        AdminEmployees admEmpPanel = new AdminEmployees();
        showPanel(admEmpPanel);
    }//GEN-LAST:event_adminEmployeesItemActionPerformed

    private void adminSquadsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminSquadsItemActionPerformed
        // TODO add your handling code here:
        AdminSquads admSqPanel = new AdminSquads();
        showPanel(admSqPanel);
    }//GEN-LAST:event_adminSquadsItemActionPerformed

    private void adminColoniesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminColoniesItemActionPerformed
        // TODO add your handling code here:
        AdminColonies admCPanel = new AdminColonies();
        showPanel(admCPanel);
    }//GEN-LAST:event_adminColoniesItemActionPerformed

    private void adminActivitiesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActivitiesItemActionPerformed
        // TODO add your handling code here:
        AdminActivities admAPanel = new AdminActivities();
        showPanel(admAPanel);
    }//GEN-LAST:event_adminActivitiesItemActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ActivitiesColonies;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JMenu activitiesMenu;
    private javax.swing.JMenuItem adminActivitiesItem;
    private javax.swing.JMenuItem adminColoniesItem;
    private javax.swing.JMenuItem adminEmployeesItem;
    private javax.swing.JMenuItem adminSquadsItem;
    private javax.swing.JMenuItem adminUsersItem;
    private javax.swing.JMenuItem closeSessionItem;
    private javax.swing.JMenu colonyMenu;
    private javax.swing.JMenu employeesMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem listActivitiesItem;
    private javax.swing.JMenuItem listColoniesItem;
    private javax.swing.JMenuItem listEmployeesItem;
    private javax.swing.JMenuItem listSquadsItem;
    private javax.swing.JMenuItem listUsersItem;
    private javax.swing.JMenu sessionItem;
    private javax.swing.JMenu squadMenu;
    private javax.swing.JMenu topMenu;
    private javax.swing.JMenuItem topMenuItem;
    private javax.swing.JMenu userMenu;
    // End of variables declaration//GEN-END:variables
}
