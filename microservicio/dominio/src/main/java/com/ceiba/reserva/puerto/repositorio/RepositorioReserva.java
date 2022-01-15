package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;

public interface RepositorioReserva {

    /**
     * permite crear una reserva
     * @param reserva
     * @return el id generado
     */
    Long crear(Reserva reserva);

    /**
     * permite actualizar una reserva
     * @param reserva
     */
    void actualizar(Reserva reserva);

    /**
     * permite eliminar una reserva
     * @param id
     */
    void eliminar(Long id);

    /**
     * para validar si existe una reserva con ese id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
