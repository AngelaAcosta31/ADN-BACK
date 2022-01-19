package com.ceiba.cliente.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarClienteTest {

    @Test
    @DisplayName("Deberia eliminar el cliente llamado en el repositorio")
    void deberiaEliminarElClienteLlamadoAlRepositorio(){
        //Arrange
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        ServicioEliminarCliente servicioEliminarCliente = new ServicioEliminarCliente(repositorioCliente);
        //ACT
        servicioEliminarCliente.ejecutar(1L);
        //assert
        Mockito.verify(repositorioCliente, Mockito.times(1)).eliminar(1L);
    }



}
