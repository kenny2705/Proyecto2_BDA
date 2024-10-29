/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author jorge
 */
public class CancelacionDTO {
     private Long id_cancelacion;
    private Date fecha_cancelacion;
    private float multa;

    public CancelacionDTO() {
    }

    public CancelacionDTO(Long id_cancelacion, Date fecha_cancelacion, float multa) {
        this.id_cancelacion = id_cancelacion;
        this.fecha_cancelacion = fecha_cancelacion;
        this.multa = multa;
    }

    public Long getId_cancelacion() {
        return id_cancelacion;
    }

    public void setId_cancelacion(Long id_cancelacion) {
        this.id_cancelacion = id_cancelacion;
    }

    public Date getFecha_cancelacion() {
        return fecha_cancelacion;
    }

    public void setFecha_cancelacion(Date fecha_cancelacion) {
        this.fecha_cancelacion = fecha_cancelacion;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        return "CancelacionDTO{" + "id_cancelacion=" + id_cancelacion + ", fecha_cancelacion=" + fecha_cancelacion + ", multa=" + multa + '}';
    }
    
}
