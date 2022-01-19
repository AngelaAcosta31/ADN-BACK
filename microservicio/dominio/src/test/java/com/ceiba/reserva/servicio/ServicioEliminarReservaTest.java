package com.ceiba.reserva.servicio;

import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarReservaTest {

    @Test
    @DisplayName("Deberia eliminar la reserva llamando al repositorio")
    void deberiaEliminarLaReservaLllamandoAlRepositorio(){
        //Arrange
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva);
        //act
        servicioEliminarReserva.ejecutar(1L);
        //assert
        Mockito.verify(repositorioReserva, Mockito.times(1)).eliminar(1L);

    }
}
