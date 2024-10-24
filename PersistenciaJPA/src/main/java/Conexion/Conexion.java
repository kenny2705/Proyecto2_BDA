/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Interfaces.iConexion;
import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class Conexion {

    public Connection conectar() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String u = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String url = "jdbc:mysql://127.0.0.1/reservacionRestaurantes?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "072026";

        try {
            // Registrar el Driver
            Class.forName(driver);
            // Obtener la conexión,pasamos argumentos (url, user y password) para establecer una conexion con la basse de datos
            Connection conexion = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conexion realizada con exito");
            
            return conexion;
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error CLASE NO ENCONTRADA: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
            throw e; // Para que el error sea visible en la clase principal
        }

        return null;

    }

}
