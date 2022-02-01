package com.ceiba.reserva.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ComandoReservaTestDataBuilder;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorReserva.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorReservaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deberia crear una reserva")
    void deberiaCrearUnaReserva()throws Exception{
        //Arrange
        ComandoReserva reserva = new ComandoReservaTestDataBuilder().build();
        //act-assert
        mockMvc.perform(post("/reservas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isOk())
                .andExpect(content().json("{valor:3}"));
    }

    @Test
    @DisplayName("Deberia actualizar una reserva")
    void deberiaActualizarUnaReserva()throws Exception{
        //Arrange
        Long id = 1L;
        ComandoReserva reserva = new ComandoReservaTestDataBuilder().conIdCliente(1L).build();
        //act-assert
        mockMvc.perform(put("/reservas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar una reserva")
    void deberiaEliminarUnaReserva()throws Exception{
        //Arrange
        Long id = 1L;
        //act-assert
        mockMvc.perform(delete("/reservas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
        mockMvc.perform(get("/reservas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)));
    }

}
