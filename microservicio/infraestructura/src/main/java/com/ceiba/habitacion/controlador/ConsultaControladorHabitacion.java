package com.ceiba.habitacion.controlador;


import com.ceiba.habitacion.consulta.*;
import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitaciones")
@Api(tags = {"Controlador consulta habitacion"})
public class ConsultaControladorHabitacion {

    private final ManejadorBuscarPorNumeroHabitacion manejadorBuscarPorNumeroHabitacion;
    private final ManejadorListarHabitacion manejadorListarHabitacion;
    private final ManejadorListarPorEstadoHabitacion manejadorListarPorEstadoHabitacion;
    private final ManejadorListarPorNumeroCamasHabitacion manejadorListarPorNumeroCamasHabitacion;
    private final ManejadorListarPorPiso manejadorListarPorPiso;
    private final ManejadorListarPorTipoHabitacion manejadorListarPorTipoHabitacion;

    public ConsultaControladorHabitacion(ManejadorBuscarPorNumeroHabitacion manejadorBuscarPorNumeroHabitacion,
                                         ManejadorListarHabitacion manejadorListarHabitacion,
                                         ManejadorListarPorEstadoHabitacion manejadorListarPorEstadoHabitacion,
                                         ManejadorListarPorNumeroCamasHabitacion manejadorListarPorNumeroCamasHabitacion,
                                         ManejadorListarPorPiso manejadorListarPorPiso,
                                         ManejadorListarPorTipoHabitacion manejadorListarPorTipoHabitacion) {
        this.manejadorBuscarPorNumeroHabitacion = manejadorBuscarPorNumeroHabitacion;
        this.manejadorListarHabitacion = manejadorListarHabitacion;
        this.manejadorListarPorEstadoHabitacion = manejadorListarPorEstadoHabitacion;
        this.manejadorListarPorNumeroCamasHabitacion = manejadorListarPorNumeroCamasHabitacion;
        this.manejadorListarPorPiso = manejadorListarPorPiso;
        this.manejadorListarPorTipoHabitacion = manejadorListarPorTipoHabitacion;
    }

    @GetMapping
    @ApiOperation("Listar habitaciones")
    public List<DtoHabitacion> listar(){
        return this.manejadorListarHabitacion.ejecutar();
    }

    @GetMapping("/numeroHabitacion/{numeroHabitacion}")
    @ApiOperation("Buscar por numero habitacion")
    public DtoHabitacion buscarPorNumeroHabitacion(@PathVariable String numeroHabitacion){
        return  this.manejadorBuscarPorNumeroHabitacion.ejecutar(numeroHabitacion);
    }

    @GetMapping("/estado/{estado}")
    @ApiOperation("Buscar por estado")
    public List<DtoHabitacion> buscarPorEstado(@PathVariable String estado){
        return this.manejadorListarPorEstadoHabitacion.ejecutar(estado);
    }

    @GetMapping("/numero_camas/{no_camas}")
    @ApiOperation("Buscar por numero de camas")
    public List<DtoHabitacion> buscarPorNumeroCamas(@PathVariable Integer no_camas){
        return this.manejadorListarPorNumeroCamasHabitacion.ejecutar(no_camas);
    }

    @GetMapping("/piso/{piso}")
    @ApiOperation("Buscar por piso")
    public List<DtoHabitacion> buscarPorPiso(@PathVariable String piso){
        return this.manejadorListarPorPiso.ejecutar(piso);
    }

    @GetMapping("/tipo/{tipo}")
    @ApiOperation("Buscar por tipo")
    public List<DtoHabitacion> buscarPorTipo(@PathVariable String tipo){
        return this.manejadorListarPorTipoHabitacion.ejecutar(tipo);
    }

}
