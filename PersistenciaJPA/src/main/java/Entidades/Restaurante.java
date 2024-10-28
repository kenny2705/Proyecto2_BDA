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
@Table(name = "restaurante")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_restaurante")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String hora_apertura;
    private String hora_cierre;

    public Restaurante() {
    }

    public Restaurante(Long id) {
        this.id = id;
    }

    public Restaurante(String nombre, String hora_apertura, String hora_cierre) {
        this.nombre = nombre;
        this.hora_apertura = hora_apertura;
        this.hora_cierre = hora_cierre;
    }

    public Restaurante(Long id, String nombre, String hora_apertura, String hora_cierre) {
        this.id = id;
        this.nombre = nombre;
        this.hora_apertura = hora_apertura;
        this.hora_cierre = hora_cierre;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora_apertura() {
        return hora_apertura;
    }

    public void setHora_apertura(String hora_apertura) {
        this.hora_apertura = hora_apertura;
    }

    public String getHora_cierre() {
        return hora_cierre;
    }

    public void setHora_cierre(String hora_cierre) {
        this.hora_cierre = hora_cierre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.hora_apertura);
        hash = 13 * hash + Objects.hashCode(this.hora_cierre);
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
        final Restaurante other = (Restaurante) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.hora_apertura, other.hora_apertura)) {
            return false;
        }
        if (!Objects.equals(this.hora_cierre, other.hora_cierre)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Restaurante{" + "id=" + id + ", nombre=" + nombre + ", hora_apertura=" + hora_apertura + ", hora_cierre=" + hora_cierre + '}';
    }

    
    
}
