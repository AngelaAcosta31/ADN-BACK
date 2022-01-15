package com.ceiba.habitacion.servicio;

import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;

public class ServicioEliminarHabitacion {

    // inyeccion de dependencias
    private final RepositorioHabitacion repositorioHabitacion;

    public ServicioEliminarHabitacion(RepositorioHabitacion repositorioHabitacion) {
        this.repositorioHabitacion = repositorioHabitacion;
    }

    public void ejecutar(Long id){
        this.repositorioHabitacion.eliminar(id);
    }
}
