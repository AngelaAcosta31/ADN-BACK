package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.dao.DaoHabitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";

    private final RepositorioReserva repositorioReserva;
    private final DaoHabitacion daoHabitacion;
    private final RepositorioHabitacion repositorioHabitacion;


    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioHabitacion repositorioHabitacion, DaoHabitacion daoHabitacion) {
        this.repositorioHabitacion = repositorioHabitacion;
        this.repositorioReserva = repositorioReserva;
        this.daoHabitacion = daoHabitacion;
    }

    public Long ejecutar(Reserva reserva){
        validarExistenciaPrevia(reserva);
        return this.repositorioReserva.crear(reserva);
    }

    private void validarExistenciaPrevia(Reserva reserva){
        boolean existe = this.repositorioReserva.existePorId(reserva.getId());
        if(existe){
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }


    private Double obtenerPrecioHabitacion(Reserva reserva, DaoHabitacion daoHabitacion){
        return this.daoHabitacion.precioHabitacion(reserva.getIdHabitacion());
    }
}
