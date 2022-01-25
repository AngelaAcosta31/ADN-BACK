package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.habitacion.puerto.dao.DaoHabitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
    private static final String LA_HABITACION_NO_EXISTE_EN_EL_SISTEMA = "La habitacion no existe en el sistema";
    private static final String LA_HABITACION_YA_ESTA_OCUPADA = "La habitacion ya se encuentra ocupada";

    private final RepositorioReserva repositorioReserva;
    private final DaoHabitacion daoHabitacion;
    private final RepositorioHabitacion repositorioHabitacion;



    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioHabitacion repositorioHabitacion, DaoHabitacion daoHabitacion) {
        this.repositorioReserva = repositorioReserva;
        this.daoHabitacion = daoHabitacion;
        this.repositorioHabitacion = repositorioHabitacion;
    }

    public Long ejecutar(Reserva reserva){

        validarExistenciaPrevia(reserva);
        //validarExistenciaPreviaHabitacion(reserva.getIdHabitacion());
        //validarExistenciaPreviaIdHabitacion(reserva.getIdHabitacion());

        //reserva.setValor(precioHabitacion(reserva.getIdHabitacion()));

        return this.repositorioReserva.crear(reserva);
    }

    private void validarExistenciaPrevia(Reserva reserva){
        boolean existe = this.repositorioReserva.existePorId(reserva.getId());
        if(existe){
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPreviaHabitacion(Long id){
        boolean existe = this.repositorioHabitacion.existePorId(id);
        if(!existe){
            throw new ExcepcionSinDatos(LA_HABITACION_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPreviaIdHabitacion(Long id){
        boolean existe = this.repositorioReserva.existePorIdHabitacion(id);
        if(existe){
            throw new ExcepcionDuplicidad(LA_HABITACION_YA_ESTA_OCUPADA);
        }
    }


    public Double precioHabitacion(Long idHabitacion){
        return this.daoHabitacion.precioHabitacion(idHabitacion);
    }

}
