package com.ceiba.reserva.adaptador.dao;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

    @SqlStatement(namespace = "reserva", value = "obtenerPrecioHabitacion")
    private static String sqlObtenerPrecioHabitacion;

    @SqlStatement(namespace = "reserva", value = "buscarPorIdReserva")
    private static String sqlBuscarPorIdReserva;

    public DaoReservaPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoReserva> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoReserva());
    }

    @Override
    public List<DtoReserva> buscarPorFechaEntrada(LocalDate fechaEntrada) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("fechaEntrada", fechaEntrada);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorFechaEntrada, mapSqlParameterSource, new MapeoReserva());
    }

    @Override
    public List<DtoReserva> buscarPorFechaSalida(LocalDate fechaSalida) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("fechaSalida", fechaSalida);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorFechaSalida, mapSqlParameterSource, new MapeoReserva());
    }

    @Override
    public List<DtoReserva> buscarPorIdHabitacion(Long idHabitacion) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("idHabitacion", idHabitacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorIdHabitacion, mapSqlParameterSource, new MapeoReserva());
    }

    @Override
    public List<DtoReserva> buscarPorIdCliente(Long idCliente) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("idCliente", idCliente);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorIdCliente, mapSqlParameterSource, new MapeoReserva());
    }

    @Override
    public DtoReserva buscarPorIdReserva(Long idReserva) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id",idReserva);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarPorIdReserva, mapSqlParameterSource, new MapeoReserva()).stream().findFirst().get();
    }

}
