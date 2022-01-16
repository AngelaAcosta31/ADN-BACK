package com.ceiba.cliente.consulta;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarPorCorreoCliente {

    private final DaoCliente daoCliente;

    public ManejadorBuscarPorCorreoCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public DtoCliente ejecutar(String correo){
        return this.daoCliente.buscarPorCorreo(correo);
    }
}
