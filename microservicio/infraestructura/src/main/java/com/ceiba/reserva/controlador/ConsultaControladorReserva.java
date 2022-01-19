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
    private final ManejadorObtenerPrecioHabitacion manejadorObtenerPrecioHabitacion;

    public ConsultaControladorReserva(ManejadorListarReserva manejadorListarReserva,
                                      ManejadorListarPorFechaEntradaReserva manejadorListarPorFechaEntradaReserva,
                                      ManejadorListarPorFechaSalidaReserva manejadorListarPorFechaSalidaReserva,
                                      ManejadorListarPorIdHabitacionReserva manejadorListarPorIdHabitacionReserva,
                                      ManejadorBuscarPorIdClienteReserva manejadorBuscarPorIdClienteReserva, ManejadorObtenerPrecioHabitacion manejadorObtenerPrecioHabitacion) {
        this.manejadorListarReserva = manejadorListarReserva;
        this.manejadorListarPorFechaEntradaReserva = manejadorListarPorFechaEntradaReserva;
        this.manejadorListarPorFechaSalidaReserva = manejadorListarPorFechaSalidaReserva;
        this.manejadorListarPorIdHabitacionReserva = manejadorListarPorIdHabitacionReserva;
        this.manejadorBuscarPorIdClienteReserva = manejadorBuscarPorIdClienteReserva;
        this.manejadorObtenerPrecioHabitacion = manejadorObtenerPrecioHabitacion;
    }

    @GetMapping
    @ApiOperation("Listar reservas")
    public List<DtoReserva> listar(){
        return this.manejadorListarReserva.ejecutar();
    }

    @GetMapping("/fecha_entrada/{fecha_entrada}")
    @ApiOperation("Listar por fecha de entrada")
    public List<DtoReserva> listarPorFechaEntrada(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha_entrada){
        return this.manejadorListarPorFechaEntradaReserva.ejecutar(fecha_entrada);
    }

    @GetMapping("/fecha_salida/{fecha_salida}")
    @ApiOperation("Listar por fecha salida")
    public List<DtoReserva> listarPorFechaSalida(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate fecha_salida){
        return this.manejadorListarPorFechaSalidaReserva.ejecutar(fecha_salida);
    }

    @GetMapping("/id_habitacion/{id_habitacion}")
    @ApiOperation("Listar por id_habitacion")
    public List<DtoReserva> listarPorIdHabitacion(@PathVariable Long id_habitacion){
        return this.manejadorListarPorIdHabitacionReserva.ejecutar(id_habitacion);
    }

    @GetMapping("/id_cliente/{id_cliente}")
    @ApiOperation("Listar por id_cliente")
    public List<DtoReserva> listarPorIdCliente(@PathVariable Long id_cliente){
        return this.manejadorBuscarPorIdClienteReserva.ejecutar(id_cliente);
    }

    @GetMapping("/precioHabitacion/{id_habitacion}")
    @ApiOperation("Obtiene el precio base de la habitacion segun el id de la habitacion")
    public DtoReserva obtenerPrecioHabitacion(@PathVariable Long id_habitacion){
        return this.manejadorObtenerPrecioHabitacion.ejecutar(id_habitacion);
    }
}
