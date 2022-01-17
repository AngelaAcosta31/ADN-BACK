package com.ceiba.cliente.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    private static final String  SE_DEBE_INGRESAR_UN_NOMBRE=" Se debe ingresar un nombre";
    private static final String  SE_DEBE_INGRESAR_UN_APELLIDO="Se debe ingresar un appellido";
    private static final String  SE_DEBE_INGRESAR_UN_NUMERO_IDENTIFICACION="Se debe ingresar un numero de identificación";
    private static final String  SE_DEBE_INGRESAR_SEXO="Se debe ingresar el sexo";
    private static final String  SE_DEBE_INGRESAR_FECHA_NACIMIENTO="Se debe ingresar la fecha de nacimiento";

    @Test
    @DisplayName("Deberia crear correctamente el cliente")
    void deberiaCrearCorrectamenteElCliente(){
        //Arrange
        LocalDateTime fecha_nacimiento = LocalDateTime.of(LocalDate.of(1990,10,20), LocalTime.of(13,20));
        //Act

    }


}
