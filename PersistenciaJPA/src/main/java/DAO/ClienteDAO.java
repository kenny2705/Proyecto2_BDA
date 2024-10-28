package DAO;
 
import Interfaces.IClienteDAO;
import Entidades.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
public class ClienteDAO implements IClienteDAO {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean insertarCliente(Cliente cliente) {
        entityManager.persist(cliente);
        return true;
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        entityManager.merge(cliente);
        return true;
    }

    @Override
    public Cliente buscarClientePorId(String id) {
        return entityManager.find(Cliente.class, id);
    }
}
