package com.ceiba.habitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;

public class ServicioActualizarEstadoHabitacion {

    private static final String LA_HABITACION_NO_EXISTE_EN_EL_SISTEMA = "La habitación no existe en el sistema";

    private final RepositorioHabitacion repositorioHabitacion;

    public ServicioActualizarEstadoHabitacion(RepositorioHabitacion repositorioHabitacion) {
        this.repositorioHabitacion = repositorioHabitacion;
    }

    public void ejecutar(Long idHabitacion, String estado){
        validarExistenciaPrevia(idHabitacion);
        this.repositorioHabitacion.actualizarEstado(idHabitacion, estado);
    }

    private void  validarExistenciaPrevia(Long id){
        boolean existe = this.repositorioHabitacion.existePorId(id);
        if(!existe){
            throw new ExcepcionDuplicidad(LA_HABITACION_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

   
}
