package com.ceiba.habitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;

public class ServicioCrearHabitacion {

    private static final String LA_HABITACION_YA_EXISTE_EN_EL_SISTEMA = "La habitacion ya existe en el sistema";

    // inyeccion de dependencias
    private final RepositorioHabitacion repositorioHabitacion;


    public ServicioCrearHabitacion(RepositorioHabitacion repositorioHabitacion) {
        this.repositorioHabitacion = repositorioHabitacion;
    }

    public Long ejecutar(Habitacion habitacion){
        validarExistenciaPrevia(habitacion);
        return this.repositorioHabitacion.crear(habitacion);
    }

    private void validarExistenciaPrevia(Habitacion habitacion){
        boolean existe = this.repositorioHabitacion.existePorNumeroHabitacion(habitacion.getNumero_habitacion());
        if(existe){
            throw new ExcepcionDuplicidad(LA_HABITACION_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
