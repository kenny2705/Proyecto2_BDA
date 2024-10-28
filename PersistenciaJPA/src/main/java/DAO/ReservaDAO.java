package dao;


import Entidades.Reserva;
import Interfaces.IReservaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class ReservaDAO implements IReservaDAO {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public boolean insertarReserva(Reserva reserva) {
        emf.persist(reserva);
        return true;
    }

    @Override
    public boolean actualizarReserva(Reserva reserva) {
        emf.merge(reserva);
        return true;
    }

    @Override
    public boolean eliminarReserva(Reserva reserva) {
        emf.remove(emf.contains(reserva) ? reserva : emf.merge(reserva));
        return true;
    }

    @Override
    public Reserva buscarReservaPorId(int id) {
        return emf.find(Reserva.class, id);
    }

    @Override
    public List<Reserva> buscarReservasPorCliente(String clienteId) {
        TypedQuery<Reserva> query = emf.createQuery("SELECT reservacionrestaurantes FROM reserva reservacionrestaurantes WHERE reservacionrestaurantes.id_cliente = :id_cliente", Reserva.class);
        query.setParameter("id_cliente", clienteId);
        return query.getResultList();
    }
}
