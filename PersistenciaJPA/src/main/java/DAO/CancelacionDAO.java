/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Cancelacion;
import Interfaces.ICancelacionDAO;
import java.util.List;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

/**
 *
 * @author jorge
 */
public class CancelacionDAO implements ICancelacionDAO{

      @PersistenceContext
    private EntityManager entityManager;

    @Override

    public boolean insertarCancelacion(Cancelacion cancelacion) {
        entityManager.persist(cancelacion);
        return true;
    }

    @Override

    public boolean actualizarCancelacion(Cancelacion cancelacion) {
        entityManager.merge(cancelacion);
        return true;
    }

    @Override
    public Cancelacion buscarCancelacionPorId(int id) {
        return entityManager.find(Cancelacion.class, id);
    }

    @Override  
    public boolean eliminarCancelacion(int id) {
        Cancelacion cancelacion = entityManager.find(Cancelacion.class, id);
        if (cancelacion != null) {
            entityManager.remove(cancelacion);
            return true;
        }
        return false;
    }

    @Override
    public List<Cancelacion> obtenerTodasLasCancelaciones() {
        return entityManager.createQuery("SELECT id_cancelacion FROM cancelacion ", Cancelacion.class).getResultList();
    }
}
