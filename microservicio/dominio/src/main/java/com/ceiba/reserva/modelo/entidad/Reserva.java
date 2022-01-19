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



    private Long id;
    private Double valor;
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    private Long id_habitacion;
    private Long id_cliente;

    private Double precioHabitacion;

    public Reserva(Long id, Double valor, LocalDate fecha_entrada, LocalDate fecha_salida, Long id_habitacion, Long id_cliente) {

        validarObligatorio(fecha_entrada, SE_DEBE_INGRESAR_FECHA_ENTRADA);
        validarObligatorio(valor, SE_DEBE_INGRESAR_UN_VALOR);
        validarObligatorio(id_habitacion, SE_DEBE_INGRESAR_EL_ID_DE_LA_HABITACION);
        validarObligatorio(id_cliente, SE_DEBE_INGRESAR_EL_ID_DEL_CLIENTE);


        this.id = id;
        this.valor = calcularTotal(valor, fecha_entrada, fecha_salida);
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.id_habitacion = id_habitacion;
        this.id_cliente = id_cliente;
    }
   // metodo para consulta del precio




    public Double calcularTotal(Double precioHabitacion, LocalDate fecha_entrada, LocalDate fecha_salida){
       // Double total=0.0;
        Integer totalDias =0;
        DayOfWeek diasDeLaSemana = fecha_entrada.getDayOfWeek();
        //los fines de semana el valor aumenta un 20% para temporada alta
        if(diasDeLaSemana == DayOfWeek.FRIDAY || diasDeLaSemana == DayOfWeek.SATURDAY || diasDeLaSemana == DayOfWeek.SUNDAY){
            // recibo la cantidad de dias que estara hospedado el cliente
            totalDias = totalDias(fecha_entrada,fecha_salida);
            // se revisa la fecha de entrada para saber en que temporada esta
            if(temporadaBajaoAlta(fecha_entrada,fecha_salida).equals("TEMPORADA ALTA")){
                // la temporada alta aumenta un 40% + 20% de los fines de semana
                return (totalDias * precioHabitacion) + (totalDias * precioHabitacion * 0.2) + (totalDias * precioHabitacion * 0.4);
            }else{
                // si es temporada baja aumenta un 10% del valor total para los fines de semana
               return  (totalDias * precioHabitacion) + (totalDias * precioHabitacion * 0.1);
            }

        }else{
            // recibo la cantidad de dias que estara hospedado el cliente
            totalDias= totalDias(fecha_entrada,fecha_salida);
            // se revisa la fecha de entrada del cliente para determinar en que temporada esta
            if(temporadaBajaoAlta(fecha_entrada,fecha_salida).equals("TEMPORADA ALTA")){
                // la temporada alta aumenta un 40%
                return (totalDias * precioHabitacion) + (totalDias * precioHabitacion * 0.4);
            }else{
                // si es temporada baja disminuye un 10% del valor total
                return  (totalDias * precioHabitacion) - (totalDias * precioHabitacion * 0.1);
            }

        }
    }

    public Integer totalDias(LocalDate fecha_entrada, LocalDate fecha_salida){
        Integer dias = 0;
        //revisar este metodo
        //TemporalUnit unidadTemporalEnDias = ChronoUnit.DAYS;
        dias = fecha_salida.getDayOfYear() - fecha_entrada.getDayOfYear();
        return dias;
    }

    public String temporadaBajaoAlta(LocalDate fecha_entrada, LocalDate fecha_salida){
        String TEMPORADA_ALTA = "TEMPORADA ALTA";
        String TEMPORADA_BAJA = "TEMPORADA BAJA";

        // Si la fecha de entrada es en temporada baja y la fecha de salida es en temporada alta
        // se mantendra el costo de la temporada baja
        if((fecha_entrada.getMonth() == Month.MAY && fecha_salida.getMonth() == Month.JUNE) ||
                (fecha_entrada.getMonth() == Month.NOVEMBER && fecha_salida.getMonth() == Month.DECEMBER)){
            return TEMPORADA_BAJA;
        }

        // si la fecha de entrada es en estos meses sin importar cuando es la fecha de salida es TEMPORADA ALTA
        if(fecha_entrada.getMonth() == Month.JANUARY ||
                fecha_entrada.getMonth() == Month.JUNE ||
                fecha_entrada.getMonth() == Month.JULY ||
                fecha_entrada.getMonth() == Month.AUGUST ||
                fecha_entrada.getMonth() == Month.DECEMBER){
            return TEMPORADA_ALTA;
        }else{
            return TEMPORADA_BAJA;
        }






    }
}
