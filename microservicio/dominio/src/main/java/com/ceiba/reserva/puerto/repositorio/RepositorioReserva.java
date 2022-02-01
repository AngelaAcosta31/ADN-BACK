package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;

public interface RepositorioReserva {

    /**
     * permite crear una reserva
     */
    Long crear(Reserva reserva);

    /**
     * permite actualizar una reserva
     */
    void actualizar(Reserva reserva);

    /**
     * permite eliminar una reserva
     */
    void eliminar(Long id);

    /**
     * para validar si existe una reserva con ese id
     */
    boolean existePorId(Long id);


    /**
     * para validar si existe una reserva con el id de la habitacion
     */
    boolean existePorIdHabitacion(Long idHabitacion);

    /**
     * para validar si existe una reserva con el id de la habitacion
     */
    boolean existePorIdCliente(Long idCliente);
}
