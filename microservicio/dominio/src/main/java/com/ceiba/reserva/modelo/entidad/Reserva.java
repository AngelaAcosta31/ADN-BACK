package com.ceiba.reserva.modelo.entidad;

import javafx.util.converter.LocalDateTimeStringConverter;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Reserva {

    private static final String SE_DEBE_INGRESAR_FECHA_ENTRADA = "Se debe ingresar la fecha de entrada";
    private static final String SE_DEBE_INGRESAR_UN_VALOR = "Se debe ingresar el valor a pagar";
    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_HABITACION = "Se debe ingresar el id de la habitación";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_CLIENTE = "Se debe ingresar el id del cliente";

    private static final String TEMPORADA_ALTA = "TEMPORADA ALTA";
    private static final String TEMPORADA_BAJA = "TEMPORADA BAJA";

    private Long id;
    private Double valor;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Long idHabitacion;
    private Long idCliente;


    public Reserva(Long id, Double valor, LocalDate fechaEntrada, LocalDate fechaSalida, Long idHabitacion, Long idCliente) {

        validarObligatorio(fechaEntrada, SE_DEBE_INGRESAR_FECHA_ENTRADA);
        validarObligatorio(idHabitacion, SE_DEBE_INGRESAR_EL_ID_DE_LA_HABITACION);
        validarObligatorio(idCliente, SE_DEBE_INGRESAR_EL_ID_DEL_CLIENTE);


        this.id = id;
        this.valor = calcularTotal(valor, fechaEntrada, fechaSalida);
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.idHabitacion = idHabitacion;
        this.idCliente = idCliente;
    }

    public Double calcularTotal(Double precioHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida){
        Integer totalDias =0;

        DayOfWeek diasDeLaSemana = fechaEntrada.getDayOfWeek();
        //los fines de semana el valor aumenta un 20% para temporada alta
        if(diasDeLaSemana == DayOfWeek.FRIDAY || diasDeLaSemana == DayOfWeek.SATURDAY || diasDeLaSemana == DayOfWeek.SUNDAY){
            // recibo la cantidad de dias que estara hospedado el cliente
            totalDias = totalDias(fechaEntrada,fechaSalida);
            // se revisa la fecha de entrada para saber en que temporada esta
            if(temporadaBajaoAlta(fechaEntrada,fechaSalida).equals(TEMPORADA_ALTA)){
                // la temporada alta aumenta un 40% + 20% de los fines de semana
                return (totalDias * precioHabitacion) + (totalDias * precioHabitacion * 0.2) + (totalDias * precioHabitacion * 0.4);
            }else{
                // si es temporada baja aumenta un 10% del valor total para los fines de semana
               return  (totalDias * precioHabitacion) + (totalDias * precioHabitacion * 0.1);
            }

        }else{
            // recibo la cantidad de dias que estara hospedado el cliente
            totalDias= totalDias(fechaEntrada,fechaSalida);
            // se revisa la fecha de entrada del cliente para determinar en que temporada esta
            if(temporadaBajaoAlta(fechaEntrada,fechaSalida).equals(TEMPORADA_ALTA)){
                // la temporada alta aumenta un 40%
                return (totalDias * precioHabitacion) + (totalDias * precioHabitacion * 0.4);
            }else{
                // si es temporada baja disminuye un 10% del valor total
                return  (totalDias * precioHabitacion) - (totalDias * precioHabitacion * 0.1);
            }

        }
    }

    public Integer totalDias(LocalDate fechaEntrada, LocalDate fechaSalida){
        Integer dias = 0;
        dias = fechaSalida.getDayOfYear() - fechaEntrada.getDayOfYear();
        return dias;
    }

    public String temporadaBajaoAlta(LocalDate fechaEntrada, LocalDate fechaSalida){

        // Si la fecha de entrada es en temporada baja y la fecha de salida es en temporada alta
        // se mantendra el costo de la temporada baja
        if((fechaEntrada.getMonth() == Month.MAY && fechaSalida.getMonth() == Month.JUNE) ||
                (fechaEntrada.getMonth() == Month.NOVEMBER && fechaSalida.getMonth() == Month.DECEMBER)){
            return TEMPORADA_BAJA;
        }

        // si la fecha de entrada es en estos meses sin importar cuando es la fecha de salida es TEMPORADA ALTA
        if(fechaEntrada.getMonth() == Month.JANUARY ||
                fechaEntrada.getMonth() == Month.JUNE ||
                fechaEntrada.getMonth() == Month.JULY ||
                fechaEntrada.getMonth() == Month.AUGUST ||
                fechaEntrada.getMonth() == Month.DECEMBER){
            return TEMPORADA_ALTA;
        }else{
            return TEMPORADA_BAJA;
        }






    }
}
