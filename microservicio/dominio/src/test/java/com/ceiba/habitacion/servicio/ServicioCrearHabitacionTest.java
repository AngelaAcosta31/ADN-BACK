package com.ceiba.habitacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.habitacion.servicio.testdatabuilder.HabitacionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearHabitacionTest {

    private final static String LA_HABITACION_YA_EXISTE_EN_EL_SISTEMA = "La habitacion ya existe en el sistema";

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide la existencia de la habitacion")
    void deberiaLanzarUnaExcepcionCuandoSeValidaLaExistenciaDeLaHabitacion(){
        //Arrange
        Habitacion habitacion = new HabitacionTestDataBuilder().conIdHabitacion(1L).build();
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioHabitacion.existePorNumeroHabitacion(Mockito.anyString())).thenReturn(true);
        ServicioCrearHabitacion servicioCrearHabitacion = new ServicioCrearHabitacion(repositorioHabitacion);
        //act-assert
        BasePrueba.assertThrows(()->servicioCrearHabitacion.ejecutar(habitacion), ExcepcionDuplicidad.class,LA_HABITACION_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia crear la habitacion de manera correcta")
    void deberiaCrearLaHabitacionDeManeraCorrecta(){
        //Arrange
        Habitacion habitacion = new HabitacionTestDataBuilder().conIdHabitacion(1L).build();
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioHabitacion.existePorNumeroHabitacion(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioHabitacion.crear(habitacion)).thenReturn(10L);
        ServicioCrearHabitacion servicioCrearHabitacion = new ServicioCrearHabitacion(repositorioHabitacion);
        //act
        Long id = servicioCrearHabitacion.ejecutar(habitacion);
        //Assert
        assertEquals(10L,id);
        Mockito.verify(repositorioHabitacion,Mockito.times(1)).crear(habitacion);
    }
}
