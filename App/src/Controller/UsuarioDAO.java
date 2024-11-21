/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DB.DBConfig;
import Models.Usuario;
import Models.Rol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        this.connection = DBConfig.getInstance().getConnection();
    }

    public boolean insertarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuarios (username, password, rol) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getPassword());
            statement.setString(3, usuario.getRol().toString());

            // Intentamos ejecutar la inserción en la base de datos
            return statement.executeUpdate() > 0;
        }
    }

    public boolean eliminarUsuario(int idUsuario) throws SQLException {
        String query = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idUsuario);
            return statement.executeUpdate() > 0;
        }
    }

    public boolean actualizarUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE usuarios SET username = ?, password = ?, rol = ? WHERE id_usuario = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getPassword());
            statement.setString(3, usuario.getRol().toString());
            statement.setInt(4, usuario.getId_usuario());
            return statement.executeUpdate() > 0;
        }
    }

    public Usuario validaUsuario(String username, String password) {
        String query = "SELECT id_usuario, username, rol FROM usuarios WHERE username = ? AND password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId_usuario(resultSet.getInt("id_usuario"));
                    usuario.setUsername(resultSet.getString("username"));
                    usuario.setRol(Rol.valueOf(resultSet.getString("rol")));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean iniciarSesion(String username, String password) {
        Usuario usuario = validaUsuario(username, password);
        if (usuario != null) {
            Sesion.getInstance().iniciarSesion(usuario);
            return true;
        } else {
            return false;
        }
    }

    public void cerrarSesion() {
        Sesion.getInstance().cerrarSesion();
        System.out.println("Sesión cerrada con éxito.");
    }

    public boolean esAdmin() {
        return Sesion.getInstance().esAdministrador();
    }

    public List<Usuario> obtenerUsuarios() {
        if (!Sesion.getInstance().esAdministrador()) {
            System.out.println("Acceso denegado: solo los administradores pueden ver la lista de usuarios.");
            return Collections.emptyList();
        }

        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT id_usuario, username, rol FROM usuarios";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(resultSet.getInt("id_usuario"));
                usuario.setUsername(resultSet.getString("username"));
                usuario.setRol(Rol.valueOf(resultSet.getString("rol")));
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario obtenerUsuarioPorId(int idUsuario) {
        String query = "SELECT username, password, rol FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idUsuario);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId_usuario(idUsuario); // Asegúrate de que el método setId_usuario() esté definido
                    usuario.setUsername(resultSet.getString("username"));
                    usuario.setPassword(resultSet.getString("password"));
                    usuario.setRol(Rol.valueOf(resultSet.getString("rol")));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener usuario por ID: " + e.getMessage());
        }
        return null;
    }

    public Usuario obtenerUsuarioPorUsername(String username) {
        String query = "SELECT id_usuario, username, rol FROM usuarios WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId_usuario(resultSet.getInt("id_usuario"));
                    usuario.setUsername(resultSet.getString("username"));
                    usuario.setRol(Rol.valueOf(resultSet.getString("rol"))); // Convierte el rol al tipo `Rol` enumerado
                    return usuario;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener usuario por username: " + e.getMessage());
        }
        return null;
    }

}
