package Interfaces;

import DTO.ClientesDTO;
import java.sql.SQLException;

/**
 *
 * @author eduardo
 */
public interface iRegistroClientesBO {

    // Método para registrar un nuevo cliente
    boolean registrarCliente(ClientesDTO cliente) throws SQLException;

    // Método para actualizar los datos de un cliente existente
    boolean actualizarCliente(ClientesDTO cliente) throws SQLException;

    // Método para validar la información de un cliente antes de registrarlo o actualizarlo
    boolean validarDatosCliente(ClientesDTO cliente);

    // Método para verificar si un cliente ya está registrado mediante su teléfono u otro identificador
    boolean clienteExiste(String telefono) throws SQLException;

    // Método para eliminar un cliente si cumple con ciertos requisitos (por ejemplo, sin reservas activas)
    boolean eliminarCliente(int clienteId) throws SQLException;
}
