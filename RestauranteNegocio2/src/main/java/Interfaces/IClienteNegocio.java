/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author jorge
 */
import DTO.ClientesDTO;
import java.util.List;

public interface IClienteNegocio {
    void agregarCliente(ClientesDTO clienteDTO) throws Exception;
    List<ClientesDTO> obtenerTodosLosClientes() throws Exception;
    void actualizarCliente(ClientesDTO clienteDTO) throws Exception;
    void eliminarCliente(Long id) throws Exception;
    ClientesDTO obtenerClientePorId(Long id) throws Exception;
}

