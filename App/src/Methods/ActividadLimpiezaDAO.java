package Methods;

import DB.DBConfig;
import Objects.ActividadLimpieza;
import Objects.Cuadrilla;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActividadLimpiezaDAO {

    private Connection connection;

    public ActividadLimpiezaDAO() {
        this.connection = DBConfig.getInstance().getConnection();
    }

    public void insertarActividad(ActividadLimpieza actividad) {
        String sql = "INSERT INTO actividades_limpieza (descripcion, fecha, retroalimentacion, imagenEvidencia, id_cuadrilla) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, actividad.getDescripcion());
            stmt.setDate(2, new java.sql.Date(actividad.getFecha().getTime()));

            // Verificar si retroalimentacion es nulo
            if (actividad.getRetroalimentacion() == null) {
                stmt.setNull(3, Types.VARCHAR);
            } else {
                stmt.setString(3, actividad.getRetroalimentacion());
            }

            // Verificar si imagenEvidencia es nulo
            if (actividad.getImagenEvidencia() == null) {
                stmt.setNull(4, Types.VARCHAR);
            } else {
                stmt.setString(4, actividad.getImagenEvidencia());
            }

            stmt.setInt(5, actividad.getCuadrilla().getId_cuadrilla());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar actividad: " + e.getMessage());
        }
    }

    // Método para actualizar una actividad de limpieza
    public void actualizarActividad(ActividadLimpieza actividad, int id) {
        String sql = "UPDATE actividades_limpieza SET descripcion = ?, fecha = ?, retroalimentacion = ?, imagenEvidencia = ?, id_cuadrilla = ? WHERE id_actividad = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, actividad.getDescripcion());
            stmt.setDate(2, new java.sql.Date(actividad.getFecha().getTime()));
            stmt.setString(3, actividad.getRetroalimentacion());
            stmt.setString(4, actividad.getImagenEvidencia());
            stmt.setInt(5, actividad.getCuadrilla().getId_cuadrilla());
            stmt.setInt(6, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar actividad: " + e.getMessage());
        }
    }

    // Método para actualizar retroalimentación e imagen
    public void actualizarRetroalimentacionImagen(String retroalimentacion, String imagen, int id) {
        String sql = "UPDATE actividades_limpieza SET retroalimentacion = ?, imagenEvidencia = ? WHERE id_actividad = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, retroalimentacion);
            stmt.setString(2, imagen);
            stmt.setInt(3, id);
            stmt.executeUpdate();

            ActividadLimpieza actividad = buscarActividadPorId(id);
            actividad.notificarObserver("Se actualizó la retroalimentación y la imagen de la actividad con ID: " + id);
        } catch (SQLException e) {
            System.err.println("Error al actualizar retroalimentación e imagen: " + e.getMessage());
        }
    }

    // Método para eliminar una actividad de limpieza
    public void eliminarActividad(int id) {
        String sql = "DELETE FROM actividades_limpieza WHERE id_actividad = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar actividad: " + e.getMessage());
        }
    }

    // Método para buscar actividades de limpieza por ID
    public ActividadLimpieza buscarActividadPorId(int id) {
        CuadrillaDAO cuadrDAO = new CuadrillaDAO();
        String sql = "SELECT * FROM actividades_limpieza WHERE id_actividad = ?";
        ActividadLimpieza actividad = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String descripcion = rs.getString("descripcion");
                Date fecha = rs.getDate("fecha");
                String retroalimentacion = rs.getString("retroalimentacion");
                String imagenEvidencia = rs.getString("imagenEvidencia");
                int cuadrillaId = rs.getInt("id_cuadrilla");

                // Crea la actividad de limpieza. Debes obtener la cuadrilla según su ID.
                Cuadrilla cuadrilla = cuadrDAO.obtenerCuadrillaPorId(cuadrillaId); // Método adicional para obtener la cuadrilla
                actividad = new ActividadLimpieza(descripcion, fecha, retroalimentacion, imagenEvidencia, cuadrilla);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar actividad por ID: " + e.getMessage());
        }

        return actividad;
    }

    // Método para obtener todas las actividades de limpieza
    public List<ActividadLimpieza> obtenerTodasLasActividades() {
        CuadrillaDAO cuadrDAO = new CuadrillaDAO();
        List<ActividadLimpieza> actividades = new ArrayList<>();
        String sql = "SELECT * FROM actividades_limpieza";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id_actividad = rs.getInt("id_actividad");
                String descripcion = rs.getString("descripcion");
                Date fecha = rs.getDate("fecha");
                String retroalimentacion = rs.getString("retroalimentacion");
                String imagenEvidencia = rs.getString("imagenEvidencia");
                int cuadrillaId = rs.getInt("id_cuadrilla");

                // Crea la actividad de limpieza. Debes obtener la cuadrilla según su ID.
                Cuadrilla cuadrilla = cuadrDAO.obtenerCuadrillaPorId(cuadrillaId); // Método adicional para obtener la cuadrilla
                ActividadLimpieza actividad = new ActividadLimpieza(id_actividad, descripcion, fecha, retroalimentacion, imagenEvidencia, cuadrilla);
                actividades.add(actividad);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todas las actividades: " + e.getMessage());
        }

        return actividades;
    }

    public ActividadLimpieza buscarPrimeraActividadPorNombre(String nombre) {
        CuadrillaDAO cuadrDAO = new CuadrillaDAO();
        String sql = "SELECT * FROM actividades_limpieza WHERE descripcion = ? LIMIT 1";
        ActividadLimpieza actividad = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id_actividad = rs.getInt("id_actividad");
                String descripcion = rs.getString("descripcion");
                Date fecha = rs.getDate("fecha");
                String retroalimentacion = rs.getString("retroalimentacion");
                String imagenEvidencia = rs.getString("imagenEvidencia");
                int cuadrillaId = rs.getInt("id_cuadrilla");

                // Obtener la cuadrilla correspondiente
                Cuadrilla cuadrilla = cuadrDAO.obtenerCuadrillaPorId(cuadrillaId);
                actividad = new ActividadLimpieza(id_actividad, descripcion, fecha, retroalimentacion, imagenEvidencia, cuadrilla);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar actividad por nombre: " + e.getMessage());
        }

        return actividad;
    }
}
