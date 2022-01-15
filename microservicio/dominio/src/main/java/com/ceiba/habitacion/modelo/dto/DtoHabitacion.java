package com.ceiba.habitacion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoHabitacion {

    private Long id_habitacion;
    private String numero_habitacion;
    private String tipo;
    private Integer no_camas;
    private Integer no_bannos;
    private String descripcion;
    private Double precio;
    private String piso;
    private String estado;
}
