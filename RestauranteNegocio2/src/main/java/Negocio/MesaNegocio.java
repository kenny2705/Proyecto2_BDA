/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTO.MesaDTO;
import Entidades.Mesa;
import Interfaces.IMesaNegocio;
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
public class MesaNegocio implements IMesaNegocio {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_restaurante");

    @Override
    public void agregarMesa(MesaDTO mesaDTO) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Mesa mesa = convertirADominio(mesaDTO);
            em.persist(mesa);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<MesaDTO> obtenerTodasLasMesas() throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            List<Mesa> mesas = em.createQuery("SELECT m FROM Mesa m", Mesa.class).getResultList();
            return mesas.stream().map(this::convertirADTO).collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizarMesa(MesaDTO mesaDTO) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Mesa mesa = em.find(Mesa.class, mesaDTO.getId());
            if (mesa != null) {
                mesa.setCodigo_mesa((int) mesaDTO.getCodigoMesa());
                mesa.setCapacidad(mesaDTO.getCapacidad());
                mesa.setTipo(mesaDTO.getTipo());
                mesa.setUbicacion(mesaDTO.getUbicacion());
                em.merge(mesa);
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
    public void eliminarMesa(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Mesa mesa = em.find(Mesa.class, id);
            if (mesa != null) {
                em.remove(mesa);
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
    public MesaDTO obtenerMesaPorId(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            Mesa mesa = em.find(Mesa.class, id);
            return mesa != null ? convertirADTO(mesa) : null;
        } finally {
            em.close();
        }
    }

    private Mesa convertirADominio(MesaDTO dto) {
        Mesa mesa = new Mesa();
        mesa.setId((int) dto.getCodigoMesa());
        mesa.setCapacidad(dto.getCapacidad());
        mesa.setTipo(dto.getTipo());
        mesa.setUbicacion(dto.getUbicacion());
        return mesa;
    }

    private MesaDTO convertirADTO(Mesa mesa) {
        return new MesaDTO(
                mesa.getId(),
                mesa.getCodigo_mesa(),
                mesa.getTipo(),
                mesa.getCapacidad(),
                mesa.getUbicacion()
        );
    }
}
