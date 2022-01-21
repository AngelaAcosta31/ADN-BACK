package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaPostgres implements RepositorioReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "reserva", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "reserva", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "reserva", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "reserva", value = "existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace = "reserva", value = "existePorIdHabitacion")
    private static String sqlExistePorIdHabitacion;

    @SqlStatement(namespace = "reserva", value = "existePorIdCliente")
    private static String sqlExistePorIdCliente;

    @SqlStatement(namespace = "reserva", value = "existe")
    private static String sqlExiste;


    public RepositorioReservaPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long crear(Reserva reserva) {
        return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
    }

    @Override
    public void actualizar(Reserva reserva) {
        this.customNamedParameterJdbcTemplate.actualizar(reserva,sqlActualizar);

    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id",id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar,mapSqlParameterSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);

    }

    @Override
    public boolean existePorIdHabitacion(Long idHabitacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idHabitacion", idHabitacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdHabitacion,paramSource, Boolean.class);

    }

    @Override
    public boolean existePorIdCliente(Long idCliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCliente", idCliente);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdCliente,paramSource, Boolean.class);

    }
}
