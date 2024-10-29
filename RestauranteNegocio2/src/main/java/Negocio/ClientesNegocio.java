/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Interfaces.IClienteNegocio;
import DTO.ClientesDTO;
import Entidades.Cliente;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jorge
 */
public class ClientesNegocio implements IClienteNegocio {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");


    public void agregarCliente(ClientesDTO clienteDTO) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Cliente cliente = convertirADominio(clienteDTO);
            em.persist(cliente);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }


    public List<ClientesDTO> obtenerTodosLosClientes() throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            List<Cliente> clientes = em.createQuery("SELECT * FROM cliente c", Cliente.class).getResultList();
            return clientes.stream().map(this::convertirADTO).collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

   
    public void actualizarCliente(ClientesDTO clienteDTO) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Cliente cliente = em.find(Cliente.class, clienteDTO.getId());
            if (cliente != null) {
                cliente.setNombre_completo(clienteDTO.getNombreC());
                cliente.setTelefono(clienteDTO.getTelefono());
                em.merge(cliente);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    
    public void eliminarCliente(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                em.remove(cliente);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public ClientesDTO obtenerClientePorId(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, id);
            return cliente != null ? convertirADTO(cliente) : null;
        } finally {
            em.close();
        }
    }

    private Cliente convertirADominio(ClientesDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre_completo(dto.getNombreC());
        cliente.setTelefono(dto.getTelefono());
        return cliente;
    }

    private ClientesDTO convertirADTO(Cliente cliente) {
        return new ClientesDTO(
                cliente.getId(),
                cliente.getNombre_completo(),
                cliente.getTelefono()
        );
    }
}