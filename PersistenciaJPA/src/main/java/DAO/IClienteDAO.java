
package DAO;

import Entidades.Cliente;
import DAO.ClienteDAO;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface IClienteDAO {
    /**
     * Agrega un nuevo cliente a la base de datos.
     * @param clienteInsertar El objeto Cliente a insertar.
     * @return El cliente insertado, o null si hubo algún error.
     */
    Cliente agregar(Cliente clienteInsertar);

    /**
     * Obtiene todos los clientes de la base de datos.
     * @return Una lista con todos los clientes.
     */
    List<Cliente> obtenerTodosLosClientes();

    /**
     * Actualiza un cliente existente en la base de datos.
     * @param clienteActualizar El objeto Cliente con los datos actualizados.
     * @return El cliente actualizado, o null si hubo algún error.
     */
    Cliente actualizar(Cliente clienteActualizar);

    /**
     * Elimina un cliente de la base de datos.
     * @param id El ID del cliente a eliminar.
     * @return true si el cliente fue eliminado exitosamente, false si no se encontró o hubo un error.
     */
    boolean eliminar(Long id);

    /**
     * Busca un cliente por su ID.
     * @param id El ID del cliente a buscar.
     * @return El cliente encontrado, o null si no se encontró.
     */
    Cliente buscar(Long id);
}
