package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearClienteTest {

    private final static String EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El cliente ya existe en el sistema";

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide la existencia del cliente")
    void deberiaLanzarUnaExcepcionCuandoSeValidaLaExistenciaDelCliente(){
        //Arrange
        Cliente cliente = new ClienteTestDataBuilder().conIdCliente(1L).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existePorNumeroIdentificacion(Mockito.anyString())).thenReturn(true);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        //act-assert
        BasePrueba.assertThrows(()->servicioCrearCliente.ejecutar(cliente),ExcepcionDuplicidad.class, EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia crear el cliente de manera correcta")
    void deberiaCrearElClienteDeManeraCorrecta(){
        //Arrange
        Cliente cliente = new ClienteTestDataBuilder().conIdCliente(1L).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existePorNumeroIdentificacion(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioCliente.crear(cliente)).thenReturn(10L);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        //ACT
        Long id = servicioCrearCliente.ejecutar(cliente);
        //Assert
        assertEquals(10L,id);
        Mockito.verify(repositorioCliente, Mockito.times(1)).crear(cliente);

    }



}
