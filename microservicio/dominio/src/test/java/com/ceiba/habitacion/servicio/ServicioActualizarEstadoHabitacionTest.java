package com.ceiba.habitacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.habitacion.servicio.testdatabuilder.HabitacionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarEstadoHabitacionTest {

    private final static  String LA_HABITACION_NO_EXISTE_EN_EL_SISTEMA = "La habitación no existe en el sistema";

    @Test
    @DisplayName("Deberia validar la existencia de la habitacion")
    void deberiaValidarLaExistenciaPreviaDeLaHabitacion(){

        Habitacion habitacion = new HabitacionTestDataBuilder().conIdHabitacion(1L).build();
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioHabitacion.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarEstadoHabitacion servicioActualizarEstadoHabitacion = new ServicioActualizarEstadoHabitacion(repositorioHabitacion);

        BasePrueba.assertThrows(() -> servicioActualizarEstadoHabitacion.ejecutar(habitacion.getId(), habitacion.getEstado()), ExcepcionDuplicidad.class, LA_HABITACION_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarEstadoCorrectamenteEnElRepositorio(){
        Habitacion habitacion = new HabitacionTestDataBuilder().conIdHabitacion(1L).build();
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioHabitacion.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarEstadoHabitacion servicioActualizarEstadoHabitacion = new ServicioActualizarEstadoHabitacion(repositorioHabitacion);

        servicioActualizarEstadoHabitacion.ejecutar(habitacion.getId(), habitacion.getEstado());
        Mockito.verify(repositorioHabitacion, Mockito.times(1)).actualizarEstado(habitacion.getId(), habitacion.getEstado());
    }
}
