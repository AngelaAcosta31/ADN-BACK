package com.ceiba.cliente.consulta;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarPorNumeroIdentificacionCliente {

    private final DaoCliente daoCliente;

    public ManejadorBuscarPorNumeroIdentificacionCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public DtoCliente ejecutar(String numeroIdentificacion){
        return this.daoCliente.buscarPorNumeroIdentificacion(numeroIdentificacion);
    }
}
