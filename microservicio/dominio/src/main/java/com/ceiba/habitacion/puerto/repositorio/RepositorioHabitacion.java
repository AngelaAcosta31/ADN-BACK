package com.ceiba.habitacion.puerto.repositorio;

import com.ceiba.habitacion.modelo.entidad.Habitacion;

public interface RepositorioHabitacion {

    /**
     * Permite crear una habitacion
     */
    Long crear(Habitacion habitacion);

    /**
     * permite actualizar una habitacion
     */
    void actualizar(Habitacion habitacion);

    /**
     * permite actualizar el estado de una habitacion
     *
     */
    void actualizarEstado(Long idHabitacion, String estado);

    /**
     * permite eliminar habitacion
     */
    void eliminar(Long id);

    /**
     * para validar si existe una habitacion por numero de habitacion
     */
    boolean existePorNumeroHabitacion(String numeroHabitacion);

    /**
     * permite validar si existe una habitacion con ese id
     */
    boolean existePorId(Long idHabitacion);
}
