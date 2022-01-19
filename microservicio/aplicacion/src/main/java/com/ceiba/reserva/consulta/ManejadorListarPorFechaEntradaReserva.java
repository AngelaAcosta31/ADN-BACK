package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ManejadorListarPorFechaEntradaReserva {

    private final DaoReserva daoReserva;

    public ManejadorListarPorFechaEntradaReserva(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    public List<DtoReserva> ejecutar(LocalDate fechaEntrada){
        return this.daoReserva.buscarPorFechaEntrada(fechaEntrada);
    }
}
