package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;

import java.time.LocalDate;

public class ComandoReservaTestDataBuilder {

    private Long id;
    private Double valor;
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    private Long id_habitacion;
    private Long id_cliente;

    public ComandoReservaTestDataBuilder(){

        this.valor = 20000.00;
        this.fecha_entrada = LocalDate.of(2021,10,15);
        this.fecha_salida = LocalDate.of(2021,10,30);
        this.id_habitacion = 1L;
        this.id_cliente = 1L;
    }

    public ComandoReservaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public ComandoReservaTestDataBuilder conFechaEntrada(LocalDate fecha_entrada){
        this.fecha_entrada = fecha_entrada;
        return this;
    }
    public ComandoReservaTestDataBuilder conFechaSalida(LocalDate fecha_salida){
        this.fecha_salida = fecha_salida;
        return this;
    }
    public ComandoReservaTestDataBuilder conIdHabitacion(Long id_habitacion){
        this.id_habitacion = id_habitacion;
        return this;
    }

    public ComandoReservaTestDataBuilder conIdCliente(Long id_cliente){
        this.id_cliente = id_cliente;
        return this;
    }

    public ComandoReserva build(){
        return new ComandoReserva(id,valor,fecha_entrada,fecha_salida,id_habitacion,id_cliente);
    }



}
