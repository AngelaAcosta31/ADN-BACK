package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {

    private Long id_reserva;
    private Double valor;
    private LocalDateTime fecha_entrada;
    private LocalDateTime fecha_salida;
    private Long id_habitacion;
    private Long id_cliente;
}
