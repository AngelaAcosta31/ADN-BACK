package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;

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
    List<DtoReserva> buscarPorFechaEntrada(LocalDateTime fecha_entrada);

    /**
     * Permite listar reservas por fecha de salida
     * @return lista de reservas
     */
    List<DtoReserva> buscarPorFechaSalida(LocalDateTime fecha_salida);

    /**
     * permite listar por id habitacion
     * @param id_habitacion
     * @return lista de resrevas
     */
    List<DtoReserva> buscarPorIdHabitacion(Long id_habitacion);

    /**
     * permite buscar por id cliente
     * @param id_cliente
     * @return reserva
     */
    DtoReserva buscarPorIdCliente(Long id_cliente);


}
