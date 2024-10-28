package Interfaces;

import DTO.ClientesDTO;
import Entidades.Cliente;
import java.sql.SQLException;
import java.util.List;

public interface iCliente {
    
    void agregarCliente(ClientesDTO cliente) throws SQLException;
    List<ClientesDTO> obtenerTodosLosClientes() throws SQLException;
    void actualizarCliente(ClientesDTO cliente) throws SQLException;
    void eliminarCliente(int id) throws SQLException;
    ClientesDTO obtenerClientePorId(int id) throws SQLException;
    
    
    public Cliente agregar(Cliente personaInsertar) throws PersistenciaException;
    public Cliente actualizar(Cliente personaActualizar) throws PersistenciaException;
    public Cliente eliminar(Cliente personaEliminar) throws PersistenciaException;
    public Cliente buscar(int idPersona) throws PersistenciaException;
}
