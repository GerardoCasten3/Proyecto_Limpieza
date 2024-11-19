package Controller;

import DB.DBConfig;
import Models.Colonia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColoniasDAO {

    private Connection connection;

    public ColoniasDAO() {
        this.connection = DBConfig.getInstance().getConnection();
    }

    // Método para agregar una nueva colonia
    public void agregarColonia(Colonia colonia) {
        String sql = "INSERT INTO colonias (nombre, codigo_postal, tipo_asentamiento) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, colonia.getNombre());
            pstmt.setInt(2, colonia.getCodigoPostal());
            pstmt.setString(3, colonia.getTipoAsentamiento());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al agregar colonia: " + e.getMessage());
        }
    }

    // Método para actualizar una colonia
    public void actualizarColonia(Colonia colonia, int id_colonia) {
        String sql = "UPDATE colonias SET nombre = ?, codigo_postal = ?, tipo_asentamiento = ? WHERE id_colonia = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, colonia.getNombre());
            pstmt.setInt(2, colonia.getCodigoPostal());
            pstmt.setString(3, colonia.getTipoAsentamiento());
            pstmt.setInt(4, id_colonia);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar colonia: " + e.getMessage());
        }
    }

    // Método para eliminar una colonia
    public void eliminarColonia(int id_colonia) {
        String sql = "DELETE FROM colonias WHERE id_colonia = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id_colonia);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar colonia: " + e.getMessage());
        }
    }

    // Método para buscar colonias por código postal
    public List<Colonia> buscarPorCodigoPostal(int codigoPostal) {
        List<Colonia> colonias = new ArrayList<>();
        String sql = "SELECT id_colonia, nombre, codigo_postal, tipo_asentamiento FROM colonias WHERE codigo_postal = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, codigoPostal);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id_colonia = rs.getInt("id_colonia");
                String nombre = rs.getString("nombre");
                String tipoAsentamiento = rs.getString("tipo_asentamiento");
                Colonia colonia = new Colonia(id_colonia, nombre, codigoPostal, tipoAsentamiento);
                colonias.add(colonia);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar colonias por código postal: " + e.getMessage());
        }
        return colonias;
    }

    // Método para obtener todas las colonias (opcional)
    public List<Colonia> obtenerTodasLasColonias() {
        List<Colonia> colonias = new ArrayList<>();
        String sql = "SELECT id_colonia, nombre, codigo_postal, tipo_asentamiento FROM colonias";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id_colonia = rs.getInt("id_colonia");
                String nombre = rs.getString("nombre");
                int codigoPostal = rs.getInt("codigo_postal");
                String tipoAsentamiento = rs.getString("tipo_asentamiento");
                colonias.add(new Colonia(id_colonia, nombre, codigoPostal, tipoAsentamiento));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todas las colonias: " + e.getMessage());
        }
        return colonias;
    }

    // Método para obtener una colonia por nombre
    public Colonia obtenerColoniaPorNombre(String nombre) {
        Colonia colonia = null;
        String sql = "SELECT id_colonia, nombre, codigo_postal, tipo_asentamiento FROM colonias WHERE nombre = ? LIMIT 1";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id_colonia = rs.getInt("id_colonia");
                String nombreCol = rs.getString("nombre");
                int codigoPostal = rs.getInt("codigo_postal");
                String tipoAsentamiento = rs.getString("tipo_asentamiento");
                colonia = new Colonia(id_colonia, nombreCol, codigoPostal, tipoAsentamiento);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener colonia por nombre: " + e.getMessage());
        }
        return colonia;
    }

    // Método para obtener una colonia por ID
    public Colonia obtenerColoniaPorId(int idColonia) {
        Colonia colonia = null;
        String sql = "SELECT id_colonia, nombre, codigo_postal, tipo_asentamiento FROM colonias WHERE id_colonia = ? LIMIT 1";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idColonia);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id_colonia = rs.getInt("id_colonia");
                String nombre = rs.getString("nombre");
                int codigoPostal = rs.getInt("codigo_postal");
                String tipoAsentamiento = rs.getString("tipo_asentamiento");
                colonia = new Colonia(id_colonia, nombre, codigoPostal, tipoAsentamiento);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener colonia por ID: " + e.getMessage());
        }
        return colonia;
    }
}
