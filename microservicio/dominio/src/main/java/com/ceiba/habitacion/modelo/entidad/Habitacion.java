package com.ceiba.habitacion.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Habitacion {

    // validaciones

    private static final String SE_DEBE_INGRESAR_NUMERO_HABITACION="Se debe ingresar numero de habitación";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_HABITACION = "Se debe ingresar el tipo de habitación";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_CAMAS = "Se debe ingresar el numero de camas";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_BANIOS = "Se debe ingresar el numero de baños";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar una descripción de la habitación";
    private static final String SE_DEBE_INGRESAR_UN_ESTADO = "Se debe ingresar un estado";


    private Long id;
    private String numeroHabitacion;
    private String tipo;
    private Integer noCamas;
    private Integer noBannos;
    private String descripcion;
    private Double precio;
    private String piso;
    private String estado;


    public Habitacion(Long id, String numeroHabitacion, String tipo, Integer noCamas, Integer noBannos, String descripcion, Double precio, String piso, String estado) {

        //Nos permite validar que si no se introduce un valor a cada atributo mande el mensaje
        validarObligatorio(numeroHabitacion, SE_DEBE_INGRESAR_NUMERO_HABITACION);
        validarObligatorio(tipo, SE_DEBE_INGRESAR_EL_TIPO_DE_HABITACION);
        validarObligatorio(noCamas, SE_DEBE_INGRESAR_EL_NUMERO_DE_CAMAS);
        validarObligatorio(noBannos, SE_DEBE_INGRESAR_EL_NUMERO_DE_BANIOS);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
        validarObligatorio(estado, SE_DEBE_INGRESAR_UN_ESTADO);

        this.id = id;
        this.numeroHabitacion = numeroHabitacion;
        this.tipo = tipo;
        this.noCamas = noCamas;
        this.noBannos = noBannos;
        this.descripcion = descripcion;
        this.precio = precio;
        this.piso = piso;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }


}
