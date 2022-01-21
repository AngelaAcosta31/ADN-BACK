package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {

    /**
     * Permite crear un cliente
     * @param cliente
     * @return el id generado
     */
    Long crear(Cliente cliente);

    /**
     * Permite actualizar un cliente
     * @param cliente
     */
    void actualizar(Cliente cliente);

    /**
     * permite eliminar un cliente
     * @param id
     */
    void eliminar (Long id);

    /**
     * para validar si existe un cliente con ese numero de identificacion
     * @param numeroIdentificacion
     * @return existe o no existe
     */
    boolean existePorNumeroIdentificacion(String numeroIdentificacion);
}
