package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.manejador.ManejadorActualizarReserva;
import com.ceiba.reserva.comando.manejador.ManejadorCrearReserva;
import com.ceiba.reserva.comando.manejador.ManejadorEliminarReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@Api(tags = {"Controlador comando reserva"})
public class ComandoControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
    private final ManejadorActualizarReserva manejadorActualizarReserva;
    private final ManejadorEliminarReserva manejadorEliminarReserva;

    @Autowired
    public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva,
                                     ManejadorActualizarReserva manejadorActualizarReserva,
                                     ManejadorEliminarReserva manejadorEliminarReserva) {
        this.manejadorCrearReserva = manejadorCrearReserva;
        this.manejadorActualizarReserva = manejadorActualizarReserva;
        this.manejadorEliminarReserva = manejadorEliminarReserva;
    }

    @PostMapping
    @ApiOperation("crear reserva")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva){
        return manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar reserva")
    public void eliminar(@PathVariable Long id){
        manejadorEliminarReserva.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar reserva")
    public void actualizar(@RequestBody ComandoReserva comandoReserva, @PathVariable Long id){
        comandoReserva.setId(id);
        manejadorActualizarReserva.ejecutar(comandoReserva);
    }
}
