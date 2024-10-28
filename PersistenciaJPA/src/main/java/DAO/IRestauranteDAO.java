package DAO;

import Entidades.Restaurante;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface IRestauranteDAO {
    /**
     * Agrega un nuevo restaurante a la base de datos.
     * @param restauranteInsertar El objeto Restaurante a insertar.
     * @return El restaurante insertado o null si hubo un error.
     */
    Restaurante agregar(Restaurante restauranteInsertar);

    /**
     * Obtiene todos los restaurantes de la base de datos.
     * @return Lista de todos los restaurantes.
     */
    List<Restaurante> obtenerTodosLosRestaurantes();

    /**
     * Actualiza un restaurante existente en la base de datos.
     * @param restauranteActualizar El objeto Restaurante a actualizar.
     * @return El restaurante actualizado o null si hubo un error.
     */
    Restaurante actualizar(Restaurante restauranteActualizar);

    /**
     * Elimina un restaurante de la base de datos.
     * @param id El ID del restaurante a eliminar.
     * @return true si fue eliminado exitosamente, false si no.
     */
    boolean eliminar(Long id);

    /**
     * Busca un restaurante por su ID.
     * @param id El ID del restaurante a buscar.
     * @return El restaurante encontrado o null si no se encuentra.
     */
    Restaurante buscar(Long id);
}
