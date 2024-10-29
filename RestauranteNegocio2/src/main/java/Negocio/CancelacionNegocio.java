package Negocio;

import DTO.CancelacionDTO;
import Entidades.Cancelacion;
import Interfaces.ICancelaNegocio;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jorge
 */
public class CancelacionNegocio implements ICancelaNegocio {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("nombreDeUnidadPersistencia");

    @Override
    public void agregarCancelacion(CancelacionDTO cancelacionDTO) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Cancelacion cancelacion = new Cancelacion();
            cancelacion.setId(cancelacionDTO.getId_cancelacion());
            cancelacion.setMulta(cancelacionDTO.getMulta());
            cancelacion.setFechaCancelacion(cancelacionDTO.getFecha_cancelacion());

            em.persist(cancelacion);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new Exception("Error al agregar la cancelación: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<CancelacionDTO> obtenerTodasLasCancelaciones() throws Exception {
        EntityManager em = emf.createEntityManager();

        try {
            List<Cancelacion> cancelaciones = em.createQuery("SELECT c FROM Cancelacion c", Cancelacion.class).getResultList();
             return (List<CancelacionDTO>) cancelaciones.stream().map(c -> new CancelacionDTO(c.getId(),c.getFechaCancelacion(),c.getMulta())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error al obtener todas las cancelaciones: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public CancelacionDTO obtenerCancelacionPorId(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();

        try {
            Cancelacion cancelacion = em.find(Cancelacion.class, id);
            if (cancelacion == null) {
                throw new Exception("Cancelación no encontrada con el ID: " + id);
            }
            return new CancelacionDTO(cancelacion.getId(), cancelacion.getFechaCancelacion(), cancelacion.getMulta());
        } catch (Exception e) {
            throw new Exception("Error al obtener la cancelación por ID: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
