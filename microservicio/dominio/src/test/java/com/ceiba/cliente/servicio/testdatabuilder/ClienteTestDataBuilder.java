package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ClienteTestDataBuilder {

    private Long   id_cliente;
    private String nombre;
    private String apellido;
    private String numero_identificacion;
    private String telefono;
    private String correo;
    private String sexo;
    private LocalDateTime fecha_nacimiento;
    private String direccion;

    //CREO EL OBJETO

    public ClienteTestDataBuilder(){

        this.nombre = "ANGELA";
        this.apellido = "ACOSTA";
        this.numero_identificacion ="1005874280";
        this.telefono = "3104542773";
        this.correo = "angela@hotmail.com";
        this.sexo ="F";
        this.fecha_nacimiento = LocalDateTime.of(LocalDate.of(2000,07,31), LocalTime.of(11,00));
        this.direccion = "CALLE 30 # 1-160";
    }

    public ClienteTestDataBuilder conIdCliente(Long id_cliente){
        this.id_cliente = id_cliente;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public ClienteTestDataBuilder conApellido(String apellido){
        this.apellido = apellido;
        return this;
    }

    public ClienteTestDataBuilder conNumeroIdentificacion(String numero_identificacion){
        this.numero_identificacion = numero_identificacion;
        return this;
    }

    public ClienteTestDataBuilder conTelefono(String telefono){
        this.telefono = telefono;
        return this;
    }

    public ClienteTestDataBuilder conCorreo(String correo){
        this.correo = correo;
        return this;
    }

    public ClienteTestDataBuilder conSexo(String sexo){
        this.sexo = sexo;
        return this;
    }

    public ClienteTestDataBuilder conFechaNacimiento(LocalDateTime fecha_nacimiento){
        this.fecha_nacimiento = fecha_nacimiento;
        return this;
    }

    public ClienteTestDataBuilder conDireccion(String direccion){
        this.direccion = direccion;
        return this;
    }

    public Cliente build(){
        return new Cliente(id_cliente,nombre,apellido,numero_identificacion,telefono,correo,sexo,fecha_nacimiento,direccion);
    }
}
