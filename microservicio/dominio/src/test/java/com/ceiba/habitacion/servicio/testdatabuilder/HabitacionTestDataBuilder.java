package com.ceiba.habitacion.servicio.testdatabuilder;

import com.ceiba.habitacion.modelo.entidad.Habitacion;

public class HabitacionTestDataBuilder {

    private Long id;
    private String numero_habitacion;
    private String tipo;
    private Integer no_camas;
    private Integer no_bannos;
    private String descripcion;
    private Double precio;
    private String piso;
    private String estado;

    public HabitacionTestDataBuilder(){

        this.numero_habitacion = "120";
        this.tipo = "SENCILLA";
        this.no_camas = 1;
        this.no_bannos = 1;
        this.descripcion = "HABITACION CON CAMA SENCILLA, TV, NEVERA Y BAÑO";
        this.precio = 20000.00;
        this.piso = "1";
        this.estado= "D";
    }

    public HabitacionTestDataBuilder conIdHabitacion(Long id){
        this.id = id;
        return this;
    }

    public HabitacionTestDataBuilder conNumeroHabitacion(String numero_habitacion){
        this.numero_habitacion = numero_habitacion;
        return this;
    }

    public HabitacionTestDataBuilder conTipo(String tipo){
        this.tipo = tipo;
        return this;
    }

    public HabitacionTestDataBuilder conNumeroCamas(Integer no_camas){
        this.no_camas = no_camas;
        return this;
    }

    public HabitacionTestDataBuilder conNumeroBannios(Integer no_bannos){
        this.no_bannos = no_bannos;
        return this;
    }

    public HabitacionTestDataBuilder conDescripcion(String descripcion){
        this.descripcion = descripcion;
        return this;
    }

    public HabitacionTestDataBuilder conPrecio(Double precio){
        this.precio = precio;
        return this;
    }
    public HabitacionTestDataBuilder conPiso(String piso){
        this.piso = piso;
        return this;
    }

    public HabitacionTestDataBuilder conEstado(String estado){
        this.estado = estado;
        return this;
    }

    public Habitacion build(){
        return new Habitacion(id,numero_habitacion,tipo,no_camas,no_bannos,descripcion,precio,piso,estado);
    }
}
