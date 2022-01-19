package com.ceiba.habitacion.servicio.testdatabuilder;


import com.ceiba.habitacion.comando.ComandoHabitacion;

public class ComandoHabitacionTestDataBuilder {

    private Long id;
    private String numero_habitacion;
    private String tipo;
    private Integer no_camas;
    private Integer no_bannos;
    private String descripcion;
    private Double precio;
    private String piso;
    private String estado;

    public ComandoHabitacionTestDataBuilder(){
        this.numero_habitacion = "303";
        this.tipo = "TRIPLE";
        this.no_camas = 2;
        this.no_bannos = 1;
        this.descripcion = "HABITACION CON UNA CAMA DOBLE Y UNA CAMA SENCILLA";
        this.precio = 500000.00;
        this.piso = "3";
        this.estado = "D";
    }

    public ComandoHabitacionTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoHabitacionTestDataBuilder conNumeroHabitacion(String numero_habitacion){
        this.numero_habitacion = numero_habitacion;
        return this;
    }

    public ComandoHabitacionTestDataBuilder conNumeroCamas(Integer numeroCamas){
        this.no_camas = numeroCamas;
        return this;
    }

    public ComandoHabitacionTestDataBuilder conNumeroBannos(Integer numeroBannos){
        this.no_bannos = numeroBannos;
        return this;
    }

    public ComandoHabitacionTestDataBuilder conPrecio(Double precio){
        this.precio = precio;
        return this;
    }

    public ComandoHabitacionTestDataBuilder conPiso(String piso){
        this.piso = piso;
        return this;
    }

    public ComandoHabitacionTestDataBuilder conEstado(String estado){
        this.estado = estado;
        return this;
    }

    public ComandoHabitacion build(){
        return new ComandoHabitacion(id,numero_habitacion,tipo,no_camas,no_bannos,descripcion,precio,piso,estado);
    }

}
