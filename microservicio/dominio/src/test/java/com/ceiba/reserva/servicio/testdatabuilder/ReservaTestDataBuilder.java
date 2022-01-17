package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservaTestDataBuilder {

    private Long id_reserva;
    private Double valor;
    private LocalDateTime fecha_entrada;
    private LocalDateTime fecha_salida;
    private Long id_habitacion;
    private Long id_cliente;

    public ReservaTestDataBuilder(){

        this.valor = 40000.00;
        this.fecha_entrada = LocalDateTime.of(LocalDate.of(2021,06,20), LocalTime.of(11,23));
        this.fecha_salida = LocalDateTime.of(LocalDate.of(2021,06,30), LocalTime.of(11,23));
        this.id_habitacion = 1L;
        this.id_cliente = 1L;

    }

    public ReservaTestDataBuilder conIdReserva(Long id_reserva){
        this.id_reserva = id_reserva;
        return this;
    }

    public ReservaTestDataBuilder conValor(Double valor){
        this.valor = valor;
        return this;
    }

    public ReservaTestDataBuilder conFechaEntrada(LocalDateTime fecha_entrada){
        this.fecha_entrada = fecha_entrada;
        return this;
    }

    public ReservaTestDataBuilder conFechaSalida(LocalDateTime fecha_salida){
        this.fecha_salida = fecha_salida;
        return this;
    }
    public ReservaTestDataBuilder conIdHabitacion(Long id_habitacion){
        this.id_habitacion = id_habitacion;
        return this;
    }

    public ReservaTestDataBuilder conIdCliente(Long id_cliente){
        this.id_cliente = id_cliente;
        return this;
    }

    public Reserva build(){
        return new Reserva(id_reserva,valor,fecha_entrada,fecha_salida,id_habitacion,id_cliente);
    }
}
