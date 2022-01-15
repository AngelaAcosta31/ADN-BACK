package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCliente {

    private static final String EL_CLIENTE_YA_EXISTE = "El cliente ya existe en el sistema";

    //Inyeccion de dependencias

    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long ejecutar(Cliente cliente){
        validarExistenciaPrevia(cliente);
        return this.repositorioCliente.crear(cliente);
    }
    private void validarExistenciaPrevia(Cliente cliente){
        boolean existe = this.repositorioCliente.existePorNumeroIdentificacion(cliente.getNumero_identificacion());
        if(existe){
            throw new ExcepcionDuplicidad(EL_CLIENTE_YA_EXISTE);
        }
    }
}
