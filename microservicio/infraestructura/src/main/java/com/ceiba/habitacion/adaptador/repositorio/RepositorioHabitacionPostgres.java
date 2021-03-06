package com.ceiba.habitacion.adaptador.repositorio;

import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioHabitacionPostgres implements RepositorioHabitacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="habitacion", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="habitacion", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="habitacion", value="actualizarEstado")
    private static String sqlActualizarEstado;

    @SqlStatement(namespace="habitacion", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="habitacion", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="habitacion", value="existePorNumeroHabitacion")
    private static String sqlExistePorNumeroHabitacion;

    @SqlStatement(namespace="habitacion", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioHabitacionPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Habitacion habitacion) {
        return this.customNamedParameterJdbcTemplate.crear(habitacion, sqlCrear);
    }

    @Override
    public void actualizar(Habitacion habitacion) {
        this.customNamedParameterJdbcTemplate.actualizar(habitacion, sqlActualizar);
    }

    @Override
    public void actualizarEstado(Long idHabitacion, String estado) {
        Habitacion habitacion = new Habitacion(idHabitacion, "","",0,0 ,"",0.0, "",estado);
        this.customNamedParameterJdbcTemplate.actualizar(habitacion, sqlActualizarEstado);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorNumeroHabitacion(String numeroHabitacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numeroHabitacion", numeroHabitacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorNumeroHabitacion,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
