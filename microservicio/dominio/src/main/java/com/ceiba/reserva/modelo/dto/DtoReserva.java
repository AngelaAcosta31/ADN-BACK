package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoReserva {

    private Long id;
    private Double valor;
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    private Long id_habitacion;
    private Long id_cliente;

    //private Double precioHabitacion;
}
