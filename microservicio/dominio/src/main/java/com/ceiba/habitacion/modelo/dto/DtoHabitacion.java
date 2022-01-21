package com.ceiba.habitacion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DtoHabitacion {

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
