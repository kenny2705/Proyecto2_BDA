package DAO;

import Interfaces.IMesaDAO;
import Entidades.Mesa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class MesaDAO implements IMesaDAO {

   @PersistenceContext
    private EntityManager entityManager;

    public boolean insertarMesa(Mesa mesa) {
        entityManager.persist(mesa);
        return true;
    }

    public boolean actualizarMesa(Mesa mesa) {
        entityManager.merge(mesa);
        return true;
    }

  
    public boolean eliminarMesa(Mesa mesa) {
        entityManager.remove(entityManager.contains(mesa) ? mesa : entityManager.merge(mesa));
        return true;
    }

   
    public List<Mesa> buscarMesasDisponibles(String ubicacion, int capacidad) {
        TypedQuery<Mesa> query = entityManager.createQuery("SELECT * FROM mesa m WHERE m.codigo_mesa NOT IN (SELECT reserva.codigo_mesa FROM Reserva )", Mesa.class);
        query.setParameter("ubicacion", ubicacion);
        query.setParameter("capacidad", capacidad);
        return query.getResultList();
    }
}
