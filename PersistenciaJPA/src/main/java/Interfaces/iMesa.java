package Interfaces;

import DTO.MesaDTO;
import java.sql.SQLException;
import java.util.List;

public interface iMesa {
    void agregarMesa(MesaDTO mesa) throws SQLException;
    List<MesaDTO> obtenerTodasLasMesas() throws SQLException;
    void actualizarMesa(MesaDTO mesa) throws SQLException;
    void eliminarMesa(int id) throws SQLException;
    MesaDTO obtenerMesaPorId(int id) throws SQLException;
}
