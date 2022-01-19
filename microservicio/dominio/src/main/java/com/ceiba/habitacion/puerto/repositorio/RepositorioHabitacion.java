package com.ceiba.habitacion.puerto.repositorio;

import com.ceiba.habitacion.modelo.entidad.Habitacion;

public interface RepositorioHabitacion {

    /**
     * Permite crear una habitacion
     * @param habitacion
     * @retun el id generado
     */
    Long crear(Habitacion habitacion);

    /**
     * permite actualizar una habitacion
     * @param habitacion
     */
    void actualizar(Habitacion habitacion);

    /**
     * permite actualizar el estado de una habitacion
     *
     */
    void actualizarEstado(Long idHabitacion, String estado);

    /**
     * permite eliminar habitacion
     * @param id
     */
    void eliminar(Long id);

    /**
     * para validar si existe una habitacion por numero de habitacion
     * @param numero_habitacion
     * @return existe o no
     */
    boolean existePorNumeroHabitacion(String numero_habitacion);

    /**
     * permite validar si existe una habitacion con ese id
     * @param idHabitacion
     * @retun existe o no
     */
    boolean existePorId(Long idHabitacion);
}
