package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCliente {

    private Long id;
    private String nombre;
    private String apellido;
    private String numeroIdentificacion;
    private String telefono;
    private String correo;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String direccion;
}
