package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {
    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id_reserva = resultSet.getLong("id_reserva");
        Double valor = resultSet.getDouble("valor");
        LocalDateTime fecha_entrada = extraerLocalDateTime(resultSet, "fecha_entrada");
        LocalDateTime fecha_salida = extraerLocalDateTime(resultSet, "fecha_salida");
        Long id_habitacion = resultSet.getLong("id_habitacion");
        Long id_cliente = resultSet.getLong("id_cliente");

        return new DtoReserva(id_reserva,valor,fecha_entrada,fecha_salida,id_habitacion,id_cliente);
    }
}
