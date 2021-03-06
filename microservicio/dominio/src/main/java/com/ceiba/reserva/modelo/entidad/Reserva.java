package com.ceiba.reserva.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Reserva {

    private static final String SE_DEBE_INGRESAR_FECHA_ENTRADA = "Se debe ingresar la fecha de entrada";
    private static final String SE_DEBE_INGRESAR_FECHA_SALIDA = "Se debe ingresar la fecha de salida";
    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_HABITACION = "Se debe ingresar el id de la habitación";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_CLIENTE = "Se debe ingresar el id del cliente";


    private static final double PORCENTAJE_TEMPORADA_ATA = 0.4;
    private static final double PORCENTAJE_TEMPORADA_BAJA = 0.1;
    private static final double PORCENTAJE_TEMPORADA_ATA_Y_FIN_DE_SEMANA = 0.6;

    private Long id;
    private Double valor;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Long idHabitacion;
    private Long idCliente;


    public Reserva(Long id, Double valor, LocalDate fechaEntrada, LocalDate fechaSalida, Long idHabitacion, Long idCliente) {

        validarObligatorio(fechaEntrada, SE_DEBE_INGRESAR_FECHA_ENTRADA);
        validarObligatorio(fechaSalida,SE_DEBE_INGRESAR_FECHA_SALIDA);
        validarObligatorio(idHabitacion, SE_DEBE_INGRESAR_EL_ID_DE_LA_HABITACION);
        validarObligatorio(idCliente, SE_DEBE_INGRESAR_EL_ID_DEL_CLIENTE);


        this.id = id;
        this.valor = calcularTotal(valor, fechaEntrada, fechaSalida);
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.idHabitacion = idHabitacion;
        this.idCliente = idCliente;
    }

    public Double calcularTotal(Double precioHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {

        Integer totalDias;
        double precioPorDias;

        DayOfWeek diasDeLaSemana = fechaEntrada.getDayOfWeek();

        totalDias = totalDias(fechaEntrada, fechaSalida);
        precioPorDias = totalDias * precioHabitacion;

        if (diasDeLaSemana == DayOfWeek.FRIDAY || diasDeLaSemana == DayOfWeek.SATURDAY || diasDeLaSemana == DayOfWeek.SUNDAY) {
            if (temporadaAlta(fechaEntrada).equals(true)) {
                return precioPorDias + (precioPorDias * PORCENTAJE_TEMPORADA_ATA_Y_FIN_DE_SEMANA);
            } else {
                return precioPorDias + (precioPorDias * PORCENTAJE_TEMPORADA_BAJA);
            }

        } else {
            if (temporadaAlta(fechaEntrada).equals(true)) {
                return precioPorDias + (precioPorDias * PORCENTAJE_TEMPORADA_ATA);
            } else {
                return precioPorDias - (precioPorDias * PORCENTAJE_TEMPORADA_BAJA);
            }

        }
    }

    public Integer totalDias(LocalDate fechaEntrada, LocalDate fechaSalida) {
        int dias;
        dias = fechaSalida.getDayOfYear() - fechaEntrada.getDayOfYear();
        return dias;
    }

    public Boolean temporadaAlta(LocalDate fechaEntrada) {

        List <String> temporadaAlta = new ArrayList<>();
        temporadaAlta.add("JANUARY");
        temporadaAlta.add("JUNE");
        temporadaAlta.add("JULY");
        temporadaAlta.add("AUGUST");
        temporadaAlta.add("DECEMBER");

        return temporadaAlta.contains(fechaEntrada.getMonth().toString());


    }

}
