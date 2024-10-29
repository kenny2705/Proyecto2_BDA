/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalTime;

/**
 *
 * @author jorge
 */
public class RestauranteDTO {
     private int id_restaurante;
     private String nombre;
    private LocalTime hora_apertura;
    private LocalTime hora_cierre;
    

    public RestauranteDTO() {
    }

    public RestauranteDTO(int id_restaurante, String nombre ,LocalTime hora_apertura, LocalTime hora_cierre) {
        this.id_restaurante = id_restaurante;
        this.nombre = nombre;
        this.hora_apertura = hora_apertura;
        this.hora_cierre = hora_cierre;
        
    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHora_apertura() {
        return hora_apertura;
    }

    public void setHora_apertura(LocalTime hora_apertura) {
        this.hora_apertura = hora_apertura;
    }

    public LocalTime getHora_cierre() {
        return hora_cierre;
    }

    public void setHora_cierre(LocalTime hora_cierre) {
        this.hora_cierre = hora_cierre;
    }

    @Override
    public String toString() {
        return "RestauranteDTO{" + "id_restaurante=" + id_restaurante + ", hora_apertura=" + hora_apertura + ", hora_cierre=" + hora_cierre + ", nombre=" + nombre + '}';
    }

    

    
    
}
