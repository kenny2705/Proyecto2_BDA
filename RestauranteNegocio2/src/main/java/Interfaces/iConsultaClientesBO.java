package Interfaces;

import DTO.ClientesDTO;
import DTO.ReservasDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author eduardo
 */
public interface iConsultaClientesBO {

    // Método para obtener todos los clientes
    List<ClientesDTO> obtenerTodosLosClientes() throws SQLException;

    // Método para obtener un cliente por su ID
    ClientesDTO obtenerClientePorId(int id) throws SQLException;

    // Método para buscar clientes por nombre (parcial o completo)
    List<ClientesDTO> buscarClientesPorNombre(String nombre) throws SQLException;

    // Método para verificar si un cliente tiene reservas activas
    boolean tieneReservasActivas(int clienteId) throws SQLException;

    // Método para listar las reservas de un cliente específico
    List<ReservasDTO> obtenerReservasPorCliente(int clienteId) throws SQLException;

    // Método para eliminar un cliente por su ID (si no tiene reservas activas)
    boolean eliminarClienteSiNoTieneReservas(int id) throws SQLException;
}
