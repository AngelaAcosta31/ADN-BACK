package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCliente {

    private Long   id_cliente;
    private String nombre;
    private String apellido;
    private String numero_identificacion;
    private String telefono;
    private String correo;
    private String sexo;
    private LocalDateTime fecha_nacimiento;
    private String direccion;
}
