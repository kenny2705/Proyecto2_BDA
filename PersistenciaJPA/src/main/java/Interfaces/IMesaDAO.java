/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Mesa;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface IMesaDAO {
    public interface IMesasDAO {
        
    boolean insertarMesa(Mesa mesa);
    boolean actualizarMesa(Mesa mesa);

    List<Mesa> buscarMesasDisponibles(String ubicacion, int capacidad);
}
}
