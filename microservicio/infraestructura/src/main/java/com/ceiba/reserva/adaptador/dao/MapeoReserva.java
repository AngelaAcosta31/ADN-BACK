package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {
    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {


        Long id= resultSet.getLong("id");
        Double valor = resultSet.getDouble("valor");
        LocalDate fechaEntrada = extraerLocalDate(resultSet, "fechaEntrada");
        LocalDate fechaSalida = extraerLocalDate(resultSet, "fechaSalida");
        Long idHabitacion = resultSet.getLong("idHabitacion");
        Long idCliente = resultSet.getLong("idCliente");

        return new DtoReserva(id,valor,fechaEntrada,fechaSalida,idHabitacion,idCliente);
    }
}
