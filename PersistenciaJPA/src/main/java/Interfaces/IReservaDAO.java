package Interfaces;

import Entidades.Reserva;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface IReservaDAO {
    boolean insertarReserva(Reserva reserva);
    boolean actualizarReserva(Reserva reserva);
    boolean eliminarReserva(Reserva reserva);
    Reserva buscarReservaPorId(int id);
    List<Reserva> buscarReservasPorCliente(String clienteId);
}
