/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views.User;

import Views.Chief.*;
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
public class MenuUser extends javax.swing.JFrame {

    Sesion sesion = Sesion.getInstance();

    /**
     * Creates new form Content
     */
    public MenuUser() {
        if (sesion.estaAutenticado()) {
            initComponents();
            MainUser inicio = new MainUser();
            showPanel(inicio);
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
        activitiesMenu = new javax.swing.JMenu();
        userActivitiesItem = new javax.swing.JMenuItem();
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

        topMenuItem.setText("Inicio");
        topMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topMenuItemActionPerformed(evt);
            }
        });
        topMenu.add(topMenuItem);

        jMenuBar1.add(topMenu);

        activitiesMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/activities.png"))); // NOI18N
        activitiesMenu.setText("Actividades");
        activitiesMenu.setToolTipText("");

        userActivitiesItem.setText("Visualizar Actividades");
        userActivitiesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActivitiesItemActionPerformed(evt);
            }
        });
        activitiesMenu.add(userActivitiesItem);

        jMenuBar1.add(activitiesMenu);

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

    private void topMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topMenuItemActionPerformed
        // TODO add your handling code here:
        MainUser inicio = new MainUser();
        showPanel(inicio);
        
    }//GEN-LAST:event_topMenuItemActionPerformed

    private void userActivitiesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActivitiesItemActionPerformed
        // TODO add your handling code here:
        ActivitiesUser actCPanel = new ActivitiesUser();
        showPanel(actCPanel);
        
    }//GEN-LAST:event_userActivitiesItemActionPerformed

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
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContent;
    private javax.swing.JMenu activitiesMenu;
    private javax.swing.JMenuItem closeSessionItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu sessionItem;
    private javax.swing.JMenu topMenu;
    private javax.swing.JMenuItem topMenuItem;
    private javax.swing.JMenuItem userActivitiesItem;
    // End of variables declaration//GEN-END:variables
}
