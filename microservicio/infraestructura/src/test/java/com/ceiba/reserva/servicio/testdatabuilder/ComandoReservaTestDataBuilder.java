package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;

import java.time.LocalDate;

public class ComandoReservaTestDataBuilder {

    private Long id;
    private Double valor;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Long idHabitacion;
    private Long idCliente;

    public ComandoReservaTestDataBuilder(){

        this.valor = 20000.00;
        this.fechaEntrada = LocalDate.of(2021,10,15);
        this.fechaSalida = LocalDate.of(2021,10,30);
        this.idHabitacion = 1L;
        this.idCliente = 1L;
    }

    public ComandoReservaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public ComandoReservaTestDataBuilder conFechaEntrada(LocalDate fechaEntrada){
        this.fechaEntrada = fechaEntrada;
        return this;
    }
    public ComandoReservaTestDataBuilder conFechaSalida(LocalDate fechaSalida){
        this.fechaSalida = fechaSalida;
        return this;
    }
    public ComandoReservaTestDataBuilder conIdHabitacion(Long idHabitacion){
        this.idHabitacion = idHabitacion;
        return this;
    }

    public ComandoReservaTestDataBuilder conIdCliente(Long idCliente){
        this.idCliente = idCliente;
        return this;
    }

    public ComandoReserva build(){
        return new ComandoReserva(id,valor,fechaEntrada,fechaSalida,idHabitacion,idCliente);
    }



}
