package com.ceiba.habitacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.habitacion.servicio.testdatabuilder.HabitacionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarHabitacionTest {

    private final static String LA_HABITACION_NO_EXISTE_EN_EL_SISTEMA = "La habitación no existe en el sistema";

    @Test
    @DisplayName("Deberia validar la existencia previa de la habitacion")
    void deberiaValidarLaExistenciaPreviaDeLaHabitacion(){

        //Arrange
        Habitacion habitacion = new HabitacionTestDataBuilder().conIdHabitacion(1L).build();
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioHabitacion.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarHabitacion servicioActualizarHabitacion = new ServicioActualizarHabitacion(repositorioHabitacion);
        //act-assert
        BasePrueba.assertThrows(()->servicioActualizarHabitacion.ejecutar(habitacion), ExcepcionDuplicidad.class,LA_HABITACION_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio(){
        //Arrange
        Habitacion habitacion = new HabitacionTestDataBuilder().conIdHabitacion(1L).build();
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioHabitacion.existePorNumeroHabitacion(Mockito.anyString())).thenReturn(true);
        ServicioActualizarHabitacion servicioActualizarHabitacion = new ServicioActualizarHabitacion(repositorioHabitacion);
        //act
        servicioActualizarHabitacion.ejecutar(habitacion);
        //assert
        Mockito.verify(repositorioHabitacion, Mockito.times(1)).actualizar(habitacion);
    }
}