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
        assertEquals(64000.0, reserva.getValor());
        assertEquals(fecha_entrada,reserva.getFecha_entrada());
        assertEquals(fecha_salida,reserva.getFecha_salida());
        assertEquals(1, reserva.getId_habitacion());
        assertEquals(1,reserva.getId_cliente());


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
    void deberiaFallarSinValor(){
        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdReserva(1L).conValor(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            reservaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_VALOR);
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

    //funciona pero se debe de corregir NO ESTA COMPLETO
    @Test
    void debeCalcularElValorEnTemporadaAlta(){
        LocalDate fecha_entrada = LocalDate.of(2021,06,20);
        LocalDate fecha_salida = LocalDate.of(2021,06,30);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(64000.0, reserva.getValor());
    }

    //funciona pero se debe de corregir NO ESTA COMPLETO
    @Test
    void debeCalcularElValorEnTemporadaBaja(){
        LocalDate fecha_entrada = LocalDate.of(2021,06,20);
        LocalDate fecha_salida = LocalDate.of(2021,06,30);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(64000.0, reserva.getValor());
    }

    //funciona pero se debe de corregir NO ESTA COMPLETO
    @Test
    void debeCalcularElValorEnFinDeSemana(){
        LocalDate fecha_entrada = LocalDate.of(2021,06,20);
        LocalDate fecha_salida = LocalDate.of(2021,06,30);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdReserva(1L).conFechaEntrada(fecha_entrada).conFechaSalida(fecha_salida).build();

        assertEquals(64000.0, reserva.getValor());
    }



}
