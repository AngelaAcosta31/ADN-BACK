package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.habitacion.puerto.dao.DaoHabitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.habitacion.servicio.ServicioCrearHabitacion;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearReservaTest {

    private final static String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide la existencia de la reserva")
    void deberiaLanzarUnaExcepcionCuandoSeValidaLaExistenciaDeLaReserva(){
        //Arrange
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioReserva.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioHabitacion.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioReserva.existePorIdHabitacion(Mockito.anyLong())).thenReturn(false);
        DaoHabitacion daoHabitacion = Mockito.mock(DaoHabitacion.class);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioHabitacion, daoHabitacion);
        //act-assert
        BasePrueba.assertThrows(()->servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class, LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia crear el cliente de manera correcta")
    void deberiaCrearLaReservaDeManeraCorrecta(){
        //Arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioReserva.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioHabitacion.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioReserva.existePorIdHabitacion(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(10L);
        DaoHabitacion daoHabitacion = Mockito.mock(DaoHabitacion.class);;
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioHabitacion, daoHabitacion);
        //ACT
        Long id = servicioCrearReserva.ejecutar(reserva);
        //Assert
        assertEquals(10L,id);
        Mockito.verify(repositorioReserva, Mockito.times(1)).crear(reserva);

    }

}
