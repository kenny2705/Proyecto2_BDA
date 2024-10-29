/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTO.RestauranteDTO;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface IRestauranteNegocio {
    void agregarRestaurante(RestauranteDTO restauranteDTO) throws Exception;
    List<RestauranteDTO> obtenerTodosLosRestaurantes() throws Exception;
    void actualizarRestaurante(RestauranteDTO restauranteDTO) throws Exception;
    void eliminarRestaurante(Long id) throws Exception;
    RestauranteDTO obtenerRestaurantePorId(Long id) throws Exception;
}

