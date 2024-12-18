package Controller;

import Models.DBConfig;
import Models.ActividadLimpieza;
import Models.Cuadrilla;
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
    public boolean actualizarActividad(ActividadLimpieza actividad, int id) throws SQLException {
        String sql = "UPDATE actividades_limpieza SET descripcion = ?, fecha = ?, retroalimentacion = ?, imagenEvidencia = ?, id_cuadrilla = ? WHERE id_actividad = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, actividad.getDescripcion());
            stmt.setDate(2, new java.sql.Date(actividad.getFecha().getTime()));
            stmt.setString(3, actividad.getRetroalimentacion());
            stmt.setString(4, actividad.getImagenEvidencia());
            stmt.setInt(5, actividad.getCuadrilla().getId_cuadrilla());
            stmt.setInt(6, id);
            stmt.executeUpdate();
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para actualizar retroalimentación e imagen
    public void actualizarRetroalimentacionImagen(String retroalimentacion, String imagen, boolean completado, int id, int idUsuario) {
        String sql = "UPDATE actividades_limpieza SET retroalimentacion = ?, imagenEvidencia = ?, completado = ? WHERE id_actividad = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, retroalimentacion);
            stmt.setString(2, imagen);
            stmt.setBoolean(3, completado);
            stmt.setInt(4, id);
            stmt.executeUpdate();

            ActividadLimpieza actividad = buscarActividadPorId(id);
            String mensaje = "Se actualizó la retroalimentación, la imagen y el estatus de la actividad con ID: " + id;

            NotificacionObserver observer = new NotificacionObserver(idUsuario);
            actividad.agregarObserver(observer);

            actividad.notificarObserver(mensaje);

            guardarNotificacion(idUsuario, id, mensaje);
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
                boolean terminado = rs.getBoolean("completado");

                // Crea la actividad de limpieza. Debes obtener la cuadrilla según su ID.
                Cuadrilla cuadrilla = cuadrDAO.obtenerCuadrillaPorId(cuadrillaId); // Método adicional para obtener la cuadrilla
                actividad = new ActividadLimpieza(descripcion, fecha, retroalimentacion, imagenEvidencia, cuadrilla, terminado);
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
                boolean terminado = rs.getBoolean("completado");

                // Crea la actividad de limpieza. Debes obtener la cuadrilla según su ID.
                Cuadrilla cuadrilla = cuadrDAO.obtenerCuadrillaPorId(cuadrillaId); // Método adicional para obtener la cuadrilla
                ActividadLimpieza actividad = new ActividadLimpieza(id_actividad, descripcion, fecha, retroalimentacion, imagenEvidencia, cuadrilla, terminado);
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
                boolean terminado = rs.getBoolean("completado");

                // Obtener la cuadrilla correspondiente
                Cuadrilla cuadrilla = cuadrDAO.obtenerCuadrillaPorId(cuadrillaId);
                actividad = new ActividadLimpieza(descripcion, fecha, retroalimentacion, imagenEvidencia, cuadrilla, terminado);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar actividad por nombre: " + e.getMessage());
        }

        return actividad;
    }

    public List<ActividadLimpieza> obtenerActividadesPorIdCuadrilla(int idCuadrilla) {
        CuadrillaDAO cuadrDAO = new CuadrillaDAO();
        List<ActividadLimpieza> actividades = new ArrayList<>();
        String sql = "SELECT * FROM actividades_limpieza WHERE id_cuadrilla = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCuadrilla);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_actividad = rs.getInt("id_actividad");
                String descripcion = rs.getString("descripcion");
                Date fecha = rs.getDate("fecha");
                String retroalimentacion = rs.getString("retroalimentacion");
                String imagenEvidencia = rs.getString("imagenEvidencia");
                boolean completado = rs.getBoolean("completado");

                // Obtener la cuadrilla correspondiente
                Cuadrilla cuadrilla = cuadrDAO.obtenerCuadrillaPorId(idCuadrilla);
                ActividadLimpieza actividad = new ActividadLimpieza(id_actividad, descripcion, fecha, retroalimentacion, imagenEvidencia, cuadrilla, completado);
                actividades.add(actividad);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener actividades por id_cuadrilla: " + e.getMessage());
        }

        return actividades;
    }

    public List<Object[]> obtenerResumenPorCuadrilla() throws SQLException {
        List<Object[]> resumen = new ArrayList<>();
        String query = "SELECT c.nombre, "
                + "COUNT(CASE WHEN a.completado = TRUE THEN 1 END) AS actividades_completadas, "
                + "COUNT(CASE WHEN a.completado = FALSE THEN 1 END) AS actividades_no_completadas "
                + "FROM cuadrillas c "
                + "LEFT JOIN actividades_limpieza a ON c.id_cuadrilla = a.id_cuadrilla "
                + "GROUP BY c.id_cuadrilla";
        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nombreCuadrilla = rs.getString("nombre");
                int actividadesCompletadas = rs.getInt("actividades_completadas");
                int actividadesNoCompletadas = rs.getInt("actividades_no_completadas");
                resumen.add(new Object[]{nombreCuadrilla, actividadesCompletadas, actividadesNoCompletadas});
            }
        }
        return resumen;
    }

    public void guardarNotificacion(int idUsuario, int idActividad, String mensaje) {
        String sql = "INSERT INTO observadores (id_usuario, id_actividad, mensaje) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idActividad);
            stmt.setString(3, mensaje);
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<String> obtenerNotificaciones() {
        List<String> notificaciones = new ArrayList<>();
        String sql = "SELECT u.username, o.id_actividad, o.mensaje FROM observadores o "
                + "JOIN usuarios u ON o.id_usuario = u.id_usuario "
                + "WHERE o.leido = 0 "
                + "ORDER BY o.id_observador DESC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String nombreUsuario = rs.getString("username");
                    int idActividad = rs.getInt("id_actividad");
                    String mensaje = rs.getString("mensaje");
                    // Construye el mensaje con el nombre del usuario
                    String notificacion = "Notificación del usuario \"" + nombreUsuario + "\" en actividad \""
                            + idActividad + "\" : \"" + mensaje + "\"";
                    notificaciones.add(notificacion);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return notificaciones;
    }

    public void leerNotificaciones() {
        String sql = "UPDATE observadores SET leido = 1";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al marcar notificaciones como leídas: " + e.getMessage());
        }
    }

}
