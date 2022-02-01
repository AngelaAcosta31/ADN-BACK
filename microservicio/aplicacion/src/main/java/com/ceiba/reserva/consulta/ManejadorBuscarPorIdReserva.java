package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarPorIdReserva {

    private final DaoReserva daoReserva;

    public ManejadorBuscarPorIdReserva(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    public DtoReserva ejecutar(Long idReserva){
        return this.daoReserva.buscarPorIdReserva(idReserva);
    }
}
