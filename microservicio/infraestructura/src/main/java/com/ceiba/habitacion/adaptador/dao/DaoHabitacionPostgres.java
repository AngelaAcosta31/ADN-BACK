package com.ceiba.habitacion.adaptador.dao;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.habitacion.puerto.dao.DaoHabitacion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoHabitacionPostgres implements DaoHabitacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "habitacion", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "habitacion", value = "buscarPorNumeroHabitacion")
    private static String sqlBuscarPorNumeroHabitacion;

    @SqlStatement(namespace = "habitacion", value = "listarPorEstado")
    private static String sqlListarPorEstado;

    @SqlStatement(namespace = "habitacion", value = "listarPorNumeroCamas")
    private static String sqlListarPorNumeroCamas;

    @SqlStatement(namespace = "habitacion", value = "listarPorPiso")
    private static String sqlListarPorPiso;

    @SqlStatement(namespace = "habitacion", value = "listarPorTipo")
    private static String sqlListarPorTipo;

    @SqlStatement(namespace = "habitacion", value = "precioHabitacion")
    private static String sqlPrecioHabitacion;

    public DaoHabitacionPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoHabitacion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoHabitacion());
    }

    @Override
    public List<DtoHabitacion> buscarPorTipo(String tipo) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("tipo", tipo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorTipo, mapSqlParameterSource, new MapeoHabitacion());
    }

    @Override
    public List<DtoHabitacion> buscarPorNumeroCamas(int noCamas) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("noCamas", noCamas);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorNumeroCamas, mapSqlParameterSource, new MapeoHabitacion());
    }

    @Override
    public List<DtoHabitacion> buscarPorPiso(String piso) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("piso", piso);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorPiso, mapSqlParameterSource, new MapeoHabitacion());
    }

    @Override
    public List<DtoHabitacion> buscarPorEstado(String estado) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("estado", estado);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorEstado, mapSqlParameterSource, new MapeoHabitacion());
    }

    @Override
    public DtoHabitacion buscarPorNumeroHabitacion(String numeroHabitacion) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("numeroHabitacion", numeroHabitacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarPorNumeroHabitacion, mapSqlParameterSource, new MapeoHabitacion()).stream().findFirst().get();
    }

    @Override
    public Double precioHabitacion(Long idHabitacion) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", idHabitacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlPrecioHabitacion,mapSqlParameterSource, Double.class);
    }
}
