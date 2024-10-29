/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTO.RestauranteDTO;
import Entidades.Restaurante;
import Interfaces.IRestauranteNegocio;
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
public class RestauranteNegocio implements IRestauranteNegocio {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");

    @Override
    public void agregarRestaurante(RestauranteDTO restauranteDTO) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Restaurante restaurante = convertirADominio(restauranteDTO);
            em.persist(restaurante);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<RestauranteDTO> obtenerTodosLosRestaurantes() throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            List<Restaurante> restaurantes = em.createQuery("SELECT r FROM Restaurante r", Restaurante.class).getResultList();
            return restaurantes.stream().map(this::convertirADTO).collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizarRestaurante(RestauranteDTO restauranteDTO) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Restaurante restaurante = em.find(Restaurante.class, restauranteDTO.getId_restaurante());
            if (restaurante != null) {
                restaurante.setNombre(restauranteDTO.getNombre());
                em.merge(restaurante);
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
    public void eliminarRestaurante(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Restaurante restaurante = em.find(Restaurante.class, id);
            if (restaurante != null) {
                em.remove(restaurante);
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
    public RestauranteDTO obtenerRestaurantePorId(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            Restaurante restaurante = em.find(Restaurante.class, id);
            return restaurante != null ? convertirADTO(restaurante) : null;
        } finally {
            em.close();
        }
    }

    private Restaurante convertirADominio(RestauranteDTO dto) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNombre(dto.getNombre());
        return restaurante;
    }

    private RestauranteDTO convertirADTO(Restaurante restaurante) {
        return new RestauranteDTO(
                restaurante.getId(),
                restaurante.getNombre(),
                restaurante.getHora_apertura(),
                restaurante.getHora_cierre()
                );
    }
}