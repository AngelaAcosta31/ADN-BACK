package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {
    @Override
    public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String numeroIdentificacion = resultSet.getString("numeroIdentificacion");
        String telefono = resultSet.getString("telefono");
        String correo = resultSet.getString("correo");
        String sexo = resultSet.getString("sexo");
        LocalDate fechaNacimiento = extraerLocalDate(resultSet, "fechaNacimiento");
        String direccion = resultSet.getString("direccion");

        return new DtoCliente(id,nombre,apellido,numeroIdentificacion,telefono,correo,sexo,fechaNacimiento,direccion);
    }


}
