package DAO;

import Interfaces.iReserva; // Importar la interfaz
import DTO.ReservasDTO; // Importar la clase ReservasDTO
import Conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO implements iReserva {

    @Override
    public void agregarReserva(ReservasDTO reserva) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "INSERT INTO reserva (costo_reserva, estado, numero_personas, fecha_reserva, id_cliente, codigo_mesa, id_cancelacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, reserva.getCostoReserva());
            stmt.setString(2, reserva.getEstado());
            stmt.setInt(3, reserva.getNumeroPersonas());
            stmt.setDate(4, reserva.getFechaReserva());
            stmt.setInt(5, reserva.getId()); // Suponiendo que el id_cliente se pasa a través de la propiedad id
            stmt.setInt(6, reserva.getId()); // Suponiendo que el codigo_mesa se pasa a través de la propiedad id
            stmt.setInt(7, reserva.getId()); // Suponiendo que el id_cancelacion se pasa a través de la propiedad id
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
    public List<ReservasDTO> obtenerTodasLasReservas() throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "SELECT * FROM reserva";
        List<ReservasDTO> reservas = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ReservasDTO reserva = new ReservasDTO(
                        rs.getInt("id_reserva"), 
                        (float) rs.getDouble("costo_reserva"),
                        rs.getString("estado"),
                        rs.getInt("numero_personas"),
                        rs.getDate("fecha_reserva")
                );
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close(); // Cerrar la conexión
            }
        }
        return reservas;
    }

    @Override
    public void actualizarReserva(ReservasDTO reserva) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "UPDATE reserva SET costo_reserva = ?, estado = ?, numero_personas = ?, fecha_reserva = ? WHERE id_reserva = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, reserva.getCostoReserva());
            stmt.setString(2, reserva.getEstado());
            stmt.setInt(3, reserva.getNumeroPersonas());
            stmt.setDate(4, reserva.getFechaReserva());
            stmt.setInt(5, reserva.getId());
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
    public void eliminarReserva(int id) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "DELETE FROM reserva WHERE id_reserva = ?";
        
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

    @Override
    public ReservasDTO obtenerReservaPorId(int id) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "SELECT * FROM reserva WHERE id_reserva = ?";
        ReservasDTO reserva = null;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    reserva = new ReservasDTO(
                            rs.getInt("id_reserva"), 
                            (float) rs.getDouble("costo_reserva"),
                            rs.getString("estado"),
                            rs.getInt("numero_personas"),
                            rs.getDate("fecha_reserva")
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
        return reserva;
    }
}
