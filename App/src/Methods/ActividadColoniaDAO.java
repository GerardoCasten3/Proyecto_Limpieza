package Methods;

import DB.DBConfig;
import Objects.ActividadColonia;
import Objects.Colonia;
import Objects.ActividadLimpieza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActividadColoniaDAO {
    private Connection connection;

    public ActividadColoniaDAO() {
        this.connection = DBConfig.getInstance().getConnection();
    }

    // Método para agregar una relación entre actividad y colonia
    public void agregarActividadColonia(ActividadLimpieza actividad, Colonia colonia) {
        String sql = "INSERT INTO actividades_colonias (id_actividad, id_colonia) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, actividad.getId_actividad());
            statement.setInt(2, colonia.getId_colonia());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al agregar actividad a colonia: " + e.getMessage());
        }
    }

    // Método para eliminar una relación entre actividad y colonia
    public void eliminarActividadColonia(int id_actividad, int id_colonia) {
        String sql = "DELETE FROM actividades_colonias WHERE id_actividad = ? AND id_colonia = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_actividad);
            statement.setInt(2, id_colonia);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar actividad de colonia: " + e.getMessage());
        }
    }

    // Método para obtener todas las colonias asociadas a una actividad
    public List<Colonia> obtenerColoniasPorActividad(int id_actividad) {
        List<Colonia> colonias = new ArrayList<>();
        String sql = "SELECT c.* FROM colonias c " +
                     "JOIN actividades_colonias ac ON c.id_colonia = ac.id_colonia " +
                     "WHERE ac.id_actividad = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_actividad);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Colonia colonia = new Colonia();
                    colonia.setId_colonia(resultSet.getInt("id_colonia"));
                    colonia.setNombre(resultSet.getString("nombre"));
                    colonia.setCodigoPostal(resultSet.getInt("codigo_postal"));
                    colonia.setTipoAsentamiento(resultSet.getString("tipo_asentamiento"));
                    colonias.add(colonia);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener colonias por actividad: " + e.getMessage());
        }
        return colonias;
    }
}