package com.ceiba.habitacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoHabitacion {

    private Long id;
    private String numeroHabitacion;
    private String tipo;
    private Integer noCamas;
    private Integer noBannos;
    private String descripcion;
    private Double precio;
    private String piso;
    private String estado;
}
