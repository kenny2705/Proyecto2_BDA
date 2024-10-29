package Interfaces;

import DTO.ReservasDTO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author eduardo
 */
public interface iReservaBO {

    // Método para registrar una nueva reserva
    boolean registrarReserva(String codigo, Date fecha, int capacidad, Long mesaId, Long clienteId, double costo) throws SQLException;

    // Método para cancelar una reserva y devolver la multa aplicable
    double cancelarReserva(Long reservaId, Date fechaActual) throws SQLException;

    // Método para calcular la multa según la anticipación de la cancelación
    double calcularMulta(double costoReserva, long horasAnticipacion);

    // Método para obtener una lista de todas las reservas
    List<ReservasDTO> obtenerTodasLasReservas() throws SQLException;

    // Método para obtener una reserva específica por su ID
    ReservasDTO obtenerReservaPorId(Long reservaId) throws SQLException;

    // Método para actualizar el estado o detalles de una reserva específica
    boolean actualizarReserva(ReservasDTO reserva) throws SQLException;

    // Método para listar reservas por un criterio específico (ejemplo: fecha, estado)
    List<ReservasDTO> listarReservasPorFecha(Date fecha) throws SQLException;
}
