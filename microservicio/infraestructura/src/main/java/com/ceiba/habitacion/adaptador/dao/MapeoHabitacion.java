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
        String numero_habitacion = resultSet.getString("numero_habitacion");
        String tipo = resultSet.getString("tipo");
        Integer no_camas = resultSet.getInt("no_camas");
        Integer no_bannos = resultSet.getInt("no_bannos");
        String descripcion = resultSet.getString("descripcion");
        Double precio = resultSet.getDouble("precio");
        String piso = resultSet.getString("piso");
        String estado = resultSet.getString("estado");

        return new DtoHabitacion(id,numero_habitacion,tipo,no_camas,no_bannos,descripcion,precio,piso,estado);
    }
}
