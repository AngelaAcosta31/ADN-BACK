package com.ceiba.reserva.adaptador.dao;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DaoReservaPostgres implements DaoReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "reserva", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "reserva", value = "listarPorFechaEntrada")
    private static String sqlListarPorFechaEntrada;

    @SqlStatement(namespace = "reserva", value = "listarPorFechaSalida")
    private static String sqlListarPorFechaSalida;

    @SqlStatement(namespace = "reserva", value = "listarPorIdCliente")
    private static String sqlListarPorIdCliente;

    @SqlStatement(namespace = "reserva", value = "listarPorIdHabitacion")
    private static String sqlListarPorIdHabitacion;

    public DaoReservaPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoReserva> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoReserva());
    }

    @Override
    public List<DtoReserva> buscarPorFechaEntrada(LocalDateTime fecha_entrada) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("fecha_entrada", fecha_entrada);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorFechaEntrada, mapSqlParameterSource, new MapeoReserva());
    }

    @Override
    public List<DtoReserva> buscarPorFechaSalida(LocalDateTime fecha_salida) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("fecha_salida", fecha_salida);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorFechaSalida, mapSqlParameterSource, new MapeoReserva());
    }

    @Override
    public List<DtoReserva> buscarPorIdHabitacion(Long id_habitacion) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id_habitacion", id_habitacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorIdHabitacion, mapSqlParameterSource, new MapeoReserva());
    }

    @Override
    public List<DtoReserva> buscarPorIdCliente(Long id_cliente) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id_cliente", id_cliente);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorIdCliente, mapSqlParameterSource, new MapeoReserva());
    }
}
