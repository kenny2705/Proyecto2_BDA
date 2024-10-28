package Interfaces;

import Entidades.Restaurante;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface IRestauranteDAO {
    
   boolean insertarRestaurante(Restaurante restaurante);
    boolean actualizarRestaurante(Restaurante restaurante);
    List<Restaurante> obtenerTodosLosRestaurantes();
}
