package com.ceiba.habitacion.adaptador.dao;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoHabitacion implements RowMapper<DtoHabitacion>, MapperResult {
    @Override
    public DtoHabitacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String numeroHabitacion = resultSet.getString("numeroHabitacion");
        String tipo = resultSet.getString("tipo");
        Integer noCamas = resultSet.getInt("noCamas");
        Integer noBannos = resultSet.getInt("noBannos");
        String descripcion = resultSet.getString("descripcion");
        Double precio = resultSet.getDouble("precio");
        String piso = resultSet.getString("piso");
        String estado = resultSet.getString("estado");

        return new DtoHabitacion(id,numeroHabitacion,tipo,noCamas,noBannos,descripcion,precio,piso,estado);
    }
}
