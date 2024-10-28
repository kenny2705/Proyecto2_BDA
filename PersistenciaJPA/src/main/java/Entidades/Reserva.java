package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author jorge
 */
@Entity
@Table (name = "reserva")
public class Reserva implements Serializable {

    public Reserva() {
    }

    public Reserva(Long id) {
        this.id = id;
    }

    public Reserva(float costo_reserva, String estado, int numero_personas, Date fecha_reserva, Cliente cliente, Mesa mesa, Cancelacion cancelacion) {
        this.costo_reserva = costo_reserva;
        this.estado = estado;
        this.numero_personas = numero_personas;
        this.fecha_reserva = fecha_reserva;
        this.cliente = cliente;
        this.mesa = mesa;
        this.cancelacion = cancelacion;
    }

    public Reserva(Long id, float costo_reserva, String estado, int numero_personas, Date fecha_reserva, Cliente cliente, Mesa mesa, Cancelacion cancelacion) {
        this.id = id;
        this.costo_reserva = costo_reserva;
        this.estado = estado;
        this.numero_personas = numero_personas;
        this.fecha_reserva = fecha_reserva;
        this.cliente = cliente;
        this.mesa = mesa;
        this.cancelacion = cancelacion;
    }
     
    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private float costo_reserva;
    private String estado;
    private int numero_personas;
    private Date fecha_reserva;
    private Cliente cliente;
    private  Mesa mesa;
    private Cancelacion cancelacion;
    
    private static final long serialVersionUID = 1L;  

    public float getCostoReserva() {
        return costo_reserva;
    }

    public void setCostoReserva(float costoReserva) {
        this.costo_reserva = costoReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumeroPersonas() {
        return numero_personas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numero_personas = numeroPersonas;
    }

    public Date getFechaReserva() {
        return fecha_reserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fecha_reserva = fechaReserva;
    }

    public float getCosto_reserva() {
        return costo_reserva;
    }

    public void setCosto_reserva(float costo_reserva) {
        this.costo_reserva = costo_reserva;
    }

    public int getNumero_personas() {
        return numero_personas;
    }

    public void setNumero_personas(int numero_personas) {
        this.numero_personas = numero_personas;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
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
