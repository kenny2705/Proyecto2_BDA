package DAO;

import Entidades.Cancelacion;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface ICancelacionDAO {
    /**
     * Agrega una nueva cancelación a la base de datos.
     * @param cancelacionInsertar El objeto Cancelacion a insertar.
     * @return La cancelación insertada o null si hubo un error.
     */
    Cancelacion agregar(Cancelacion cancelacionInsertar);

    /**
     * Obtiene todas las cancelaciones de la base de datos.
     * @return Lista de todas las cancelaciones.
     */
    List<Cancelacion> obtenerTodasLasCancelaciones();

    /**
     * Actualiza una cancelación en la base de datos.
     * @param cancelacionActualizar El objeto Cancelacion a actualizar.
     * @return La cancelación actualizada o null si hubo un error.
     */
    Cancelacion actualizar(Cancelacion cancelacionActualizar);

    /**
     * Elimina una cancelación de la base de datos.
     * @param id El ID de la cancelación a eliminar.
     * @return true si fue eliminada exitosamente, false si no.
     */
    boolean eliminar(Long id);

    /**
     * Busca una cancelación por su ID.
     * @param id El ID de la cancelación a buscar.
     * @return La cancelación encontrada o null si no se encuentra.
     */
    Cancelacion buscar(Long id);
}
