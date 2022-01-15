package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {

    // VALIDACIONES

    private static final String  SE_DEBE_INGRESAR_UN_NOMBRE=" Se debe ingresar un nombre";
    private static final String  SE_DEBE_INGRESAR_UN_APELLIDO="Se debe ingresar un appellido";
    private static final String  SE_DEBE_INGRESAR_UN_NUMERO_IDENTIFICACION="Se debe ingresar un numero de identificación";
    private static final String  SE_DEBE_INGRESAR_SEXO="Se debe ingresar el sexo";
    private static final String  SE_DEBE_INGRESAR_FECHA_NACIMIENTO="Se debe ingresar la fecha de nacimiento";


    private Long   id_cliente;
    private String nombre;
    private String apellido;
    private String numero_identificacion;
    private String telefono;
    private String correo;
    private String sexo;
    private LocalDateTime fecha_nacimiento;
    private String direccion;

    public Cliente(Long id_cliente, String nombre, String apellido, String numero_identificacion, String telefono, String correo, String sexo, LocalDateTime fecha_nacimiento, String direccion) {

        //Nos permite validar que si no se introduce un valor a cada atributo mande el mensaje
        validarObligatorio(nombre, SE_DEBE_INGRESAR_UN_NOMBRE);
        validarObligatorio(apellido, SE_DEBE_INGRESAR_UN_APELLIDO);
        validarObligatorio(numero_identificacion, SE_DEBE_INGRESAR_UN_NUMERO_IDENTIFICACION);
        validarObligatorio(sexo, SE_DEBE_INGRESAR_SEXO);
        validarObligatorio(fecha_nacimiento, SE_DEBE_INGRESAR_FECHA_NACIMIENTO);

        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero_identificacion = numero_identificacion;
        this.telefono = telefono;
        this.correo = correo;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
    }
}
