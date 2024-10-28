/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "cancelacion")
public class Cancelacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_cancelacion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date fechaCancelacion;
    private float multa;
    
    public Cancelacion() {
    }

    public Cancelacion(Long id) {
        this.id = id;
    }

    public Cancelacion(Date fechaCancelacion, float multa) {
        this.fechaCancelacion = fechaCancelacion;
        this.multa = multa;
    }

    public Cancelacion(Long id, Date fechaCancelacion, float multa) {
        this.id = id;
        this.fechaCancelacion = fechaCancelacion;
        this.multa = multa;
    }
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.fechaCancelacion);
        hash = 37 * hash + Float.floatToIntBits(this.multa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cancelacion other = (Cancelacion) obj;
        if (Float.floatToIntBits(this.multa) != Float.floatToIntBits(other.multa)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.fechaCancelacion, other.fechaCancelacion);
    }

    @Override
    public String toString() {
        return "Cancelacion{" + "id=" + id + ", fechaCancelacion=" + fechaCancelacion + ", multa=" + multa + '}';
    }
    
    
    
    
}
