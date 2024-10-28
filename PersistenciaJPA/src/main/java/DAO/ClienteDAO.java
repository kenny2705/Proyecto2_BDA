package DAO;

import Interfaces.iCliente; // Importar la interfaz
import DTO.ClientesDTO; // Importar la clase ClientesDTO
import Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ClienteDAO implements iCliente {
    
    EntityManagerFactory emf;

    public ClienteDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    

    @Override
    public Cliente agregarCliente(ClientesDTO cliente) throws SQLException {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist();
        }
//        String query = "INSERT INTO cliente (nombre_completo, telefono) VALUES (?, ?)";
//        
//        
//        try (PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setString(1, cliente.getNombreC());
//            stmt.setString(2, cliente.getTelefono());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
//            if (conn != null) {
//                conn.close(); // Cerrar la conexión
//            }
//        }
    }

    @Override
    public List<ClientesDTO> obtenerTodosLosClientes() throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "SELECT * FROM cliente";
        List<ClientesDTO> clientes = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ClientesDTO cliente = new ClientesDTO(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre_completo"),
                        rs.getString("telefono")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close(); // Cerrar la conexión
            }
        }
        return clientes;
    }

    @Override
    public void actualizarCliente(ClientesDTO cliente) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "UPDATE cliente SET nombre_completo = ?, telefono = ? WHERE id_cliente = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombreC());
            stmt.setString(2, cliente.getTelefono());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close(); // Cerrar la conexión
            }
        }
    }

    @Override
    public void eliminarCliente(int id) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "DELETE FROM cliente WHERE id_cliente = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close(); // Cerrar la conexión
            }
        }
    }

    @Override
    public ClientesDTO obtenerClientePorId(int id) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        String query = "SELECT * FROM cliente WHERE id_cliente = ?";
        ClientesDTO cliente = null;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new ClientesDTO(
                            rs.getInt("id_cliente"),
                            rs.getString("nombre_completo"),
                            rs.getString("telefono")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close(); // Cerrar la conexión
            }
        }
        return cliente;
    }

    @Override
    public Cliente agregar(Cliente personaInsertar) throws Object {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente actualizar(Cliente personaActualizar) throws Object {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente eliminar(Cliente personaEliminar) throws Object {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente buscar(int idPersona) throws Object {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
