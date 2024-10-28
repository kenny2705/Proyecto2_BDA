package Interfaces;

import Entidades.Cancelacion;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface ICancelacionDAO {
    
     boolean insertarCancelacion(Cancelacion cancelacion);
    boolean actualizarCancelacion(Cancelacion cancelacion);
    Cancelacion buscarCancelacionPorId(int id);
    boolean eliminarCancelacion(int id);
    List<Cancelacion> obtenerTodasLasCancelaciones();
}
