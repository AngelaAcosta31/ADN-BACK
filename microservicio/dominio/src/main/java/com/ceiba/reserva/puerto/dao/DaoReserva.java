package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;

import java.time.LocalDate;
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
    List<DtoReserva> buscarPorFechaEntrada(LocalDate fechaEntrada);

    /**
     * Permite listar reservas por fecha de salida
     * @return lista de reservas
     */
    List<DtoReserva> buscarPorFechaSalida(LocalDate fechaSalida);

    /**
     * permite listar por id habitacion
     * @param idHabitacion
     * @return lista de resrevas
     */
    List<DtoReserva> buscarPorIdHabitacion(Long idHabitacion);

    /**
     * permite listar por id cliente
     * @param idCliente
     * @return reserva
     */
    List<DtoReserva> buscarPorIdCliente(Long idCliente);


}
