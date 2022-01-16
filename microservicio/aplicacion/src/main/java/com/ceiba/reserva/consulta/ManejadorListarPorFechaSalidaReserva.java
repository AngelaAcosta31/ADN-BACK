package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ManejadorListarPorFechaSalidaReserva {

    private final DaoReserva daoReserva;

    public ManejadorListarPorFechaSalidaReserva(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    public List<DtoReserva> ejecutar(LocalDateTime fechaSalida){
        return this.daoReserva.buscarPorFechaSalida(fechaSalida);
    }
}
