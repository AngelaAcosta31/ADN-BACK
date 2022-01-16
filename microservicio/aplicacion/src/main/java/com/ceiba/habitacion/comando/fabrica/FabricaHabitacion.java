package com.ceiba.habitacion.comando.fabrica;

import com.ceiba.habitacion.comando.ComandoHabitacion;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import org.springframework.stereotype.Component;

@Component
public class FabricaHabitacion {

    public Habitacion crear(ComandoHabitacion comandoHabitacion){
        return new Habitacion(
                comandoHabitacion.getId_habitacion(),
                comandoHabitacion.getNumero_habitacion(),
                comandoHabitacion.getTipo(),
                comandoHabitacion.getNo_camas(),
                comandoHabitacion.getNo_bannos(),
                comandoHabitacion.getDescripcion(),
                comandoHabitacion.getPrecio(),
                comandoHabitacion.getPiso(),
                comandoHabitacion.getEstado()
        );
    }
}
