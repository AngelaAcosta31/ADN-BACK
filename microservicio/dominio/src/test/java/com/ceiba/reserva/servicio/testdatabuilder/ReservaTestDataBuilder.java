package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDate;

public class ReservaTestDataBuilder {

    private Long id;
    private Double valor;
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    private Long id_habitacion;
    private Long id_cliente;

    public ReservaTestDataBuilder(){

        this.valor = 40000.00;
        this.fecha_entrada = LocalDate.of(2021,6,20);
        this.fecha_salida = LocalDate.of(2021,6,30);
        this.id_habitacion = 1L;
        this.id_cliente = 1L;

    }

    public ReservaTestDataBuilder conIdReserva(Long id_reserva){
        this.id = id_reserva;
        return this;
    }

    public ReservaTestDataBuilder conFechaEntrada(LocalDate fecha_entrada){
        this.fecha_entrada = fecha_entrada;
        return this;
    }

    public ReservaTestDataBuilder conFechaSalida(LocalDate fecha_salida){
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
        return new Reserva(id,valor,fecha_entrada,fecha_salida,id_habitacion,id_cliente);
    }
}
