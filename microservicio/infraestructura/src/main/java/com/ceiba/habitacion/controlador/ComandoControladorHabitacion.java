package com.ceiba.habitacion.controlador;

import com.ceiba.ComandoRespuesta;

import com.ceiba.habitacion.comando.ComandoHabitacion;
import com.ceiba.habitacion.comando.manejador.ManejadorActualizarHabitacion;
import com.ceiba.habitacion.comando.manejador.ManejadorCrearHabitacion;
import com.ceiba.habitacion.comando.manejador.ManejadorEliminarHabitacion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habitaciones")
@Api(tags = {"Controlador comando habitacion"})
public class ComandoControladorHabitacion {

    private final ManejadorCrearHabitacion manejadorCrearHabitacion;
    private final ManejadorActualizarHabitacion manejadorActualizarHabitacion;
    private final ManejadorEliminarHabitacion manejadorEliminarHabitacion;

    @Autowired
    public ComandoControladorHabitacion(ManejadorCrearHabitacion manejadorCrearHabitacion,
                                        ManejadorActualizarHabitacion manejadorActualizarHabitacion,
                                        ManejadorEliminarHabitacion manejadorEliminarHabitacion) {
        this.manejadorCrearHabitacion = manejadorCrearHabitacion;
        this.manejadorActualizarHabitacion = manejadorActualizarHabitacion;
        this.manejadorEliminarHabitacion = manejadorEliminarHabitacion;
    }


    @PostMapping
    @ApiOperation("crear habitacion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoHabitacion comandoHabitacion){
        return manejadorCrearHabitacion.ejecutar(comandoHabitacion);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar habitacion")
    public void eliminar(@PathVariable Long id){
        manejadorEliminarHabitacion.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar habitacion")
    public void actualizar(@RequestBody ComandoHabitacion comandoHabitacion, @PathVariable Long id){
        comandoHabitacion.setId(id);
        manejadorActualizarHabitacion.ejecutar(comandoHabitacion);
    }
}
