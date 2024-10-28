/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author jorge
 */
public class ReservasDTO {
    
    private Long id;
    private double costoReserva;
    private String estado;
    private int numeroPersonas;
    private Date fechaReserva;

    public ReservasDTO() {
    }

    public ReservasDTO(Long id, float costoReserva, String estado, int numeroPersonas, Date fechaReserva) {
        this.id = id;
        this.costoReserva = costoReserva;
        this.estado = estado;
        this.numeroPersonas = numeroPersonas;
        this.fechaReserva = fechaReserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCostoReserva() {
        return costoReserva;
    }

    public void setCostoReserva(float costoReserva) {
        this.costoReserva = costoReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    @Override
    public String toString() {
        return "ReservasDTO{" + "id=" + id + ", costoReserva=" + costoReserva + ", estado=" + estado + ", numeroPersonas=" + numeroPersonas + ", fechaReserva=" + fechaReserva + '}';
    }
    
    
}
