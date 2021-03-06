package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {

    private Long id;
    private Double valor;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Long idHabitacion;
    private Long idCliente;
}
