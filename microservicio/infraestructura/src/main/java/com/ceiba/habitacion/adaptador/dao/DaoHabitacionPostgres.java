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
    public List<DtoHabitacion> buscarPorNumeroCamas(int no_camas) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("no_camas", no_camas);
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
    public DtoHabitacion buscarPorNumeroHabitacion(String numero_habitacion) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("numero_habitacion", numero_habitacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarPorNumeroHabitacion, mapSqlParameterSource, new MapeoHabitacion()).stream().findFirst().get();
    }
}
