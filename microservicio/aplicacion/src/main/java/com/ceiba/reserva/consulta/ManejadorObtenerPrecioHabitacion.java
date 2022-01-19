package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerPrecioHabitacion {

    private final DaoReserva daoReserva;


    public ManejadorObtenerPrecioHabitacion(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    public DtoReserva ejecutar(Long id_habitacion){
        return this.daoReserva.obtenerPrecioHabitacion(id_habitacion);
    }
}
