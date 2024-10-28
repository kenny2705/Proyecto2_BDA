package DAO;

import Entidades.Reserva;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface IReservaDAO {
    /**
     * Agrega una nueva reserva a la base de datos.
     * @param reservaInsertar El objeto Reserva a insertar.
     * @return La reserva insertada o null si hubo un error.
     */
    Reserva agregar(Reserva reservaInsertar);

    /**
     * Obtiene todas las reservas de la base de datos.
     * @return Lista de todas las reservas.
     */
    List<Reserva> obtenerTodasLasReservas();

    /**
     * Actualiza una reserva existente en la base de datos.
     * @param reservaActualizar El objeto Reserva a actualizar.
     * @return La reserva actualizada o null si hubo un error.
     */
    Reserva actualizar(Reserva reservaActualizar);

    /**
     * Elimina una reserva de la base de datos.
     * @param id El ID de la reserva a eliminar.
     * @return true si fue eliminada exitosamente, false si no.
     */
    boolean eliminar(Long id);

    /**
     * Busca una reserva por su ID.
     * @param id El ID de la reserva a buscar.
     * @return La reserva encontrada o null si no se encuentra.
     */
    Reserva buscar(Long id);
}
