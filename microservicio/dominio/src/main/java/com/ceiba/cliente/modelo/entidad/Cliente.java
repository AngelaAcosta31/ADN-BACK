package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Cliente {

    // VALIDACIONES

    private static final String  SE_DEBE_INGRESAR_UN_NOMBRE=" Se debe ingresar un nombre";
    private static final String  SE_DEBE_INGRESAR_UN_APELLIDO="Se debe ingresar un appellido";
    private static final String  SE_DEBE_INGRESAR_UN_NUMERO_IDENTIFICACION="Se debe ingresar un numero de identificación";
    private static final String  SE_DEBE_INGRESAR_UN_TELEFONO = "Se debe ingresar un telefono";
    private static final String  SE_DEBE_INGRESAR_UN_CORREO = "Se debe ingresar un correo";
    private static final String  SE_DEBE_INGRESAR_SEXO="Se debe ingresar el sexo";
    private static final String  SE_DEBE_INGRESAR_FECHA_NACIMIENTO="Se debe ingresar la fecha de nacimiento";
    private static final String  SE_DEBE_INGRESAR_UNA_DIRECCION = "Se debe ingresar una direccion";
    private static final String  SE_DEBE_INGRESAR_UNA_FECHA_NACIMIENTO_VALIDA = "Se debe ingresar una fecha de nacimiento valida no la actual";
    private static final String  SE_DEBE_INGRESAR_F_O_M = "Se debe ingresar solo F, M u O para el genero";

    private static final Integer ANNIO_ACTUAL = 2022;
    private static final LocalDate FECHA_ACTUAL = LocalDate.of(2021,01,19);
    private static final String FEMENINO = "F";
    private static final String MASCULINO = "M";
    private static final String OTRO = "O";

    private Long   id;
    private String nombre;
    private String apellido;
    private String numero_identificacion;
    private String telefono;
    private String correo;
    private String sexo;
    private LocalDate fecha_nacimiento;
    private String direccion;

    public Cliente(Long id, String nombre, String apellido, String numero_identificacion, String telefono, String correo, String sexo, LocalDate fecha_nacimiento, String direccion) {

        //Nos permite validar que si no se introduce un valor a cada atributo mande una excepcion
        validarObligatorio(nombre, SE_DEBE_INGRESAR_UN_NOMBRE);
        validarObligatorio(apellido, SE_DEBE_INGRESAR_UN_APELLIDO);
        validarObligatorio(numero_identificacion, SE_DEBE_INGRESAR_UN_NUMERO_IDENTIFICACION);
        validarObligatorio(telefono,SE_DEBE_INGRESAR_UN_TELEFONO);
        validarObligatorio(correo,SE_DEBE_INGRESAR_UN_CORREO);
        validarObligatorio(sexo, SE_DEBE_INGRESAR_SEXO);
        validarObligatorio(fecha_nacimiento, SE_DEBE_INGRESAR_FECHA_NACIMIENTO);
        validarObligatorio(direccion,SE_DEBE_INGRESAR_UNA_DIRECCION);
        validarMenor(FECHA_ACTUAL, fecha_nacimiento,SE_DEBE_INGRESAR_UNA_FECHA_NACIMIENTO_VALIDA);
        //validarSexo1(sexo,SE_DEBE_INGRESAR_F_O_M);




        this.id = id;
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
