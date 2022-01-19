package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarReservaTest {

    private final static String LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA="La reserva no existe en el sistema";

    @Test
    @DisplayName("Deberia validar la existencia previa de la reserva")
    void deberiaValidarLaExistenciaPreviaDeLaReserva(){
        //Arrange
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva);
        //act-assert
        BasePrueba.assertThrows(()->servicioActualizarReserva.ejecutar(reserva), ExcepcionDuplicidad.class, LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio(){
        //Arrange
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva);
        //Act
        servicioActualizarReserva.ejecutar(reserva);
        //assert
        Mockito.verify(repositorioReserva, Mockito.times(1)).actualizar(reserva);
    }
}
