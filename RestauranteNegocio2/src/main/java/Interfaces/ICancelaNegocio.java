/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTO.CancelacionDTO;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface ICancelaNegocio {
    void agregarCancelacion(CancelacionDTO cancelacionDTO) throws Exception;
    List<CancelacionDTO> obtenerTodasLasCancelaciones() throws Exception;
    void actualizarCancelacion(CancelacionDTO cancelacionDTO) throws Exception;
    void eliminarCancelacion(Long id) throws Exception;
    CancelacionDTO obtenerCancelacionPorId(Long id) throws Exception;
}