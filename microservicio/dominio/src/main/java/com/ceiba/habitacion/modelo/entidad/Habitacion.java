package com.ceiba.habitacion.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Habitacion {

    // validaciones

    private static final String SE_DEBE_INGRESAR_NUMERO_HABITACION="Se debe ingresar numero de habitación";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_HABITACION = "Se debe ingresar el tipo de habitación";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_CAMAS = "Se debe ingresar el numero de camas";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_BANIOS = "Se debe ingresar el numero de baños";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar una descripción de la habitación";
    private static final String SE_DEBE_INGRESAR_UN_ESTADO = "Se debe ingresar un estado";

    private Long id_habitacion;
    private String numero_habitacion;
    private String tipo;
    private Integer no_camas;
    private Integer no_bannos;
    private String descripcion;
    private Double precio;
    private String piso;
    private String estado;

    public Habitacion(Long id_habitacion, String numero_habitacion, String tipo, Integer no_camas, Integer no_bannos, String descripcion, Double precio, String piso, String estado) {

        //Nos permite validar que si no se introduce un valor a cada atributo mande el mensaje
        validarObligatorio(numero_habitacion, SE_DEBE_INGRESAR_NUMERO_HABITACION);
        validarObligatorio(tipo, SE_DEBE_INGRESAR_EL_TIPO_DE_HABITACION);
        validarObligatorio(no_camas, SE_DEBE_INGRESAR_EL_NUMERO_DE_CAMAS);
        validarObligatorio(no_bannos, SE_DEBE_INGRESAR_EL_NUMERO_DE_BANIOS);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
        validarObligatorio(estado, SE_DEBE_INGRESAR_UN_ESTADO);

        this.id_habitacion = id_habitacion;
        this.numero_habitacion = numero_habitacion;
        this.tipo = tipo;
        this.no_camas = no_camas;
        this.no_bannos = no_bannos;
        this.descripcion = descripcion;
        this.precio = precio;
        this.piso = piso;
        this.estado = estado;
    }
}
