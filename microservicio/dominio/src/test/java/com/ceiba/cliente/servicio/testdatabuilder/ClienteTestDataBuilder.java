package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;

import java.time.LocalDate;

public class ClienteTestDataBuilder {

    private Long   id;
    private String nombre;
    private String apellido;
    private String numero_identificacion;
    private String telefono;
    private String correo;
    private String sexo;
    private LocalDate fecha_nacimiento;
    private String direccion;

    //CREO EL OBJETO

    public ClienteTestDataBuilder(){

        this.nombre = "PAULA";
        this.apellido = "ACOSTA";
        this.numero_identificacion ="1005874281";
        this.telefono = "3104542756";
        this.correo = "PAULITA@HOTMAIL.COM";
        this.sexo ="F";
        this.fecha_nacimiento = LocalDate.of(2000,7,31);
        this.direccion = "CALLE 30 # 1-160";
    }

    // metodos que nos permitiran cambiar los valores por defecto
    public ClienteTestDataBuilder conIdCliente(Long id){
        this.id = id;
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

    public ClienteTestDataBuilder conFechaNacimiento(LocalDate fecha_nacimiento){
        this.fecha_nacimiento = fecha_nacimiento;
        return this;
    }

    public ClienteTestDataBuilder conDireccion(String direccion){
        this.direccion = direccion;
        return this;
    }

    //construye el objeto final y nos devuelve una instancia del mismo
    public Cliente build(){
        return new Cliente(id,nombre,apellido,numero_identificacion,telefono,correo,sexo,fecha_nacimiento,direccion);
    }
}
