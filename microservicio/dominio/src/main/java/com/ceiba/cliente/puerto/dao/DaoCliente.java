package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import java.util.List;

public interface DaoCliente {

    /**
     * Permite listar los clientes
     * @return lista de clientes
     */

    List<DtoCliente> listar();
    /**
     * Permite buscar al cliente por numero_identificacion
     * @return un cliente
     */

    DtoCliente buscarPorNumeroIdentificacion(String numeroIdentificacion);

    /**
     * Permite buscar al cliente por correo
     * @return un cliente
     */
    DtoCliente buscarPorCorreo(String correo);

}
