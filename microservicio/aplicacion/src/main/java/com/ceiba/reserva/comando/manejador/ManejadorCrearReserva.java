package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.habitacion.puerto.dao.DaoHabitacion;
import com.ceiba.habitacion.servicio.ServicioActualizarEstadoHabitacion;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.fabrica.FabricaReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;

import com.ceiba.reserva.servicio.ServicioCrearReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearReserva  implements ManejadorComandoRespuesta<ComandoReserva, ComandoRespuesta<Long>> {

    private final FabricaReserva fabricaReserva;
    private final ServicioCrearReserva servicioCrearReserva;
    private final ServicioActualizarEstadoHabitacion servicioActualizarEstadoHabitacion;
    private final DaoHabitacion daoHabitacion;

    public ManejadorCrearReserva(FabricaReserva fabricaReserva,
                                 ServicioCrearReserva servicioCrearReserva,
                                 ServicioActualizarEstadoHabitacion servicioActualizarEstadoHabitacion, DaoHabitacion daoHabitacion) {
        this.fabricaReserva = fabricaReserva;
        this.servicioCrearReserva = servicioCrearReserva;
        this.servicioActualizarEstadoHabitacion = servicioActualizarEstadoHabitacion;

        this.daoHabitacion = daoHabitacion;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoReserva comandoReserva){
        comandoReserva.setValor(precioHabitacion(comandoReserva.getIdHabitacion()));
        Reserva reserva = this.fabricaReserva.crear(comandoReserva);
        this.servicioActualizarEstadoHabitacion.ejecutar(comandoReserva.getIdHabitacion(),"O");
        return new ComandoRespuesta<>(this.servicioCrearReserva.ejecutar(reserva));
    }

    public Double precioHabitacion(Long idHabitacion){
        return this.daoHabitacion.precioHabitacion(idHabitacion);
    }

}
