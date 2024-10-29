/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Cancelacion;
import Entidades.Cliente;
import Entidades.Mesa;
import java.sql.Date;

/**
 *
 * @author jorge
 */
public class ReservasDTO {
    
    private int id;
    private float costoReserva;
    private String estado;
    private int numeroPersonas;
    private Date fechaReserva;
    private Cliente cliente;
    private  Mesa mesa;
    private Cancelacion cancelacion;

    public ReservasDTO() {
    }

    public ReservasDTO(int id, float costoReserva, String estado, int numeroPersonas, Date fechaReserva, Cliente cliente, Mesa mesa, Cancelacion cancelacion) {
        this.id = id;
        this.costoReserva = costoReserva;
        this.estado = estado;
        this.numeroPersonas = numeroPersonas;
        this.fechaReserva = fechaReserva;
        this.cliente = cliente;
        this.mesa = mesa;
        this.cancelacion = cancelacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCostoReserva() {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cancelacion getCancelacion() {
        return cancelacion;
    }

    public void setCancelacion(Cancelacion cancelacion) {
        this.cancelacion = cancelacion;
    }

    

   

    
}
