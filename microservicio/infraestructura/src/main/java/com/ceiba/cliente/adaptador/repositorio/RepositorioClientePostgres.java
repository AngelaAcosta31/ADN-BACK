package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClientePostgres implements RepositorioCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cliente", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="cliente", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="cliente", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="cliente", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="cliente", value="existePorId")
    private static String sqlExistePorId;


    @SqlStatement(namespace="cliente", value="existePorNumeroIdentificacion")
    private static String sqlExistePorNumeroIdentificacion;

    public RepositorioClientePostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Cliente cliente) {
        return this.customNamedParameterJdbcTemplate.crear(cliente, sqlCrear);
    }

    @Override
    public void actualizar(Cliente cliente) {
        this.customNamedParameterJdbcTemplate.actualizar(cliente, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, mapSqlParameterSource);
    }

    @Override
    public boolean existePorNumeroIdentificacion(String numeroIdentificacion) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("numeroIdentificacion", numeroIdentificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorNumeroIdentificacion, mapSqlParameterSource, Boolean.class);
    }
}
