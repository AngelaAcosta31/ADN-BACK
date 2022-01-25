package com.ceiba.habitacion.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.servicio.testdatabuilder.HabitacionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HabitacionTest {


    private static final String SE_DEBE_INGRESAR_NUMERO_HABITACION="Se debe ingresar numero de habitación";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_HABITACION = "Se debe ingresar el tipo de habitación";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_CAMAS = "Se debe ingresar el numero de camas";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_BANIOS = "Se debe ingresar el numero de baños";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar una descripción de la habitación";
    private static final String SE_DEBE_INGRESAR_UN_ESTADO = "Se debe ingresar un estado";

    @Test
    @DisplayName("Deberia crear correctamente la habitacion")
    void deberiaCrearCorrectamenteLaHabitacion(){
        //Arrange-act
        Habitacion habitacion = new HabitacionTestDataBuilder().conIdHabitacion(1L).conNumeroHabitacion("120").build();
        //Assert
        assertEquals(1, habitacion.getId());
        assertEquals("120", habitacion.getNumeroHabitacion());
        assertEquals(1,habitacion.getNoCamas());
        assertEquals(1,habitacion.getNoBannos());
        assertEquals("HABITACION CON CAMA SENCILLA, TV, NEVERA Y BAÑO", habitacion.getDescripcion());
        assertEquals(20000.00, habitacion.getPrecio());
        assertEquals("1",habitacion.getPiso());
        assertEquals("D", habitacion.getEstado());
    }

    @Test
    void deberiaFallarSinNumeroHabitacion(){
        //Arrange
        HabitacionTestDataBuilder habitacionTestDataBuilder = new HabitacionTestDataBuilder().conIdHabitacion(1L).conNumeroHabitacion(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            habitacionTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class,SE_DEBE_INGRESAR_NUMERO_HABITACION);
    }


    @Test
    void deberiaFallarSinTipoHabitacion(){
        //Arrange
        HabitacionTestDataBuilder habitacionTestDataBuilder = new HabitacionTestDataBuilder().conIdHabitacion(1L).conTipo(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            habitacionTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class,SE_DEBE_INGRESAR_EL_TIPO_DE_HABITACION);
    }


    @Test
    void deberiaFallarSinNumeroCamas(){
        //Arrange
        HabitacionTestDataBuilder habitacionTestDataBuilder = new HabitacionTestDataBuilder().conIdHabitacion(1L).conNumeroCamas(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            habitacionTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class,SE_DEBE_INGRESAR_EL_NUMERO_DE_CAMAS);
    }


    @Test
    void deberiaFallarSinNumeroBannios(){
        //Arrange
        HabitacionTestDataBuilder habitacionTestDataBuilder = new HabitacionTestDataBuilder().conIdHabitacion(1L).conNumeroBannios(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            habitacionTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class,SE_DEBE_INGRESAR_EL_NUMERO_DE_BANIOS);
    }


    @Test
    void deberiaFallarSinDescripcion(){
        //Arrange
        HabitacionTestDataBuilder habitacionTestDataBuilder = new HabitacionTestDataBuilder().conIdHabitacion(1L).conDescripcion(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            habitacionTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class,SE_DEBE_INGRESAR_LA_DESCRIPCION);
    }


    @Test
    void deberiaFallarSinEstado(){
        //Arrange
        HabitacionTestDataBuilder habitacionTestDataBuilder = new HabitacionTestDataBuilder().conIdHabitacion(1L).conEstado(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            habitacionTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class,SE_DEBE_INGRESAR_UN_ESTADO);
    }





}
