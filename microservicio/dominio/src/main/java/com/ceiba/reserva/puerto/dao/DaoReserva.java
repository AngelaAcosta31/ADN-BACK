package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface DaoReserva {

    /**
     * Permite listar las reservas
     * @return lista de reservas
     */
    List<DtoReserva> listar();

    /**
     * Permite listar reservas por fecha de entrada
     * @return lsita de reservas
     */
    List<DtoReserva> buscarPorFechaEntrada(LocalDate fecha_entrada);

    /**
     * Permite listar reservas por fecha de salida
     * @return lista de reservas
     */
    List<DtoReserva> buscarPorFechaSalida(LocalDate fecha_salida);

    /**
     * permite listar por id habitacion
     * @param id_habitacion
     * @return lista de resrevas
     */
    List<DtoReserva> buscarPorIdHabitacion(Long id_habitacion);

    /**
     * permite listar por id cliente
     * @param id_cliente
     * @return reserva
     */
    List<DtoReserva> buscarPorIdCliente(Long id_cliente);

    /**
     * permite obtener el precio de la habitacion
     * @param id_habitacion
     * @return precio habitacion
     */
    DtoReserva obtenerPrecioHabitacion(Long id_habitacion);
}
