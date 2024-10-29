/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTO.MesaDTO;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface IMesaNegocio {
    
    void agregarMesa(MesaDTO mesaDTO) throws Exception;
    List<MesaDTO> obtenerTodasLasMesas() throws Exception;
    void actualizarMesa(MesaDTO mesaDTO) throws Exception;
    void eliminarMesa(Long id) throws Exception;
    MesaDTO obtenerMesaPorId(Long id) throws Exception;
}
