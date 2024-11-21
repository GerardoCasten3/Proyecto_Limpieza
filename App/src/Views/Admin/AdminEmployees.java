/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.Admin;

import Models.*;
import Controller.*;
import java.util.List;
import java.sql.*;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author gerar
 */
public class AdminEmployees extends javax.swing.JPanel {

    UsuarioDAO userDAO = new UsuarioDAO();
    CuadrillaDAO squadDAO = new CuadrillaDAO();
    EmpleadoDAO employeeDAO = new EmpleadoDAO();

    /**
     * Creates new form AdminUsers
     */
    public AdminEmployees() {
        initComponents();
        updateComboBox(); //Actualizar combo box cada vez que entra al Panel
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        title1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        squadChiefLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        squadLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        squadComboBox = new javax.swing.JComboBox<>();
        insertButton = new javax.swing.JButton();
        employeeComboBox = new javax.swing.JComboBox<>();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        noChiefButton = new javax.swing.JRadioButton();
        yesChiefButton = new javax.swing.JRadioButton();
        userLabel = new javax.swing.JLabel();
        userComboBox = new javax.swing.JComboBox<>();
        employeeLabel = new javax.swing.JLabel();

        title1.setFont(new java.awt.Font("Bahnschrift", 1, 28)); // NOI18N
        title1.setText("ADMINISTRAR EMPLEADOS");

        nameLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        nameLabel.setText("Nombre Completo:");

        squadChiefLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        squadChiefLabel.setText("Jefe de Cuadrilla:");

        passwordLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        passwordLabel.setText("Cargo:");

        squadLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        squadLabel.setText("Cuadrilla:");

        nameTextField.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        nameTextField.setToolTipText("Ingresa el nombre completo del empleado");

        squadComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoge la cuadrilla:" }));
        squadComboBox.setToolTipText("Escoge la cuadrilla que se le asignará al usuario");

        insertButton.setBackground(new java.awt.Color(128, 237, 153));
        insertButton.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        insertButton.setForeground(new java.awt.Color(0, 0, 0));
        insertButton.setText("AGREGAR");
        insertButton.setToolTipText("Agregar un nuevo empleado");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        employeeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoge el empleado:" }));
        employeeComboBox.setToolTipText("Escoger un empleado para actualizar o eliminar");

        updateButton.setBackground(new java.awt.Color(20, 145, 155));
        updateButton.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(0, 0, 0));
        updateButton.setText("ACTUALIZAR");
        updateButton.setToolTipText("Actualizar un empleado");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 0, 0));
        deleteButton.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        deleteButton.setText("ELIMINAR");
        deleteButton.setToolTipText("Elimina un empleado");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(33, 58, 87));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel2.setText("SISTEMA DE LIMPIEZA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(413, Short.MAX_VALUE)
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona el puesto del empleado:", "Limpieza General", "Especialista de Limpieza", "Supervisor de Limpieza", "Coordinador de Limpieza", "Gerente de Limpieza" }));
        jComboBox1.setToolTipText("Ingresa el puesto actual del empleado");

        buttonGroup1.add(noChiefButton);
        noChiefButton.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        noChiefButton.setText("No");
        noChiefButton.setToolTipText("No es jefe de cuadrilla");

        buttonGroup1.add(yesChiefButton);
        yesChiefButton.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        yesChiefButton.setText("Sí");
        yesChiefButton.setToolTipText("Si es jefe de cuadrilla");

        userLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        userLabel.setText("Usuario:");
        userLabel.setToolTipText("");

        userComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "El empleado no tiene acceso / No Aplica" }));
        userComboBox.setToolTipText("Elige el usuario que se le asignará al empleado");

        employeeLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        employeeLabel.setText("Empleado:");
        employeeLabel.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addGap(304, 304, 304)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(squadChiefLabel)
                            .addComponent(nameLabel)
                            .addComponent(passwordLabel)
                            .addComponent(squadLabel)
                            .addComponent(userLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(yesChiefButton)
                                        .addGap(56, 56, 56)
                                        .addComponent(noChiefButton))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(squadComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(employeeLabel)
                                .addGap(28, 28, 28)
                                .addComponent(employeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(title1)
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(insertButton)
                                .addGap(200, 200, 200)))))
                .addGap(319, 319, 319))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(title1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(squadChiefLabel)
                            .addComponent(yesChiefButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(noChiefButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(squadLabel)
                    .addComponent(squadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(userComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(insertButton)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeLabel)
                    .addComponent(employeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addGap(138, 138, 138))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Evento del botón AGREGAR, aquí se manejarán las inserciones.
    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
        if (nameTextField.getText().trim().isEmpty()
                || jComboBox1.getSelectedIndex() == 0
                || (!yesChiefButton.isSelected() && !noChiefButton.isSelected())
                || squadComboBox.getSelectedIndex() == 0) {

            // Mostrar mensaje de error si faltan campos
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Por favor, rellene todos los campos antes de continuar.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        } else {
            String nombreEmpleado = nameTextField.getText().trim();
            String cargo = (String) jComboBox1.getSelectedItem();
            boolean isChief = false;
            if (yesChiefButton.isSelected()) {
                isChief = true;
            }
            String cuadrillaSeleccionada = (String) squadComboBox.getSelectedItem();
            String usuarioSeleccionado = (String) userComboBox.getSelectedItem();

            // Extraer el ID de la cuadrilla del texto seleccionado
            int idCuadrilla = Integer.parseInt(cuadrillaSeleccionada.split(":")[1].trim().split(" ")[0]);
            // Extraer el ID del usuario del texto seleccionado

            // Crear el empleado
            Empleado nuevoEmpleado = new Empleado();
            nuevoEmpleado.setNombre(nombreEmpleado);
            nuevoEmpleado.setCargo(cargo);
            nuevoEmpleado.setEsJefeCuadrilla(isChief);

            Cuadrilla cuadrilla = new Cuadrilla();
            cuadrilla.setId_cuadrilla(idCuadrilla);
            nuevoEmpleado.setCuadrilla(cuadrilla);

            if (userComboBox.getSelectedIndex() != 0) {
                int idUsuario = Integer.parseInt(usuarioSeleccionado.split(":")[1].trim().split(" ")[0]);
                Usuario usuario = new Usuario();
                usuario.setId_usuario(idUsuario);
                nuevoEmpleado.setUsuario(usuario);
            }

            // Llamar al DAO para insertar el empleado
            try {
                employeeDAO.insertarEmpleado(nuevoEmpleado);
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Empleado registrado exitosamente.",
                        "Éxito",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);

                // Actualizar ComboBoxes después de insertar
                updateComboBox();
                limpiarCampos();
            } catch (SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Error al registrar el empleado: " + ex.getMessage(),
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            // Actualizar los ComboBoxes después de insertar
        }
        updateComboBox();//Después de insertar debe actualizar el combo box
    }//GEN-LAST:event_insertButtonActionPerformed

    // Evento del botón ACTUALIZAR, aquí se manejarán las actualizaciones.
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String empleadoSeleccionado = (String) employeeComboBox.getSelectedItem();

        if (employeeComboBox.getSelectedIndex() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Por favor, escoge un empleado antes de actualizar.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Extraer el ID del empleado del texto (formato: "ID: <id> Nombre: <nombre>")
            int idEmpleado = Integer.parseInt(empleadoSeleccionado.split(":")[1].trim().split(" ")[0]);
            Empleado empleado = employeeDAO.obtenerEmpleadoPorId(idEmpleado);

            // Obtener los valores actuales del empleado
            String nombreOriginal = empleado.getNombre();
            String cargoOriginal = empleado.getCargo();
            boolean esJefeOriginal = empleado.isEsJefeCuadrilla();
            int idCuadrillaOriginal = empleado.getCuadrilla().getId_cuadrilla();
            // Verificar si el usuario es nulo y asignar el valor adecuado
            int idUsuarioOriginal = (empleado.getUsuario() != null) ? empleado.getUsuario().getId_usuario() : -1;

            // Obtener los nuevos valores desde la UI
            String nuevoNombre = nameTextField.getText().trim();
            String nuevoCargo = (String) jComboBox1.getSelectedItem();
            boolean esNuevoJefe = yesChiefButton.isSelected();

            // Validar y actualizar el nombre solo si ha cambiado
            if (!nuevoNombre.isEmpty() && !nuevoNombre.equals(nombreOriginal)) {
                empleado.setNombre(nuevoNombre);
            }

            // Validar y actualizar el cargo solo si ha cambiado
            if (jComboBox1.getSelectedIndex() != 0 && nuevoCargo != null && !nuevoCargo.equals(cargoOriginal)) {
                empleado.setCargo(nuevoCargo);
            }

            // Validar si el valor de "Jefe de cuadrilla" ha cambiado
            if (esNuevoJefe != esJefeOriginal) {
                empleado.setEsJefeCuadrilla(esNuevoJefe);
            }

            // Validar si la cuadrilla ha cambiado
            if (squadComboBox.getSelectedIndex() != 0) {
                String cuadrillaString = (String) squadComboBox.getSelectedItem();
                int idCuadrillaSeleccionada = Integer.parseInt(cuadrillaString.split(":")[1].trim().split(" ")[0]);
                if (idCuadrillaSeleccionada != idCuadrillaOriginal) {
                    Cuadrilla cuadrilla = new Cuadrilla();
                    cuadrilla.setId_cuadrilla(idCuadrillaSeleccionada);
                    empleado.setCuadrilla(cuadrilla);
                }
            } else {
                Cuadrilla cuadrilla = new Cuadrilla();
                cuadrilla.setId_cuadrilla(idCuadrillaOriginal);
                empleado.setCuadrilla(cuadrilla);
            }

            // Verificar si el usuario ha cambiado
            int idUsuarioSeleccionado = userComboBox.getSelectedIndex() != 0
                    ? Integer.parseInt(userComboBox.getSelectedItem().toString().split(":")[1].trim().split(" ")[0])
                    : -1; // Cambiar a -1 para evitar idUsuario 0

            if (idUsuarioSeleccionado != -1 && idUsuarioSeleccionado != idUsuarioOriginal) {
                // Solo actualizamos el usuario si se seleccionó un nuevo valor válido
                Usuario usuario = new Usuario();
                usuario.setId_usuario(idUsuarioSeleccionado);
                empleado.setUsuario(usuario);
            } else if (idUsuarioSeleccionado == -1) {
                // Si no se selecciona un usuario, podemos dejar el usuario como nulo
                empleado.setUsuario(null);
            } else {
                // Si no se seleccionó un nuevo usuario, mantenemos el valor original
                Usuario usuario = new Usuario();
                usuario.setId_usuario(idUsuarioOriginal);
                empleado.setUsuario(usuario);
            }

            // Llamar al DAO para realizar la actualización en la base de datos
            if (employeeDAO.actualizarEmpleado(empleado, idEmpleado)) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Empleado actualizado exitosamente.",
                        "Éxito",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
                // Actualizar el ComboBox después de la actualización
                updateComboBox();
                limpiarCampos();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "No se pudo actualizar el empleado.",
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                updateComboBox();
            }

        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al actualizar el empleado: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            updateComboBox();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    // Evento del botón ELIMINAR, aquí se manejarán los elementos eliminados.
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        // Obtener el texto seleccionado en el combo box
        String empleadoSeleccionado = (String) employeeComboBox.getSelectedItem();
        if (employeeComboBox.getSelectedIndex() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Por favor, escoge un empleado antes de eliminar.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Extraer el ID del empleado del texto (formato: "ID: <id> Nombre: <nombre>")
            int idEmpleado = Integer.parseInt(empleadoSeleccionado.split(":")[1].trim().split(" ")[0]);

            // Confirmar eliminación con el usuario
            int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar este empleado?\n" + empleadoSeleccionado,
                    "Confirmar eliminación",
                    javax.swing.JOptionPane.YES_NO_OPTION);

            if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
                // Llamar al DAO para eliminar el empleado
                employeeDAO.eliminarEmpleado(idEmpleado);
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Empleado eliminado exitosamente.",
                        "Éxito",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);

                // Actualizar los ComboBoxes después de eliminar
                updateComboBox();
                limpiarCampos();
            }
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al eliminar el empleado: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        // IMPORTANTE: Tomar ID de empleado del ComboBox
        updateComboBox();//Después de eliminar debe actualizar el combo box
    }//GEN-LAST:event_deleteButtonActionPerformed

    // Actualizar combo box de usuarios
    private void updateUsers() {
        List<Usuario> usuarios = userDAO.obtenerUsuarios();
        userComboBox.removeAllItems();
        userComboBox.addItem("No aplica/El empleado aun no tiene usuario.");

        for (Usuario usuario : usuarios) {
            userComboBox.addItem("ID: " + usuario.getId_usuario() + " Nombre de Usuario: " + usuario.getUsername());
        }
    }

    // Actualizar combo box de usuarios
    private void updateSquads() {
        List<Cuadrilla> cuadrilla = squadDAO.obtenerCuadrillas();
        squadComboBox.removeAllItems();
        squadComboBox.addItem("Selecciona una cuadrilla");

        for (Cuadrilla squad : cuadrilla) {
            squadComboBox.addItem("ID: " + squad.getId_cuadrilla() + " Nombre: " + squad.getNombre());
        }
    }

    // Actualizar combo box de usuarios
    private void updateEmployees() {
        List<Empleado> empleados = employeeDAO.obtenerEmpleados();
        employeeComboBox.removeAllItems();
        employeeComboBox.addItem("Selecciona un empleado para actualizar/eliminar");

        for (Empleado employee : empleados) {
            employeeComboBox.addItem("ID: " + employee.getId_empleado() + " Nombre: " + employee.getNombre());
        }
    }

    private void updateComboBox() {
        updateUsers();
        updateSquads();
        updateEmployees();
    }

    private void limpiarCampos() {
        // Limpiar el campo de texto de nombre
        nameTextField.setText("");

        // Restablecer el combo de cargo
        jComboBox1.setSelectedIndex(0);

        // Restablecer los botones de radio para jefe de cuadrilla
        buttonGroup1.clearSelection();

        // Limpiar el combo de cuadrilla
        squadComboBox.setSelectedIndex(0);
        // Limpiar el combo de usuario
        userComboBox.setSelectedIndex(0); 

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> employeeComboBox;
    private javax.swing.JLabel employeeLabel;
    private javax.swing.JButton insertButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JRadioButton noChiefButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel squadChiefLabel;
    private javax.swing.JComboBox<String> squadComboBox;
    private javax.swing.JLabel squadLabel;
    private javax.swing.JLabel title1;
    private javax.swing.JButton updateButton;
    private javax.swing.JComboBox<String> userComboBox;
    private javax.swing.JLabel userLabel;
    private javax.swing.JRadioButton yesChiefButton;
    // End of variables declaration//GEN-END:variables
}
