package DAO;

import Interfaces.iMesa; // Importar la interfaz
import DTO.MesaDTO; // Importar la clase MesaDTO
import Conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesaDAO implements iMesa {

    @Override
    public void agregarMesa(MesaDTO mesa) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "INSERT INTO mesa (codigo_mesa, tipo, capacidad, ubicacion, id_restaurante) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, mesa.getCodigoMesa());
            stmt.setString(2, mesa.getTipo());
            stmt.setInt(3, mesa.getCapacidad());
            stmt.setString(4, mesa.getUbicacion());
            stmt.setLong(5, mesa.getId()); // Suponiendo que el id_restaurante se pasa a través de la propiedad id
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close(); // Cerrar la conexión
            }
        }
    }

    @Override
    public List<MesaDTO> obtenerTodasLasMesas() throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "SELECT * FROM mesa";
        List<MesaDTO> mesas = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MesaDTO mesa = new MesaDTO(
                        rs.getInt("id_mesa"),
                        rs.getInt("codigo_mesa"),
                        rs.getString("tipo"),
                        rs.getInt("capacidad"),
                        rs.getString("ubicacion")
                );
                mesas.add(mesa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close(); // Cerrar la conexión
            }
        }
        return mesas;
    }

    @Override
    public void actualizarMesa(MesaDTO mesa) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "UPDATE mesa SET codigo_mesa = ?, tipo = ?, capacidad = ?, ubicacion = ? WHERE id_mesa = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, mesa.getCodigoMesa());
            stmt.setString(2, mesa.getTipo());
            stmt.setInt(3, mesa.getCapacidad());
            stmt.setString(4, mesa.getUbicacion());
            stmt.setLong(5, mesa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close(); // Cerrar la conexión
            }
        }
    }

    @Override
    public void eliminarMesa(int id) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "DELETE FROM mesa WHERE id_mesa = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close(); // Cerrar la conexión
            }
        }
    }

    public MesaDTO obtenerMesaPorId(Long id) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "SELECT * FROM mesa WHERE id_mesa = ?";
        MesaDTO mesa = null;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    mesa = new MesaDTO(
                            rs.getInt("id_mesa"),
                            rs.getInt("codigo_mesa"),
                            rs.getString("tipo"),
                            rs.getInt("capacidad"),
                            rs.getString("ubicacion")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close(); // Cerrar la conexión
            }
        }
        return mesa;
    }

    @Override
    public MesaDTO obtenerMesaPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
