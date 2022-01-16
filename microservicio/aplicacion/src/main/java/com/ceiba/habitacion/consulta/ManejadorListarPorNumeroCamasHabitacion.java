package com.ceiba.habitacion.consulta;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.habitacion.puerto.dao.DaoHabitacion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPorNumeroCamasHabitacion {

    private final DaoHabitacion daoHabitacion;

    public ManejadorListarPorNumeroCamasHabitacion(DaoHabitacion daoHabitacion) {
        this.daoHabitacion = daoHabitacion;
    }

    public List<DtoHabitacion> ejecutar(Integer numeroCamas){
        return this.daoHabitacion.buscarPorNumeroCamas(numeroCamas);
    }
}
