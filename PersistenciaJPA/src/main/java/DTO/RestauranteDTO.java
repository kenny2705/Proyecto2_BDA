package DTO;

import java.time.LocalTime;

/**
 *
 * @author kevin
 */
public class RestauranteDTO {
    private Long id_restaurante;
    private LocalTime hora_apertura;
    private LocalTime hora_cierre;
    private String nombre;

    public RestauranteDTO() {
    }

    public RestauranteDTO(Long id_restaurante, LocalTime hora_apertura, LocalTime hora_cierre, String nombre) {
        this.id_restaurante = id_restaurante;
        this.hora_apertura = hora_apertura;
        this.hora_cierre = hora_cierre;
        this.nombre = nombre;
    }

    public Long getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(Long id_restaurante) {
        this.id_restaurante = id_restaurante;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "RestauranteDTO{" + "id_restaurante=" + id_restaurante + ", hora_apertura=" + hora_apertura + ", hora_cierre=" + hora_cierre + ", nombre=" + nombre + '}';
    }
    
    
    
}
