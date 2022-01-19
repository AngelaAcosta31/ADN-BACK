package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {
    @Override
    public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String numero_identificacion = resultSet.getString("numero_identificacion");
        String telefono = resultSet.getString("telefono");
        String correo = resultSet.getString("correo");
        String sexo = resultSet.getString("sexo");
        LocalDate fecha_nacimiento = extraerLocalDate(resultSet, "fecha_nacimiento");
        String direccion = resultSet.getString("direccion");

        return new DtoCliente(id,nombre,apellido,numero_identificacion,telefono,correo,sexo,fecha_nacimiento,direccion);
    }


}
