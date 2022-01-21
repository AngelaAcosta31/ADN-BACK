package com.ceiba.reserva.controlador;

import com.ceiba.reserva.consulta.*;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@Api(tags = {"Controlador consulta reserva"})
public class ConsultaControladorReserva {

    private final ManejadorListarReserva manejadorListarReserva;
    private final ManejadorListarPorFechaEntradaReserva manejadorListarPorFechaEntradaReserva;
    private final ManejadorListarPorFechaSalidaReserva manejadorListarPorFechaSalidaReserva;
    private final ManejadorListarPorIdHabitacionReserva manejadorListarPorIdHabitacionReserva;
    private final ManejadorBuscarPorIdClienteReserva manejadorBuscarPorIdClienteReserva;


    public ConsultaControladorReserva(ManejadorListarReserva manejadorListarReserva,
                                      ManejadorListarPorFechaEntradaReserva manejadorListarPorFechaEntradaReserva,
                                      ManejadorListarPorFechaSalidaReserva manejadorListarPorFechaSalidaReserva,
                                      ManejadorListarPorIdHabitacionReserva manejadorListarPorIdHabitacionReserva,
                                      ManejadorBuscarPorIdClienteReserva manejadorBuscarPorIdClienteReserva) {
        this.manejadorListarReserva = manejadorListarReserva;
        this.manejadorListarPorFechaEntradaReserva = manejadorListarPorFechaEntradaReserva;
        this.manejadorListarPorFechaSalidaReserva = manejadorListarPorFechaSalidaReserva;
        this.manejadorListarPorIdHabitacionReserva = manejadorListarPorIdHabitacionReserva;
        this.manejadorBuscarPorIdClienteReserva = manejadorBuscarPorIdClienteReserva;

    }

    @GetMapping
    @ApiOperation("Listar reservas")
    public List<DtoReserva> listar(){
        return this.manejadorListarReserva.ejecutar();
    }

    @GetMapping("/fecha_entrada/{fechaEntrada}")
    @ApiOperation("Listar por fecha de entrada")
    public List<DtoReserva> listarPorFechaEntrada(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaEntrada){
        return this.manejadorListarPorFechaEntradaReserva.ejecutar(fechaEntrada);
    }

    @GetMapping("/fecha_salida/{fechaSalida}")
    @ApiOperation("Listar por fecha salida")
    public List<DtoReserva> listarPorFechaSalida(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate fechaSalida){
        return this.manejadorListarPorFechaSalidaReserva.ejecutar(fechaSalida);
    }

    @GetMapping("/id_habitacion/{idHabitacion}")
    @ApiOperation("Listar por id_habitacion")
    public List<DtoReserva> listarPorIdHabitacion(@PathVariable Long idHabitacion){
        return this.manejadorListarPorIdHabitacionReserva.ejecutar(idHabitacion);
    }

    @GetMapping("/id_cliente/{idCliente}")
    @ApiOperation("Listar por id_cliente")
    public List<DtoReserva> listarPorIdCliente(@PathVariable Long idCliente){
        return this.manejadorBuscarPorIdClienteReserva.ejecutar(idCliente);
    }

}
