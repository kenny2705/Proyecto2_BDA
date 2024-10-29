/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");

    @Override
    public void agregarCancelacion(CancelacionDTO cancelacionDTO) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Cancelacion cancelacion = convertirADominio(cancelacionDTO);
            em.persist(cancelacion);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<CancelacionDTO> obtenerTodasLasCancelaciones() throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            List<Cancelacion> cancelaciones = em.createQuery("SELECT c FROM Cancelacion c", Cancelacion.class).getResultList();
            return cancelaciones.stream().map(this::convertirADTO).collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizarCancelacion(CancelacionDTO cancelacionDTO) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Cancelacion cancelacion = em.find(Cancelacion.class, cancelacionDTO.getId_cancelacion());
            if (cancelacion != null) {
                cancelacion.setMulta(cancelacionDTO.getMulta());
                cancelacion.setFechaCancelacion(cancelacionDTO.getFecha_cancelacion());
                em.merge(cancelacion);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarCancelacion(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Cancelacion cancelacion = em.find(Cancelacion.class, id);
            if (cancelacion != null) {
                em.remove(cancelacion);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public CancelacionDTO obtenerCancelacionPorId(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            Cancelacion cancelacion = em.find(Cancelacion.class, id);
            return cancelacion != null ? convertirADTO(cancelacion) : null;
        } finally {
            em.close();
        }
    }
}
