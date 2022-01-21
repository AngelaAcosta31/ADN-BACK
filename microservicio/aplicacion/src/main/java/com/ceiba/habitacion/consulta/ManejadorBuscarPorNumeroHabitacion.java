package com.ceiba.habitacion.consulta;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.habitacion.puerto.dao.DaoHabitacion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarPorNumeroHabitacion {

    private final DaoHabitacion daoHabitacion;

    public ManejadorBuscarPorNumeroHabitacion(DaoHabitacion daoHabitacion) {
        this.daoHabitacion = daoHabitacion;
    }
    public DtoHabitacion ejecutar(String numeroHabitacion){
        return this.daoHabitacion.buscarPorNumeroHabitacion(numeroHabitacion);
    }
}
