
package Interfaces;

import Entidades.Cliente;
import DAO.ClienteDAO;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface IClienteDAO {
    
    boolean insertarCliente(Cliente cliente);
    boolean actualizarCliente(Cliente cliente);
    Cliente buscarClientePorId(String id);
}
