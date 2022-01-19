package com.ceiba.habitacion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ComandoClienteTestDataBuilder;
import com.ceiba.habitacion.comando.ComandoHabitacion;
import com.ceiba.habitacion.servicio.testdatabuilder.ComandoHabitacionTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorHabitacion.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorHabitacionTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Deberia crear una habitacion")
    void deberiaCrearUnaHabitacion()throws Exception{
        //Arrange
        ComandoHabitacion habitacion = new ComandoHabitacionTestDataBuilder().build();
        //act-assert
        mockMvc.perform(post("/habitaciones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(habitacion)))
                .andExpect(status().isOk())
                .andExpect(content().json("{valor:3}"));
    }

    @Test
    @DisplayName("Deberia fallar al crear una habitacion con un numero de habitacion repetida")
    void deberiaFallarAlCrearHabitacionConNumeroHabitacionRepetida()throws Exception{
        //Arrange
        ComandoHabitacion habitacion = new ComandoHabitacionTestDataBuilder().conNumeroHabitacion("221").build();
        //act-assert
        mockMvc.perform(post("/habitaciones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(habitacion)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{'nombreExcepcion':'ExcepcionDuplicidad','mensaje':'La habitacion ya existe en el sistema'}"));
    }


    @Test
    @DisplayName("Deberia actualizar una habitacion")
    void deberiaActualizarUnaHabitacion()throws Exception{
        //Arrange
        Long id=2L;
        ComandoHabitacion habitacion = new ComandoHabitacionTestDataBuilder().conNumeroHabitacion("111").build();
        //act-assert
        mockMvc.perform(put("/habitaciones/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(habitacion)))
                .andExpect(status().isOk());

    }

    //NO FUNCIONA
    @Test
    @DisplayName("Deberia eliminar una habitacion")
    void deberiaEliminarUnaHabitacion()throws Exception{
        //Arrange
        Long id = 3L;
        //act-assert
        mockMvc.perform(delete("/habitaciones/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(get("/habitaciones")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));

    }

/*    @Test
    @DisplayName("Deberia fallar si se va a actualizar una habitacion que no existe")
    void deberiaFallarAlActualizarUnaHabitacionQueNoExiste() throws Exception {
        Long id = 10L;
        ComandoHabitacion habitacion = new ComandoHabitacionTestDataBuilder().build();
        mockMvc.perform(put("/habitaciones/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(habitacion)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{'nombreExcepcion':'ExcepcionDuplicidad','mensaje':'La habitacion no existe en el sistema'}"));
    }*/



}
