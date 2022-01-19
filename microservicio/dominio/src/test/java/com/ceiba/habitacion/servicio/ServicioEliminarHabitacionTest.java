package com.ceiba.habitacion.servicio;

import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarHabitacionTest {

    @Test
    @DisplayName("Deberia eliminar la habitacion llamado en el repositorio")
    void deberiaEliminarLaHabitacionLllamadoAlRepositorio(){
        //Arrange
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        ServicioEliminarHabitacion servicioEliminarHabitacion = new ServicioEliminarHabitacion(repositorioHabitacion);
        //ACT
        servicioEliminarHabitacion.ejecutar(1L);
        //Assert
        Mockito.verify(repositorioHabitacion, Mockito.times(1)).eliminar(1L);
    }
}
