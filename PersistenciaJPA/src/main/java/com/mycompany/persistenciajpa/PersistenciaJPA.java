/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistenciajpa;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author eduar
 */
public class PersistenciaJPA {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Conexion conexion = new Conexion();
        
        try{
            Connection cnx = conexion.conectar();
            System.out.println("Conexion realizada");
            
        }catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        
        
    }
}
