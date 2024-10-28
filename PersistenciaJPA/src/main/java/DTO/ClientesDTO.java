/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author jorge
 */
public class ClientesDTO {
    
    private Long id;
    private String nombreC;
    private String telefono;

    public ClientesDTO() {
    }

    public ClientesDTO(Long id, String nombreC, String telefono) {
        this.id = id;
        this.nombreC = nombreC;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ClientesDTO{" + "id=" + id + ", nombreC=" + nombreC + ", telefono=" + telefono + '}';
    }
    
    
    
}
