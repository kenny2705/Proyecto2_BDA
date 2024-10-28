/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.ClienteDAO;
import DAO.MesaDAO;
import DAO.ReservaDAO;
import java.sql.Date;

/**
 *
 * @author kevin
 */
public class ReservaBO {

    private ReservaDAO reservaDAO;
    private MesaDAO mesaDAO;
    private ClienteDAO clienteDAO;

    public ReservaBO(ReservaDAO reservaDAO, MesaDAO mesaDAO, ClienteDAO clienteDAO) {
        this.reservaDAO = reservaDAO;
        this.mesaDAO = mesaDAO;
        this.clienteDAO = clienteDAO;
    }

    // Método para registrar una nueva reserva
    public void registrarReserva(String codigo, Date fecha, int capacidad, Long mesaId, Long clienteId, double costo) {
        Mesa mesa = mesaDAO.obtenerMesaPorId(mesaId);
        Cliente cliente = clienteDAO.obtenerClientePorId(clienteId);
        
        Reserva reserva = new Reserva();
        reserva.setCodigo(codigo);
        reserva.setFecha(fecha);
        reserva.setCapacidad(capacidad);
        reserva.setMesa(mesa);
        reserva.setCliente(cliente);
        reserva.setCosto(costo);
        reservaDAO.guardarReserva(reserva);
    }

    // Método para cancelar una reserva
    public double cancelarReserva(Long reservaId, Date fechaActual) {
        Reserva reserva = reservaDAO.obtenerReservaPorId(reservaId);
        
        long diff = reserva.getFecha().getTime() - fechaActual.getTime();
        long horasAnticipacion = diff / (60 * 60 * 1000);

        double multa = calcularMulta(reserva.getCosto(), horasAnticipacion);
        reserva.setMulta(multa);
        reservaDAO.actualizarReserva(reserva);

        return multa;
    }

    // Método para calcular la multa dependiendo del tiempo de antelación
    private double calcularMulta(double costoReserva, long horasAnticipacion) {
        if (horasAnticipacion > 48) {
            return 0.0;
        } else if (horasAnticipacion >= 24 && horasAnticipacion <= 48) {
            return costoReserva * 0.25;
        } else {
            return costoReserva * 0.50;
        }
    }

    // Otros métodos relacionados con reservas, como buscar, listar, etc.
}

