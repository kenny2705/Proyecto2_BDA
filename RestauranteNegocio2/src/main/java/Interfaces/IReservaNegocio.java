/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTO.ReservasDTO;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface IReservaNegocio {
     void agregarReserva(ReservasDTO reservaDTO) throws Exception;
    List<ReservasDTO> obtenerTodasLasReservas() throws Exception;
    void actualizarReserva(ReservasDTO reservaDTO) throws Exception;
    void eliminarReserva(Long id) throws Exception;
    ReservasDTO obtenerReservaPorId(Long id) throws Exception;
}
