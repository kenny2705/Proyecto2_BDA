package Interfaces;

import DTO.ClientesDTO;
import java.sql.SQLException;
import java.util.List;

public interface iCliente {
    void agregarCliente(ClientesDTO cliente) throws SQLException;
    List<ClientesDTO> obtenerTodosLosClientes() throws SQLException;
    void actualizarCliente(ClientesDTO cliente) throws SQLException;
    void eliminarCliente(int id) throws SQLException;
    ClientesDTO obtenerClientePorId(int id) throws SQLException;
}
