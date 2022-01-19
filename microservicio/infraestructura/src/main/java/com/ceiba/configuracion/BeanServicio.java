package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.habitacion.servicio.ServicioActualizarEstadoHabitacion;
import com.ceiba.habitacion.servicio.ServicioActualizarHabitacion;
import com.ceiba.habitacion.servicio.ServicioCrearHabitacion;
import com.ceiba.habitacion.servicio.ServicioEliminarHabitacion;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioActualizarReserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.reserva.servicio.ServicioEliminarReserva;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


 //----------------------------------------------------------------------------------------------------
    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente){
        return new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente (RepositorioCliente repositorioCliente){
        return new ServicioEliminarCliente(repositorioCliente);
    }

    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente){
        return new ServicioActualizarCliente(repositorioCliente);
    }

    @Bean
    public ServicioCrearHabitacion servicioCrearHabitacion(RepositorioHabitacion repositorioHabitacion){
        return new ServicioCrearHabitacion(repositorioHabitacion);
    }

    @Bean
    public ServicioEliminarHabitacion servicioEliminarHabitacion(RepositorioHabitacion repositorioHabitacion){
        return new ServicioEliminarHabitacion(repositorioHabitacion);
    }

    @Bean
    public ServicioActualizarHabitacion servicioActualizarHabitacion(RepositorioHabitacion repositorioHabitacion){
        return new ServicioActualizarHabitacion(repositorioHabitacion);
    }

    @Bean
    public ServicioActualizarEstadoHabitacion servicioActualizarEstadoHabitacion(RepositorioHabitacion repositorioHabitacion){
        return new ServicioActualizarEstadoHabitacion(repositorioHabitacion);
    }

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioHabitacion repositorioHabitacion){
        return new ServicioCrearReserva(repositorioReserva, repositorioHabitacion);
    }

    @Bean
    public ServicioEliminarReserva servicioEliminarReserva(RepositorioReserva repositorioReserva){
        return new ServicioEliminarReserva(repositorioReserva);
    }

    @Bean
    public ServicioActualizarReserva servicioActualizarReserva (RepositorioReserva repositorioReserva){
        return new ServicioActualizarReserva(repositorioReserva);
    }

	

}
