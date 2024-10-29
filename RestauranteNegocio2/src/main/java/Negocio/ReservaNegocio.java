/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author jorge
 */
import Interfaces.IReservaNegocio;
import DTO.ReservasDTO;
import Entidades.Reserva;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;

public class ReservaNegocio implements IReservaNegocio {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");

    @Override
    public void agregarReserva(ReservasDTO reservaDTO) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Reserva reserva = convertirADominio(reservaDTO);
            em.persist(reserva);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<ReservasDTO> obtenerTodasLasReservas() throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            List<Reserva> reservas = em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
            return reservas.stream().map(this::convertirADTO).collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizarReserva(ReservasDTO reservaDTO) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Reserva reserva = em.find(Reserva.class, reservaDTO.getId());
            if (reserva != null) {
                reserva.setCostoReserva(reservaDTO.getCostoReserva());
                reserva.setEstado(reservaDTO.getEstado());
                reserva.setNumeroPersonas(reservaDTO.getNumeroPersonas());
                reserva.setFechaReserva(reservaDTO.getFechaReserva());
                em.merge(reserva);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarReserva(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Reserva reserva = em.find(Reserva.class, id);
            if (reserva != null) {
                em.remove(reserva);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public ReservasDTO obtenerReservaPorId(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            Reserva reserva = em.find(Reserva.class, id);
            return reserva != null ? convertirADTO(reserva) : null;
        } finally {
            em.close();
        }
    }

    private Reserva convertirADominio(ReservasDTO dto) {
        Reserva reserva = new Reserva();
        reserva.setCostoReserva(dto.getCostoReserva());
        reserva.setEstado(dto.getEstado());
        reserva.setNumeroPersonas(dto.getNumeroPersonas());
        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setId(dto.getId());
        reserva.setMesa(dto.getMesa());
        reserva.setCancelacion(dto.getCancelacion());
        return reserva;
    }

    private ReservasDTO convertirADTO(Reserva reserva) {
        return new ReservasDTO(
                reserva.getId(),
                reserva.getCostoReserva(),
                reserva.getEstado(),
                reserva.getNumeroPersonas(),
                (Date) reserva.getFechaReserva(),
                reserva.getCliente(),
                reserva.getMesa(),
                reserva.getCancelacion());
    }
}
