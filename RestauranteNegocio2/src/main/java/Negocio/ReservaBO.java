package Negocio;

import DAO.MesaDAO;
import DAO.ClienteDAO;
import DAO.ReservaDAO;
import DTO.ClientesDTO;
import DTO.MesaDTO;
import DTO.ReservasDTO;
import java.sql.Date;

public class ReservaBO {

    MesaDAO mesa = new MesaDAO();
    ClienteDAO cliente = new ClienteDAO();
    
    
    private ReservaDAO reservaDAO;
    private MesaDAO mesaDAO;
    private ClienteDAO clienteDAO;

    public ReservaBO(ReservaDAO reservaDAO, MesaDAO mesaDAO, ClienteDAO clienteDAO) {
        this.reservaDAO = reservaDAO;
        this.mesaDAO = mesaDAO;
        this.clienteDAO = clienteDAO;
    }

    // Método para registrar una nueva reserva
    public void registrarReserva(String codigo, Date fecha, int capacidad, int mesaId, int clienteId, float costo) throws Exception {
        // Verificar si la mesa existe
       mesa.obtenerMesaPorId(mesaId);
        if (mesa == null) {
            throw new Exception("La mesa con ID " + mesaId + " no existe.");
        }
        
        // Verificar si el cliente existe
        cliente.obtenerClientePorId(clienteId);
        if (cliente == null) {
            throw new Exception("El cliente con ID " + clienteId + " no existe.");
        }

        // Crear la nueva reserva
        ReservasDTO reserva = new ReservasDTO();
        reserva.setId(0); // Asignar un ID predeterminado (puedes manejar esto en la base de datos)
        reserva.setCostoReserva(costo);
        reserva.setEstado("Reservada"); // Estado inicial
        reserva.setNumeroPersonas(capacidad);
        reserva.setFechaReserva(fecha);

        // Registrar la reserva en la base de datos
        reservaDAO.agregarReserva(reserva);
    }

    // Método para cancelar una reserva
    public double cancelarReserva(int reservaId, Date fechaActual) throws Exception {
        // Obtener la reserva a cancelar
        ReservasDTO reserva = reservaDAO.obtenerReservaPorId(reservaId);
        if (reserva == null) {
            throw new Exception("La reserva con ID " + reservaId + " no existe.");
        }

        // Calcular la diferencia de tiempo entre la fecha actual y la fecha de la reserva
        long diff = reserva.getFechaReserva().getTime() - fechaActual.getTime();
        long horasAnticipacion = diff / (60 * 60 * 1000);

        // Calcular la multa
        double multa = calcularMulta(reserva.getCostoReserva(), horasAnticipacion);
        reserva.setEstado("Cancelada"); // Actualizar estado de la reserva
        reservaDAO.actualizarReserva(reserva); // Actualizar reserva en la base de datos

        return multa; // Devolver la multa calculada
    }

    // Método para calcular la multa dependiendo del tiempo de antelación
    private double calcularMulta(double costoReserva, long horasAnticipacion) {
        if (horasAnticipacion > 48) {
            return 0.0; // Sin multa si se cancela con más de 48 horas de antelación
        } else if (horasAnticipacion >= 24 && horasAnticipacion <= 48) {
            return costoReserva * 0.25; // 25% de multa si se cancela entre 24 y 48 horas
        } else {
            return costoReserva * 0.50; // 50% de multa si se cancela con menos de 24 horas
        }
    }

    
}
