package com.ceiba.reserva.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaTest {

    private static final String SE_DEBE_INGRESAR_FECHA_ENTRADA = "Se debe ingresar la fecha de entrada";
    private static final String SE_DEBE_INGRESAR_UN_VALOR = "Se debe ingresar el valor a pagar";
    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_HABITACION = "Se debe ingresar el id de la habitación";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_CLIENTE = "Se debe ingresar el id del cliente";

    @Test
    @DisplayName("Deberia crear correctamente la reserva")
    void deberiaCrearCorrectamenteLaReserva(){

        //Arrange
        LocalDate fecha_entrada = LocalDate.of(2021,06,20);
        LocalDate fecha_salida = LocalDate.of(2021,06,30);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conIdCliente(1L).build();
        //assert
        assertEquals(1,reserva.getId());
        assertEquals(640000.0, reserva.getValor());
        assertEquals(fecha_entrada,reserva.getFechaEntrada());
        assertEquals(fecha_salida,reserva.getFechaSalida());
        assertEquals(1, reserva.getIdHabitacion());
        assertEquals(1,reserva.getIdCliente());


    }

    @Test
    void deberiaFallarSinFechaEntrada(){
        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            reservaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_FECHA_ENTRADA);
    }

    @Test
    void deberiaFallarSinIdHabitacion(){
        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdReserva(1L).conIdHabitacion(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            reservaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_ID_DE_LA_HABITACION);
    }

    @Test
    void deberiaFallarSinIdCliente(){
        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdReserva(1L).conIdCliente(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            reservaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_ID_DEL_CLIENTE);
    }

    @Test
    void debeCalcularElValorEnTemporadaAltaConEntradaElFinDeSemana(){
        LocalDate fecha_entrada = LocalDate.of(2021,06,20);
        LocalDate fecha_salida = LocalDate.of(2021,06,30);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(640000.0, reserva.getValor());
    }

    @Test
    void debeCalcularElValorEnTemporadaBajaConEntradaElFinDeSemana(){
        LocalDate fecha_entrada = LocalDate.of(2021,02,20);
        LocalDate fecha_salida = LocalDate.of(2021,02,27);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(308000.0, reserva.getValor());
    }

    @Test
    void debeCalcularElValorEnTemporadaAltaConEntradaEnLaSemana(){
        LocalDate fecha_entrada = LocalDate.of(2021,8,9);
        LocalDate fecha_salida = LocalDate.of(2021,8,12);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(168000.0, reserva.getValor());
    }

    @Test
    void debeCalcularElValorEnTemporadaBajaConEntradaEnLaSemana(){
        LocalDate fecha_entrada = LocalDate.of(2021,03,22);
        LocalDate fecha_salida = LocalDate.of(2021,03,28);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(216000.0, reserva.getValor());
    }

    @Test
    void debeCalcularElValorConEntradaEnTemporadaBajaDiaNormalYSalidaEnTemporadaAlta(){
        LocalDate fecha_entrada = LocalDate.of(2021,5,31);
        LocalDate fecha_salida = LocalDate.of(2021,6,12);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(432000.0, reserva.getValor());
    }

    @Test
    void debeCalcularElValorConEntradaEnTemporadaAltaDiaNormalYSalidaEnTemporadaBaja(){
        LocalDate fecha_entrada = LocalDate.of(2021,8,26);
        LocalDate fecha_salida = LocalDate.of(2021,9,8);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(728000.0, reserva.getValor());
    }

    @Test
    void debeCalcularElValorConEntradaEnTemporadaBajaFinDeSemanaYSalidaEnTemporadaAlta(){
        LocalDate fecha_entrada = LocalDate.of(2021,5,30);
        LocalDate fecha_salida = LocalDate.of(2021,6,12);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(572000.0, reserva.getValor());
    }

    @Test
    void debeCalcularElValorConEntradaEnTemporadaAltaFinDeSemanaYSalidaEnTemporadaBaja(){
        LocalDate fecha_entrada = LocalDate.of(2021,8,28);
        LocalDate fecha_salida = LocalDate.of(2021,9,8);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(704000.0, reserva.getValor());
    }

    @Test
    void debeCalcularElValorConEntradaEnTemporadaBajaViernesYSalidaEnTemporadaAlta(){
        LocalDate fecha_entrada = LocalDate.of(2021,11,26);
        LocalDate fecha_salida = LocalDate.of(2021,12,2);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(264000.0, reserva.getValor());
    }

    @Test
    void debeCalcularElValorConEntradaEnTemporadaBajaYSalidaEnTemporadaBaja(){
        LocalDate fecha_entrada = LocalDate.of(2021,3,26);
        LocalDate fecha_salida = LocalDate.of(2021,4,2);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(308000.0, reserva.getValor());
    }




}
