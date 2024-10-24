package Interfaces;

import DTO.ReservasDTO;
import java.sql.SQLException;
import java.util.List;

public interface iReserva {
    void agregarReserva(ReservasDTO reserva) throws SQLException;
    List<ReservasDTO> obtenerTodasLasReservas() throws SQLException;
    void actualizarReserva(ReservasDTO reserva) throws SQLException;
    void eliminarReserva(int id) throws SQLException;
    ReservasDTO obtenerReservaPorId(int id) throws SQLException;
}
