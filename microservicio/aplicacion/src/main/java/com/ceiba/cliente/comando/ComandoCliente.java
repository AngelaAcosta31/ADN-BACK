package com.ceiba.cliente.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCliente {

    private Long   id;
    private String nombre;
    private String apellido;
    private String numeroIdentificacion;
    private String telefono;
    private String correo;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String direccion;
}
