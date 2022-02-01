package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;

import java.time.LocalDate;
import java.util.List;

public interface DaoReserva {

    /**
     * Permite listar las reservas
     */
    List<DtoReserva> listar();

    /**
     * Permite listar reservas por fecha de entrada
     */
    List<DtoReserva> buscarPorFechaEntrada(LocalDate fechaEntrada);

    /**
     * Permite listar reservas por fecha de salida
     */
    List<DtoReserva> buscarPorFechaSalida(LocalDate fechaSalida);

    /**
     * permite listar por id habitacion
     */
    List<DtoReserva> buscarPorIdHabitacion(Long idHabitacion);

    /**
     * permite listar por id cliente
     */
    List<DtoReserva> buscarPorIdCliente(Long idCliente);

    /**
     * Permite buscar por id
     */
    DtoReserva buscarPorIdReserva(Long idReserva);

}
