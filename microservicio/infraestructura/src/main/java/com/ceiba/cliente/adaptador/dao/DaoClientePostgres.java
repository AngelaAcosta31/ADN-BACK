package com.ceiba.cliente.adaptador.dao;


import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoClientePostgres implements DaoCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "cliente", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "cliente", value = "buscarPorCorreo")
    private static String sqlBuscarPorCorreo;

    @SqlStatement(namespace = "cliente", value = "buscarPorNumeroIdentificacion")
    private static String sqlBuscarPorNumeroIdentificacion;


    public DaoClientePostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCliente> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCliente());
    }

    @Override
    public DtoCliente buscarPorNumeroIdentificacion(String numeroIdentificacion) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("numeroIdentificacion", numeroIdentificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarPorNumeroIdentificacion, mapSqlParameterSource, new MapeoCliente()).stream().findFirst().get();
    }

    @Override
    public DtoCliente buscarPorCorreo(String correo) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("correo", correo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarPorCorreo, mapSqlParameterSource, new MapeoCliente()).stream().findFirst().get();
    }
}
