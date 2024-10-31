/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Methods;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import DB.DBConfig;
import Objects.Empleado;
import Objects.Cuadrilla;
import Objects.Usuario;

/**
 *
 * @author gerar
 */
public class EmpleadoDAO {

    private Connection connection;

    public EmpleadoDAO() {
        this.connection = DBConfig.getInstance().getConnection();
    }

    // Método para insertar un nuevo empleado
    public boolean insertarEmpleado(Empleado empleado) {
        int es_jefe = empleado.isEsJefeCuadrilla() ? 1 : 0; // Simplificación
        String query = "INSERT INTO empleados (nombre, cargo, es_jefe_cuadrilla, id_cuadrilla, id_usuario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getCargo());
            statement.setInt(3, es_jefe);

            if (empleado.getCuadrilla() != null) {
                statement.setInt(4, empleado.getCuadrilla().getId_cuadrilla());
            } else {
                statement.setNull(4, java.sql.Types.INTEGER); // Establecer como NULL
            }

            if (empleado.getUsuario() != null) {
                statement.setInt(5, empleado.getUsuario().getId_usuario());
            } else {
                statement.setNull(5, java.sql.Types.INTEGER); // Establecer como NULL
            }
            System.out.println("Se agregó exitosamente el empleado.");
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un empleado
    public boolean eliminarEmpleado(int idEmpleado) {
        String query = "DELETE FROM empleados WHERE id_empleado = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idEmpleado);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los empleados
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        UsuarioDAO userDAO = new UsuarioDAO();
        CuadrillaDAO cuadrillaDAO = new CuadrillaDAO();
        String query = "SELECT id_empleado, nombre, cargo, es_jefe_cuadrilla, id_cuadrilla, id_usuario FROM empleados";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setId_empleado(resultSet.getInt("id_empleado"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setCargo(resultSet.getString("cargo"));
                empleado.setEsJefeCuadrilla(resultSet.getBoolean("es_jefe_cuadrilla"));

                int idCuadrilla = resultSet.getInt("id_cuadrilla");
                Cuadrilla cuadrilla = cuadrillaDAO.obtenerCuadrillaPorId(idCuadrilla); // Implementa este método si es necesario
                empleado.setCuadrilla(cuadrilla);

                int idUsuario = resultSet.getInt("id_usuario");
                Usuario usuario = userDAO.obtenerUsuarioPorId(idUsuario); // Implementa este método si es necesario
                empleado.setUsuario(usuario);

                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener empleados: " + e.getMessage());
        }
        return empleados;
    }

    // Método para actualizar el id_cuadrilla de un empleado
    public boolean actualizarCuadrillaPorIdEmpleado(int idEmpleado, Cuadrilla cuadrilla) {
        String query = "UPDATE empleados SET id_cuadrilla = ? WHERE id_empleado = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            if (cuadrilla != null) {
                statement.setInt(1, cuadrilla.getId_cuadrilla());
            } else {
                statement.setNull(1, java.sql.Types.INTEGER); // Establecer como NULL
            }
            statement.setInt(2, idEmpleado);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cuadrilla: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar el id_usuario de un empleado
    public boolean actualizarUsuarioPorIdEmpleado(int idEmpleado, Usuario usuario) {
        String query = "UPDATE empleados SET id_usuario = ? WHERE id_empleado = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            if (usuario != null) {
                statement.setInt(1, usuario.getId_usuario());
            } else {
                statement.setNull(1, java.sql.Types.INTEGER); // Establecer como NULL
            }
            statement.setInt(2, idEmpleado);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }

    }
    
    public Empleado obtenerEmpleadoPorId(int idEmpleado) {
    Empleado empleado = null; // Inicializar el empleado como null
    String query = "SELECT id_empleado, nombre, cargo, es_jefe_cuadrilla, id_cuadrilla, id_usuario FROM empleados WHERE id_empleado = ?";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idEmpleado);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                empleado = new Empleado();
                empleado.setId_empleado(resultSet.getInt("id_empleado"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setCargo(resultSet.getString("cargo"));
                empleado.setEsJefeCuadrilla(resultSet.getBoolean("es_jefe_cuadrilla"));

                // Obtener y establecer la cuadrilla asociada
                int idCuadrilla = resultSet.getInt("id_cuadrilla");
                CuadrillaDAO cuadrillaDAO = new CuadrillaDAO();
                Cuadrilla cuadrilla = cuadrillaDAO.obtenerCuadrillaPorId(idCuadrilla);
                empleado.setCuadrilla(cuadrilla);

                // Obtener y establecer el usuario asociado
                int idUsuario = resultSet.getInt("id_usuario");
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.obtenerUsuarioPorId(idUsuario);
                empleado.setUsuario(usuario);
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener empleado por ID: " + e.getMessage());
    }
    return empleado;
}
    
    // Método para actualizar un empleado completo por su id_empleado
public boolean actualizarEmpleado(Empleado empleado, int id_empleado) {
    String query = "UPDATE empleados SET nombre = ?, cargo = ?, es_jefe_cuadrilla = ?, id_cuadrilla = ?, id_usuario = ? WHERE id_empleado = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, empleado.getNombre());
        statement.setString(2, empleado.getCargo());
        statement.setBoolean(3, empleado.isEsJefeCuadrilla());

        // Establecer id_cuadrilla
        if (empleado.getCuadrilla() != null) {
            statement.setInt(4, empleado.getCuadrilla().getId_cuadrilla());
        } else {
            statement.setNull(4, java.sql.Types.INTEGER);
        }

        // Establecer id_usuario
        if (empleado.getUsuario() != null) {
            statement.setInt(5, empleado.getUsuario().getId_usuario());
        } else {
            statement.setNull(5, java.sql.Types.INTEGER);
        }

        // Establecer id_empleado para la condición WHERE
        statement.setInt(6, id_empleado);

        return statement.executeUpdate() > 0; // Retorna true si la actualización fue exitosa
    } catch (SQLException e) {
        System.out.println("Error al actualizar empleado: " + e.getMessage());
        return false;
    }
}

}
