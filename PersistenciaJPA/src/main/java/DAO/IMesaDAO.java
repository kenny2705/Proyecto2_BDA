/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Mesa;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface IMesaDAO {
    /**
     * Agrega una nueva mesa a la base de datos.
     * @param mesaInsertar El objeto Mesa a insertar.
     * @return La mesa insertada o null si hubo un error.
     */
    Mesa agregar(Mesa mesaInsertar);

    /**
     * Obtiene todas las mesas de la base de datos.
     * @return Lista de todas las mesas.
     */
    List<Mesa> obtenerTodasLasMesas();

    /**
     * Actualiza una mesa existente en la base de datos.
     * @param mesaActualizar El objeto Mesa a actualizar.
     * @return La mesa actualizada o null si hubo un error.
     */
    Mesa actualizar(Mesa mesaActualizar);

    /**
     * Elimina una mesa de la base de datos.
     * @param id El ID de la mesa a eliminar.
     * @return true si fue eliminada exitosamente, false si no.
     */
    boolean eliminar(Long id);

    /**
     * Busca una mesa por su ID.
     * @param id El ID de la mesa a buscar.
     * @return La mesa encontrada o null si no se encuentra.
     */
    Mesa buscar(Long id);
}
