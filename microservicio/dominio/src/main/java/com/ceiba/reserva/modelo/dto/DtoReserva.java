package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoReserva {

    private Long id_reserva;
    private Double valor;
    private LocalDateTime fecha_entrada;
    private LocalDateTime fecha_salida;
    private Long id_habitacion;
    private Long id_cliente;
}
