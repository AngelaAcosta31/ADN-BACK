package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;

import java.time.LocalDate;
import java.util.Random;

public class ComandoClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellido;
    private String numero_identificacion;
    private String telefono;
    private String correo;
    private String sexo;
    private LocalDate fecha_nacimiento;
    private String direccion;

    public ComandoClienteTestDataBuilder() {
        this.nombre = "CAMILA";
        this.apellido = "PEREZ";
        this.numero_identificacion = "1258749631";
        this.telefono = "3108942571";
        this.correo = "CAMILAL@HOTMAIL.COM";
        this.sexo = "F";
        this.fecha_nacimiento = LocalDate.of(2001,05,16);
        this.direccion  = "CARRERA 85 # 47-69";

    }

    public ComandoClienteTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoClienteTestDataBuilder conNumeroIdentificacion(String numero_identificacion){
        this.numero_identificacion = numero_identificacion;
        return this;
    }

    public ComandoClienteTestDataBuilder conCorreo(String correo){
        this.correo =correo;
        return this;
    }

    public ComandoCliente build(){
        return new ComandoCliente(id,nombre,apellido,numero_identificacion,telefono,correo,sexo,fecha_nacimiento,direccion);
    }
}
