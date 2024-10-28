package Entidades;

import java.io.Serializable;
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
@Table(name = "mesa")
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_mesa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int codigo_mesa;
    private String tipo;
    private int capacidad;
    private String ubicacion;

    public Mesa() {
    }

    public Mesa(Long id) {
        this.id = id;
    }

    public Mesa(int codigo_mesa, String tipo, int capacidad, String ubicacion) {
        this.codigo_mesa = codigo_mesa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    public Mesa(Long id, int codigo_mesa, String tipo, int capacidad, String ubicacion) {
        this.id = id;
        this.codigo_mesa = codigo_mesa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigo_mesa() {
        return codigo_mesa;
    }

    public void setCodigo_mesa(int codigo_mesa) {
        this.codigo_mesa = codigo_mesa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + this.codigo_mesa;
        hash = 79 * hash + Objects.hashCode(this.tipo);
        hash = 79 * hash + this.capacidad;
        hash = 79 * hash + Objects.hashCode(this.ubicacion);
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
        final Mesa other = (Mesa) obj;
        if (this.codigo_mesa != other.codigo_mesa) {
            return false;
        }
        if (this.capacidad != other.capacidad) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Mesa{" + "id=" + id + ", codigo_mesa=" + codigo_mesa + ", tipo=" + tipo + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion + '}';
    }
    
}
