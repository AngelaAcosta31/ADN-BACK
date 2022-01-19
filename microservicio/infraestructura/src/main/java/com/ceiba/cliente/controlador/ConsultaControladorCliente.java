package com.ceiba.cliente.controlador;

import com.ceiba.cliente.consulta.ManejadorBuscarPorCorreoCliente;
import com.ceiba.cliente.consulta.ManejadorBuscarPorNumeroIdentificacionCliente;
import com.ceiba.cliente.consulta.ManejadorListarCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Api(tags = {"Controlador consulta cliente"})
public class ConsultaControladorCliente {

    private final ManejadorListarCliente manejadorListarCliente;
    private final ManejadorBuscarPorCorreoCliente manejadorBuscarPorCorreoCliente;
    private final ManejadorBuscarPorNumeroIdentificacionCliente manejadorBuscarPorNumeroIdentificacionCliente;

    public ConsultaControladorCliente(ManejadorListarCliente manejadorListarCliente, ManejadorBuscarPorCorreoCliente manejadorBuscarPorCorreoCliente, ManejadorBuscarPorNumeroIdentificacionCliente manejadorBuscarPorNumeroIdentificacionCliente) {
        this.manejadorListarCliente = manejadorListarCliente;
        this.manejadorBuscarPorCorreoCliente = manejadorBuscarPorCorreoCliente;
        this.manejadorBuscarPorNumeroIdentificacionCliente = manejadorBuscarPorNumeroIdentificacionCliente;
    }

    @GetMapping
    @ApiOperation("Listar clientes")
    public List<DtoCliente> listar(){
        return this.manejadorListarCliente.ejecutar();
    }

    @GetMapping("/correo/{correo}")
    @ApiOperation("Buscar por correo cliente")
    public DtoCliente buscarPorCorreo(@PathVariable String correo){
        return this.manejadorBuscarPorCorreoCliente.ejecutar(correo);
    }

    @GetMapping("/numeroId/{numeroId}")
    @ApiOperation("Buscar por numero de identificacion cliente")
    public DtoCliente buscarPorNumeroIdentificacion(@PathVariable String numeroId){
        return this.manejadorBuscarPorNumeroIdentificacionCliente.ejecutar(numeroId);
    }






}
