package com.ceiba.cliente.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    private static final String  SE_DEBE_INGRESAR_UN_NOMBRE=" Se debe ingresar un nombre";
    private static final String  SE_DEBE_INGRESAR_UN_APELLIDO="Se debe ingresar un appellido";
    private static final String  SE_DEBE_INGRESAR_UN_NUMERO_IDENTIFICACION="Se debe ingresar un numero de identificación";
    private static final String  SE_DEBE_INGRESAR_UN_TELEFONO = "Se debe ingresar un telefono";
    private static final String  SE_DEBE_INGRESAR_UN_CORREO = "Se debe ingresar un correo";
    private static final String  SE_DEBE_INGRESAR_SEXO="Se debe ingresar el sexo";
    private static final String  SE_DEBE_INGRESAR_FECHA_NACIMIENTO="Se debe ingresar la fecha de nacimiento";
    private static final String  SE_DEBE_INGRESAR_UNA_DIRECCION = "Se debe ingresar una direccion";
    private static final String  SE_DEBE_INGRESAR_UNA_FECHA_NACIMIENTO_VALIDA = "Se debe ingresar una fecha de nacimiento valida no la actual";
    private static final String  SE_DEBE_INGRESAR_F_O_M = "Se debe ingresar solo F, M u O para el genero";

    @Test
    @DisplayName("Deberia crear correctamente el cliente")
    void deberiaCrearCorrectamenteElCliente(){
        //Arrange
        LocalDate fecha_nacimiento = LocalDate.of(2000,07,31);
        //Act
        Cliente cliente = new ClienteTestDataBuilder().conIdCliente(1L).conNumeroIdentificacion("1005874281").build();
        //ASSERT
        assertEquals(1, cliente.getId());
        assertEquals("PAULA", cliente.getNombre());
        assertEquals("ACOSTA", cliente.getApellido());
        assertEquals("1005874281",cliente.getNumero_identificacion());
        assertEquals("3104542756",cliente.getTelefono());
        assertEquals("PAULITA@HOTMAIL.COM",cliente.getCorreo());
        assertEquals("F",cliente.getSexo());
        assertEquals(fecha_nacimiento, cliente.getFecha_nacimiento());
        assertEquals("CALLE 30 # 1-160", cliente.getDireccion());
    }

    @Test
    void deberiaFallarSinNombre(){
        // Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre(null).conIdCliente(1L);
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_NOMBRE);

    }

    @Test
    void deberiaFallarSinApellido(){
        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conIdCliente(1L).conApellido(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_APELLIDO);
    }

    @Test
    void deberiaFallarSinNumeroIdentificacion(){
        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conIdCliente(1L).conNumeroIdentificacion(null);
        // act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_NUMERO_IDENTIFICACION);
    }

    @Test
    void deberiaFallarSinTelefono(){
        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conIdCliente(1L).conTelefono(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_TELEFONO);
    }

    @Test
    void deberiaFallarSinCorreo(){
        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conIdCliente(1L).conCorreo(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_CORREO);
    }

    @Test
    void deberiaFallarSinSexo(){
        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conIdCliente(1L).conSexo(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_SEXO);
    }

    @Test
    void deberiaFallarSinFechaNacimiento(){
        // Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conIdCliente(1L).conFechaNacimiento(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_FECHA_NACIMIENTO);
    }

    @Test
    void deberiaFallarSinDireccion(){
        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conIdCliente(1l).conDireccion(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UNA_DIRECCION);
    }

    @Test
    @DisplayName("Deberia fallar si la fecha de nacimiento es en el año actual")
    void deberiaFallarSiFechaNacimientoEsMenorAFechaActual(){
        //Arrange
        LocalDate fechaInvalida = LocalDate.now();
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conFechaNacimiento(fechaInvalida);
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_UNA_FECHA_NACIMIENTO_VALIDA);
    }

 /*   @Test
    @DisplayName("deberia fallar si el sexo no es F, M u O")
    void deberiaFallarSiElSexoEsInvalido(){
        String sexoInvalido = "t";
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conSexo(sexoInvalido);
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_F_O_M);
    }*/




}
