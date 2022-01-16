package com.ceiba.habitacion.consulta;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.habitacion.puerto.dao.DaoHabitacion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPorPiso {

    private final DaoHabitacion daoHabitacion;

    public ManejadorListarPorPiso(DaoHabitacion daoHabitacion) {
        this.daoHabitacion = daoHabitacion;
    }

    public List<DtoHabitacion> ejecutar(String piso){
        return this.daoHabitacion.buscarPorPiso(piso);
    }
}
