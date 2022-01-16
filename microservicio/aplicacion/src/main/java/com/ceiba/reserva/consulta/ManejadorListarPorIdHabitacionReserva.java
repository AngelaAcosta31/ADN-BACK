package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPorIdHabitacionReserva {

    private final DaoReserva daoReserva;

    public ManejadorListarPorIdHabitacionReserva(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    public List<DtoReserva> ejecutar(Long idHabitacion){
        return this.daoReserva.buscarPorIdHabitacion(idHabitacion);
    }
}

