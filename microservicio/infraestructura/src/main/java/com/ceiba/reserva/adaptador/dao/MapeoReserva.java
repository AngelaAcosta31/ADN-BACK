package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {
    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id= resultSet.getLong("id");
        Double valor = resultSet.getDouble("valor");
        LocalDate fecha_entrada = extraerLocalDate(resultSet, "fecha_entrada");
        LocalDate fecha_salida = extraerLocalDate(resultSet, "fecha_salida");
        Long id_habitacion = resultSet.getLong("id_habitacion");
        Long id_cliente = resultSet.getLong("id_cliente");

        return new DtoReserva(id,valor,fecha_entrada,fecha_salida,id_habitacion,id_cliente);
    }
}
