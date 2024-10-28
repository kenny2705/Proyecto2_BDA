/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Restaurante;
import Interfaces.IRestauranteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jorge
 */
public class RestauranteDAO implements IRestauranteDAO{
    
      @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean insertarRestaurante(Restaurante restaurante) {
        entityManager.persist(restaurante);
        return true;
    }

    @Override
    public boolean actualizarRestaurante(Restaurante restaurante) {
        entityManager.merge(restaurante);
        return true;
    }

    
    public Restaurante buscarRestaurantePorId(int id) {
        return entityManager.find(Restaurante.class, id);
    }

   
   
    public boolean eliminarRestaurante(int id) {
        Restaurante restaurante = entityManager.find(Restaurante.class, id);
        if (restaurante != null) {
            entityManager.remove(restaurante);
            return true;
        }
        return false;
    }

    @Override
    public List<Restaurante> obtenerTodosLosRestaurantes() {
        return entityManager.createQuery("SELECT r FROM Restaurante r", Restaurante.class).getResultList();
    }
    
}
