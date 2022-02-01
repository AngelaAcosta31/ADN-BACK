package com.ceiba.habitacion.puerto.dao;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;

import java.util.List;

public interface DaoHabitacion {

    /**
     * Perite listar las habitaciones
     *
     * @return lista de habitaciones
     */
    List<DtoHabitacion> listar();

    /**
     * Permite buscar habitaciones por tipo
     *
     * @return lista de habitaciones
     */
    List<DtoHabitacion> buscarPorTipo(String tipo);

    /**
     * permite listar habitaciones por numero de camas
     * @return lista de habitaciones
     */
    List<DtoHabitacion> buscarPorNumeroCamas(int noCamas);

    /**
     * Permite listar habitaciones por piso
     * @return lista de habitaciones
     */
    List<DtoHabitacion> buscarPorPiso(String piso);

    /**
     * permite listar por estado
     * @return lista de habitaciones
     */
    List<DtoHabitacion> buscarPorEstado(String estado);

    /**
     * permite listar por numero de habitacion
     * @return una habitacion
     */
    DtoHabitacion buscarPorNumeroHabitacion(String numeroHabitacion);

    /**
     * permite traer el precio de la habitacion segun su id
     * @return
     * REVISAR PORQUE DEBERIA DEVOLVER UN DOUBLE NO UN DTO
     */
    Double precioHabitacion(Long idHabitacion);
}