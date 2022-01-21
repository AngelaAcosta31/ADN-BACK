package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCliente {

    private static final String EL_CLIENTE_NO_EXISTE = "El cliente no existe en el sistema";

    // inyeccion de dependencias
    private final RepositorioCliente repositorioCliente;

    // constructor
    public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Cliente cliente){
        validarExistenciaPrevia(cliente);
        this.repositorioCliente.actualizar(cliente);
    }

    private void validarExistenciaPrevia(Cliente cliente){
        boolean existe = this.repositorioCliente.existePorNumeroIdentificacion(cliente.getNumeroIdentificacion());
        if(!existe){
            throw new ExcepcionDuplicidad(EL_CLIENTE_NO_EXISTE);
        }
    }
}
