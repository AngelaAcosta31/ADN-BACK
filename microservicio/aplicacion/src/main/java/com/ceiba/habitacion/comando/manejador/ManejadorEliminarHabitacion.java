package com.ceiba.habitacion.comando.manejador;

import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarHabitacion implements ManejadorComando<Long> {

    private final ServicioEliminarCliente servicioEliminarCliente;


    public ManejadorEliminarHabitacion(ServicioEliminarCliente servicioEliminarCliente) {
        this.servicioEliminarCliente = servicioEliminarCliente;
    }

    public void ejecutar(Long idHabitacion){
        this.servicioEliminarCliente.ejecutar(idHabitacion);
    }
}
