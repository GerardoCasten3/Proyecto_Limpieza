package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DB.DBConfig;
import Models.Cuadrilla;

public class CuadrillaDAO {

    private Connection connection;

    public CuadrillaDAO() {
        this.connection = DBConfig.getInstance().getConnection();
    }

    // Método para insertar una nueva cuadrilla
    public boolean insertarCuadrilla(Cuadrilla cuadrilla) {
        String query = "INSERT INTO cuadrillas (nombre) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cuadrilla.getNombre());
            System.out.println("Se agregó exitosamente la cuadrilla.");
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar cuadrilla: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar una cuadrilla
    public boolean eliminarCuadrilla(int idCuadrilla) {
        String query = "DELETE FROM cuadrillas WHERE id_cuadrilla = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idCuadrilla);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cuadrilla: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar una cuadrilla
    public boolean actualizarCuadrilla(Cuadrilla cuadrilla, int id_cuadrilla) {
        String query = "UPDATE cuadrillas SET nombre = ? WHERE id_cuadrilla = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cuadrilla.getNombre());
            statement.setInt(2, id_cuadrilla);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cuadrilla: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todas las cuadrillas
    public List<Cuadrilla> obtenerCuadrillas() {
        List<Cuadrilla> cuadrillas = new ArrayList<>();
        String query = "SELECT id_cuadrilla, nombre FROM cuadrillas";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Cuadrilla cuadrilla = new Cuadrilla();
                cuadrilla.setId_cuadrilla(resultSet.getInt("id_cuadrilla"));
                cuadrilla.setNombre(resultSet.getString("nombre"));
                cuadrillas.add(cuadrilla);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cuadrillas: " + e.getMessage());
        }
        return cuadrillas;
    }

    // Método para obtener cuadrilla por id
    public Cuadrilla obtenerCuadrillaPorId(int idCuadrilla) {
        Cuadrilla cuadrilla = null;
        String query = "SELECT id_cuadrilla, nombre FROM cuadrillas WHERE id_cuadrilla = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idCuadrilla);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cuadrilla = new Cuadrilla();
                cuadrilla.setId_cuadrilla(resultSet.getInt("id_cuadrilla"));
                cuadrilla.setNombre(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cuadrilla por ID: " + e.getMessage());
        }
        return cuadrilla;
    }

    // Método para obtener cuadrilla por nombre
    public Cuadrilla obtenerCuadrillaPorNombre(String nombre) {
        Cuadrilla cuadrilla = null;
        String query = "SELECT id_cuadrilla, nombre FROM cuadrillas WHERE nombre = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cuadrilla = new Cuadrilla();
                cuadrilla.setId_cuadrilla(resultSet.getInt("id_cuadrilla"));
                cuadrilla.setNombre(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cuadrilla por nombre: " + e.getMessage());
        }
        return cuadrilla;
    }
}
